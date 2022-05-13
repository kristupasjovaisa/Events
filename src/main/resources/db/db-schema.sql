DROP TABLE IF EXISTS event_entity_members;

DROP TABLE IF EXISTS event_entity;
CREATE TABLE event
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(20)    NOT NULL
);

DROP TABLE IF EXISTS user_entity;
CREATE TABLE user
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    nickname              VARCHAR(20)    NOT NULL
);

CREATE TABLE events_users
(
    products_id   BIGINT,
    product_categories_id BIGINT
);