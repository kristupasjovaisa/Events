INSERT INTO users(user_id, name, location, birthday, description)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'Petras', 'Panevezys', '2004-04-04', 'vakarelis1'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'Antanas', 'Kaunas', '2005-05-05', 'vakarelis2'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991343', 'Darius', 'Vilnius', '2006-06-06', 'vakarelis3');

INSERT INTO events(event_id, name, location, start_event_date,end_event_date, description, owner_id)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991344', 'Pirmas', 'moletai', '2007-04-04T20:20:00','2007-05-04T20:20:00', 'smagu', 1),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991345', 'Antras', 'jurbarkas', '2008-04-04T20:21:00','2008-05-04T20:21:00', 'labai', 2),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991346', 'Trecias', 'zarasai', '2009-05-04T20:22:00', '2009-05-04T20:22:00','buvo', 3);


INSERT INTO events_users(users_id, events_id)
VALUES (1, 1),
       (2, 1),
       (3, 1);


