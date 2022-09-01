DROP TABLE IF EXISTS CATEGORY;

CREATE TABLE CATEGORY (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS AUTHOR;

CREATE TABLE AUTHOR (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(400) NOT NULL,
    nationality VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS GAME;

CREATE TABLE GAME (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    age VARCHAR(3) NOT NULL,
    category_id BIGINT DEFAULT NULL,
    author_id BIGINT DEFAULT NULL
);

ALTER TABLE GAME ADD FOREIGN KEY (category_id) REFERENCES CATEGORY(id);
ALTER TABLE GAME ADD FOREIGN KEY (author_id) REFERENCES AUTHOR(id);
