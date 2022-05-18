DROP TABLE IF EXISTS users_events;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id     UUID         NOT NULL,
    name        VARCHAR(20)  NOT NULL,
    location    VARCHAR(50)  NOT NULL,
    birthday    DATE         NOT NULL,
    description VARCHAR(350) NOT NULL

);

DROP TABLE IF EXISTS events;
CREATE TABLE events
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    event_id       UUID         NOT NULL,
    name           VARCHAR(20)  NOT NULL,
    location       VARCHAR(50)  NOT NULL,
    start_event_date DATE         NOT NULL,
    end_event_date   DATE         NOT NULL,
    description    VARCHAR(350) NOT NULL,
    owner_id       BIGINT,
    FOREIGN KEY (owner_id) REFERENCES users (id)
);

CREATE TABLE events_users
(
    users_id  BIGINT,
    events_id BIGINT,
    FOREIGN KEY (users_id) REFERENCES users (id),
    FOREIGN KEY (events_id) REFERENCES events (id)
);

