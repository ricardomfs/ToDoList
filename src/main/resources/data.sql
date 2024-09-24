CREATE TABLE my_user(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username    VARCHAR(255) UNIQUE NOT NULL,
    password    VARCHAR(255) NOT NULL
);
CREATE TABLE my_role(
    id          BIGINT PRIMARY KEY NOT NULL,
    descricao    VARCHAR(255)
);
INSERT INTO my_role(id, descricao)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');

INSERT INTO my_user (username, password)
VALUES
    ('testilson', '$2a$12$xSQ4emNq7injzBBgmyhJROisGLJsYoic8eGmi/85oFmgBI2tTN.BO'),
    ('user2', '$2a$12$1eOb7yaikHPkMS.J/FazR.8A8vfQ.3ctjo6nVk86WS6Q/M0J1y1Fm'),
    ('user3', '$2a$12$a.snhG05/9jwojkSd4T5vujh6wwj7GYUJ60YM3EYEsfWNUlTcKr7u');

CREATE TABLE lista(
    id      BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255) NOT NULL,
    my_user BIGINT NOT NULL,
    FOREIGN KEY (my_user) REFERENCES my_user(id)
);

INSERT INTO lista (name, my_user)
VALUES
    ('My First List', 1),
    ('My Second List', 1);

CREATE TABLE item(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    prazo       DATE NOT NULL,
    completed   BOOLEAN NOT NULL,
    lista       BIGINT NOT NULL,
    FOREIGN KEY(lista) REFERENCES lista(id)
);

INSERT INTO item (name, prazo, completed, lista)
VALUES
    ('item 1', '2024-12-01', true, 1),
    ('item 2', '2024-12-02', false, 1),
    ('item 3', '2024-12-03', false, 1),
    ('item 4', '2024-12-04', false, 1),
    ('item 5', '2024-12-05', false, 1);