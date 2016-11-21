Test case for REST-like web service that allows clients to share plain-text entries (pastes).

The service should allow client to create public and private entries. Private entries could only be accessed by direct link while public entries a available in global entries list accessible by everyone. Entry could be configured to expire after some date/time. Client could edit or delete entry only if he/she supplies a secret code returned by the service in response on new entry request.

Requirements

POST /entries - registers new entry. request parameters:
body - contents
title - optional name/title
expires - optional entry exiration timestamp
private - optional flag indicating that entry is private and shouldn't be added to list of entries
GET /entries - returns a paginated list of public entries sorted by creation date in descending order
PUT /entries/:entry-id - update existing entry. accepts same aguments as #1. also requires secret parameter containing the secret code for that entry
DELETE /entries/:entry-id - removes existing entry. requires secret code
Service should expose web-socket endpoint under /latest path. All clients connected/subscribed to the endpoint should be receive all new public entries
Service should support JSON (application/json) content type and x-www-form-urlencoded where appropriate
Service should be implemented in Java language (Java8) with Vert.x 3.3 framework and use Cassandra 3.x as a persistent storage
Deliverables

Archive or URL to public git repo containing

Maven3/Gradle-based project
Unit/Integration tests integrated into build process
Dockerfile to create ready-to-run docker image
Cassandra database schema definition

# pastebin

Additional comments on Cassandra schema.
First requirement to support basic CRUD operations is a trivial task and results in schema with unique id as partion key.

<pre>
CREATE TABLE pastebin_entries (
    entry_uuid uuid,
    created_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    PRIMARY KEY(entry_uuid)
    );
</pre>
Although, logic behind `is_private` field requires filtering of rows in such column family (hereinafter cf) 
and filtering is really bad case for Cassandra usage.
One solution to this issue is denormalization of data into 2 cfs based on `is_private` field value:

<pre>
CREATE TABLE private_entries (
    entry_uuid uuid,
    created_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    PRIMARY KEY(entry_uuid)
    );
    
 CREATE TABLE private_entries (
    entry_uuid uuid,
    created_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    PRIMARY KEY(entry_uuid)
    );  
</pre> 
 This solution leads to another problem - synchronization between these 2 cfs. 
 Taking into account distributed nature of Cassandra and eventual consistensy we need 
 a tool to reliably retrieve true value at certain point of time if both cfs contain entries with same id.
 Such situation can happen only in case of modification of entry, thus we can store modification time and the entry with the latest
 modification time is the true one. Thus, we have following schema so far:

<pre>
 CREATE TABLE private_entries (
    entry_uuid uuid,
    created_at timestamp,
    modified_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    PRIMARY KEY(entry_uuid)
    );

CREATE TABLE public_entries (
    entry_uuid uuid,
    created_at timestamp,
    modified_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    PRIMARY KEY(entry_uuid)
    );
 </pre>
  Second major requirement is to sort public entries by creation time. Cassandra automatically sorts rows by clustering key,
 but only within partion defined by partion key. In order to sort all values we will need such partion key that is equal in
 all rows, i.e. constant (dummy). Such constant partion key will lead to "hot spots", but since our task is semi-synthetic
 we can accept it. In real life situation we would need to question our data model. 
 
 <br/>  Also we need to include created_at field into primary key as clustering key, 
 but it will require 
 "read-before-write" during updates. So we need to find another solution - denormalize again. 
 Fortunately, Cassandra 3 materialized view feature saves us from burden of synchronization with just another cf. And since
 we can add only one column into primary key of materialized view we need to introduce our constant key as part of 
 primary key for public_entries cf. Our final result looks like:
 <pre>
 CREATE TABLE private_entries (
    entry_uuid uuid,
    created_at timestamp,
    modified_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    PRIMARY KEY(entry_uuid)
    );

CREATE TABLE public_entries (
    entry_uuid uuid,
    created_at timestamp,
    modified_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    dummy int,
    PRIMARY KEY(entry_uuid, dummy)
    );

CREATE MATERIALIZED VIEW latest_entries
AS SELECT *
FROM public_entries
WHERE entry_uuid IS NOT NULL AND created_at IS NOT NULL AND dummy IS NOT NULL
PRIMARY KEY(dummy, created_at, entry_uuid)
WITH CLUSTERING ORDER BY  (created_at DESC);
</pre>

There is another requirement to check secret before modification. We could store it in separe cf (entry_uuid, secret), 
but since our rows are not that heavy we store it inside main cfs.
