CREATE TABLE USER (
                         id INT PRIMARY KEY,
                         user_id UUID NOT NULL,
                         nickname VARCHAR(20) NOT NULL,
                         location INT NOT NULL,
                         birthday DATE (20) NOT NULL,
                         description VARCHAR(500) DEFAULT NULL
);