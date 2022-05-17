DROP TABLE IF EXISTS users_events;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(20)    NOT NULL
);

DROP TABLE IF EXISTS events;
CREATE TABLE events
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(20)    NOT NULL
);

CREATE TABLE users_events
(
    users_id BIGINT,
    events_id BIGINT,
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (events_id) REFERENCES events(id)
);

