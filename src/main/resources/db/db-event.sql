CREATE TABLE EVENT (
                      id INT PRIMARY KEY,
                      event_id UUID NOT NULL,
                      name VARCHAR(20) NOT NULL,
                      location INT NOT NULL,
                      dateTime DATE (20) NOT NULL,
                      description VARCHAR(500) DEFAULT NULL
);