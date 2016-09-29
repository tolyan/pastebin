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
 Such sition can happen only in case of modification of entry, thus we can store modification time and entry with the latest 
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
 but only withing partion defined by partion key. In order to sort all values we will need such partion key that is equal in
 all rows, i.e. constant (dummy). Such constant partion key will lead to "hot spots", but since our task is sem-synthetic
 we can accept it. In real life situation we would need to question our data model. 
 
 <br/>  Also we need to include created_at field into primary key as clustering key, 
 but it will require 
 "read-before-write" during updates. So we need to find another solution - denormalize again. 
 Fortunatly, Cassandra 3 materialized view feater saves us from burden of synchronization with just another cf. And since 
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
