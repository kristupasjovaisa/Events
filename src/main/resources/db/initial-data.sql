INSERT INTO users(user_id, nickname, location, email, birthday, password, phone_number, description)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'Petras', 'Panevezys', 'af@gmail.com', '2004-04-04', 'slaptazodis',
        '+37066655584', 'vakarelis1'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'Antanas', 'Kaunas', 'gf@gmail.com', '2005-05-05', 'slaptazodis',
        '+37066655884',
        'vakarelis2'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991343', 'Darius', 'Vilnius', 'mf@gmail.com', '2006-06-06', 'slaptazodis',
        '+37066655784',
        'vakarelis3');

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


