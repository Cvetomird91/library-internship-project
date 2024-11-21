CREATE TABLE Users
(
    id         INT         NOT NULL,
    username   VARCHAR(64) NOT NULL,
    email      VARCHAR(64) NOT NULL,
    password   VARCHAR(64) NOT NULL,
    role       VARCHAR(64) NOT NULL,
    created_at TIMESTAMP   NOT NULL
);
CREATE TABLE Roles
(
    id   INT         NOT NULL,
    name VARCHAR(64) NOT NULL
);
ALTER TABLE users
DROP column id;
ALTER TABLE users
ADD id SERIAL PRIMARY KEY;