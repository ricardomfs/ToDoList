INSERT INTO projeto (name, descricao) VALUES
    ('Projeto teste', 'Descricao para teste1');

INSERT INTO lista (name, data_de_criacao, lista_has_projeto)
VALUES
    ('Lista teste1', '2023-12-11', 1),
    ('Lista teste2', '2023-12-12', 1);

INSERT INTO itens (name, prazo, descricao, is_completed, item_has_lista)
VALUES
    ('Lista teste1', '2023-12-11', 'Descricao para teste1', 0, 1),
    ('Lista teste2', '2023-12-12', 'Descricao para teste2', 0, 1),
    ('Lista teste3', '2023-12-12', 'Descricao para teste3', 0, 1),
    ('Lista teste4', '2023-12-12', 'Descricao para teste4', 0, 1);

INSERT INTO comentario (descricao, data_de_criacao, item)
VALUES
    ('Comentario de teste 1', '2023-12-11', 1),
    ('Comentario de teste 2', '2023-10-31', 2),
    ('Comentario de teste 3', '2023-05-26', 3),
    ('Comentario de teste 4', '2023-08-22', 4);

INSERT INTO my_roles (descricao)
VALUES
    ('ROLE_GUEST'),
    ('ROLE_USER'),
    ('ROLE_ADMIN');