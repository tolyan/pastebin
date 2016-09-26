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
    PRIMARY KEY(is_private, created_at)
    ) WITH CLUSTERING ORDER BY  (created_at DESC);


CREATE MATERIALIZED VIEW entries_by_id
AS SELECT *
FROM pastebin_entries
WHERE is_private IS NOT NULL AND entry_uuid IS NOT NULL AND created_at IS NOT NULL
PRIMARY KEY(entry_uuid, is_private, created_at);

INSERT into pastebin_entries(entry_uuid, created_at, title, is_private)  values(now(), toUnixTimestamp(now()), 'title', true);



