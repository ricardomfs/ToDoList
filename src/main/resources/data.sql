CREATE TABLE my_user(
    id          BIGINT PRIMARY KEY NOT NULL,
    username    VARCHAR(255) UNIQUE,
    password    VARCHAR(255)
);
CREATE TABLE my_role(
    id          BIGINT PRIMARY KEY NOT NULL,
    descricao    VARCHAR(255)
);
INSERT INTO my_role(id, descricao)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');