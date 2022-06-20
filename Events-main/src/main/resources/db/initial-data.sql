INSERT INTO users(user_id, nickname, city, email, password, phone_number)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'admin', 'Panevezys', 'af@gmail.com', '$2a$10$U0rw8mXTThEiAWkjTdcwPO5Zy0PXklz/QuzuxW95N2y1P10SORJjC',
        '+37066655584'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'guest', 'Kaunas', 'gf@gmail.com','$2a$10$o2xZA.yF/bZbADZSplayteNUH7DQOf35CBh6ZbmjO0IiuHn8fmUzO',
        '+37066655884'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991343', 'Darius', 'Vilnius', 'mf@gmail.com', 'slaptazodis',
        '+37066655784');

INSERT INTO events(event_id, name, location, category, price, start_event_date_time, end_event_date_time, description,
                   owner_id)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991344', 'Pirmas', 'moletai', 'sportas', 1599.99, '2007-04-04T20:20:00',
        '2007-05-04T20:20:00',
        'smagu', 1),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991345', 'Antras', 'jurbarkas', 'laisvalaikis', 1000.99, '2008-04-04T20:21:00',
        '2008-05-04T20:21:00',
        'labai', 2),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991346', 'Trecias', 'zarasai', 'kovinis', 10.99, '2009-05-04T20:22:00',
        '2009-05-04T20:22:00',
        'buvo', 3);


INSERT INTO events_users(users_id, events_id)
VALUES (1, 1),
       (2, 1),
       (3, 1);


