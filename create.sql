
CREATE DATABASE bug_tracker;

\c bug_tracker;

CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    username VARCHAR,
    email VARCHAR
);

CREATE TABLE IF NOT EXISTS bugs(
    id SERIAL PRIMARY KEY,
    content VARCHAR,
    status boolean,
    category VARCHAR,
    user_id int
);

CREATE TABLE IF NOT EXISTS comments(
    id SERIAL PRIMARY KEY,
    content VARCHAR,
    time_post timestamp,
    user_id int
);

CREATE DATABASE bug_tracker_test WITH TEMPLATE bug_tracker;