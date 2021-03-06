DROP TABLE IF EXISTS users_events;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS file;

CREATE TABLE users
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      UUID         NOT NULL,
    nickname     VARCHAR(20)  NOT NULL,
    city         VARCHAR(50)  NOT NULL,
    email        VARCHAR(50)  NOT NULL,
    password     VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20)  NOT NULL
);

CREATE TABLE events
(
    id                    BIGSERIAL PRIMARY KEY,
    event_id              UUID         NOT NULL,
    name                  VARCHAR(20)  NOT NULL,
    location              VARCHAR(50)  NOT NULL,
    category              VARCHAR(50)  NOT NULL,
    price                 DECIMAL(20, 2),
    start_event_date_time TIMESTAMP    NOT NULL,
    end_event_date_time   TIMESTAMP    NOT NULL,
    description           VARCHAR(350) NOT NULL,
    owner_id              BIGSERIAL,
    FOREIGN KEY (owner_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE events_users
(
    users_id  BIGINT NOT NULL,
    events_id BIGINT NOT NULL,
    FOREIGN KEY (users_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (events_id) REFERENCES events (id) ON DELETE CASCADE
);

CREATE TABLE file
(
    id                BIGSERIAL PRIMARY KEY,
    file_id           UUID           NOT NULL,
    file_name         VARCHAR(100)   NOT NULL,
    file_extension    VARCHAR(15)    NOT NULL,
    media_type        VARCHAR(10)    NOT NULL,
    size              BIGINT         NOT NULL,
    timestamp         TIMESTAMP      DEFAULT current_timestamp
);

