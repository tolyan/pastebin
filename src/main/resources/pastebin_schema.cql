CREATE KEYSPACE pastebin WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

CREATE TABLE pastebin_entries (
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
FROM pastebin_entries
WHERE entry_uuid IS NOT NULL AND created_at IS NOT NULL AND dummy IS NOT NULL
PRIMARY KEY(dummy, created_at, entry_uuid)
WITH CLUSTERING ORDER BY  (created_at DESC);

DROP MATERIALIZED VIEW latest_entries;

CREATE TABLE latest_entries (
    entry_uuid uuid,
    created_at timestamp,
    modified_at timestamp,
    title text,
    body text,
    expires_at timestamp,
    secret text,
    is_private boolean,
    partioner int,
    PRIMARY KEY(partioner, created_at)
    ) WITH CLUSTERING ORDER BY  (created_at DESC);

CREATE INDEX ON latest_entries(is_private);

CREATE MATERIALIZED VIEW entries_by_id
AS SELECT *
FROM pastebin_entries
WHERE is_private IS NOT NULL AND entry_uuid IS NOT NULL AND created_at IS NOT NULL
PRIMARY KEY(entry_uuid, is_private, created_at);

INSERT into pastebin_entries(entry_uuid, dummy, created_at, title, is_private)  values(now(), 1, toUnixTimestamp(now()), 'title', true);



