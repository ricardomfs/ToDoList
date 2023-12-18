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
