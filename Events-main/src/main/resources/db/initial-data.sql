INSERT INTO users(user_id, nickname, city, email, password, phone_number)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'ADMIN', 'Panevezys', 'af@gmail.com', '{bcrypt}$2a$10$U0rw8mXTThEiAWkjTdcwPO5Zy0PXklz/QuzuxW95N2y1P10SORJjC',
        '+37066655584'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'USER', 'Kaunas', 'gf@gmail.com','{bcrypt}$2a$10$auHiOfM5qK7.M2ghqP5X/.U2XOa2OjADI7X/6cM9MEI3HglrZuWLW',
        '+37066655884'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991343', 'Darius', 'Vilnius', 'mf@gmail.com', 'slaptazodis',
        '+37066655784');

INSERT INTO events(event_id, name, location, category, price, start_event_date_time, end_event_date_time, description,
                   owner_id)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991344', 'Pirmas', 'moletai', 'Sportas', 1599.99, '2007-04-04T20:20:00',
        '2007-05-04T20:20:00',
        'smagu', 1),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991345', 'Antras', 'jurbarkas', 'Festivalis', 1000.99, '2008-04-04T20:21:00',
        '2008-05-04T20:21:00',
        'labai', 2),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991346', 'Trecias', 'zarasai', 'Koncertas', 10.99, '2009-05-04T20:22:00',
        '2009-05-04T20:22:00',
        'buvo', 3);


INSERT INTO events_users(users_id, events_id)
VALUES (1, 1),
       (2, 1),
       (3, 1);

INSERT INTO authority(nickname)
VALUES
    ('ADMIN'),
    ('USER');

INSERT INTO users_authorities(user_entity_id, authorities_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);


