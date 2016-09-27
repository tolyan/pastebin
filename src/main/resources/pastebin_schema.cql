CREATE KEYSPACE pastebin WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

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



