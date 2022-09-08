INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO CUSTOMER(id, name) VALUES (1, 'John Doe');
INSERT INTO CUSTOMER(id, name) VALUES (2, 'Jane Doe');
INSERT INTO CUSTOMER(id, name) VALUES (3, 'Jack Doe');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO LOAN(id, customer_id, game_id, loan_date, return_date) VALUES (1, 2, 1, '2020-01-01', '2020-01-15');
INSERT INTO LOAN(id, customer_id, game_id, loan_date, return_date) VALUES (2, 1, 2, '2020-01-01', '2020-01-15');
INSERT INTO LOAN(id, customer_id, game_id, loan_date, return_date) VALUES (3, 3, 3, '2020-01-01', '2020-01-15');
INSERT INTO LOAN(id, customer_id, game_id, loan_date, return_date) VALUES (4, 1, 4, '2020-01-01', '2020-01-15');
INSERT INTO LOAN(id, customer_id, game_id, loan_date, return_date) VALUES (5, 2, 5, '2020-01-01', '2020-01-15');
INSERT INTO LOAN(id, customer_id, game_id, loan_date, return_date) VALUES (6, 3, 6, '2020-01-01', '2020-01-15');