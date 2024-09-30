INSERT INTO my_user (username, password)
VALUES
    ('testilson', '$2a$12$xSQ4emNq7injzBBgmyhJROisGLJsYoic8eGmi/85oFmgBI2tTN.BO'),
    ('user2', '$2a$12$1eOb7yaikHPkMS.J/FazR.8A8vfQ.3ctjo6nVk86WS6Q/M0J1y1Fm'),
    ('user3', '$2a$12$a.snhG05/9jwojkSd4T5vujh6wwj7GYUJ60YM3EYEsfWNUlTcKr7u');

INSERT INTO lista (name, my_user)
VALUES
    ('My First List', 1),
    ('My Second List', 1);

INSERT INTO item (name, prazo, completed, lista)
VALUES
    ('item 1', '2024-12-01', true, 1),
    ('item 2', '2024-12-02', false, 1),
    ('item 3', '2024-12-03', false, 1),
    ('item 4', '2024-12-04', false, 1),
    ('item 5', '2024-12-05', false, 1);