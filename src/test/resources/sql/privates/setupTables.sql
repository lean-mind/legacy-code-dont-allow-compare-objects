DROP TABLE IF EXISTS recipes;
CREATE TABLE recipes
(
    id     UUID PRIMARY KEY,
    name   VARCHAR(30)
);

DROP TABLE IF EXISTS ingredients;
CREATE TABLE ingredients
(
    id     INT PRIMARY KEY,
    name   VARCHAR(30)
);
