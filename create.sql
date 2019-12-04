
CREATE DATABASE bug_tracker;

\c bug_tracker;

CREATE TABLE IF NOT EXISTS bugs(
    id SERIAL PRIMARY KEY,
    content VARCHAR,
    category VARCHAR
);

CREATE TABLE IF NOT EXISTS comments(
    id SERIAL PRIMARY KEY,
    username VARCHAR,
    content VARCHAR,
    time_post timestamp,
    upvote int,
    downvote int,
    bug_id int
);

CREATE DATABASE bug_tracker_test WITH TEMPLATE bug_tracker;