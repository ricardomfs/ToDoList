INSERT INTO projeto (id, name, descricao) VALUES
    (1, 'Projeto teste', 'Descricao para teste1');

INSERT INTO lista (id, name, data_de_criacao, lista_has_projeto)
VALUES
    (1, 'Lista teste1', '2023-12-11', 1),
    (2, 'Lista teste2', '2023-12-12', 1);

INSERT INTO itens (id, name, prazo, descricao, is_completed, item_has_lista)
VALUES
    (1, 'Lista teste1', '2023-12-11', 'Descricao para teste1', 0, 1),
    (2, 'Lista teste2', '2023-12-12', 'Descricao para teste2', 0, 1),
    (3, 'Lista teste3', '2023-12-12', 'Descricao para teste3', 0, 1),
    (4, 'Lista teste4', '2023-12-12', 'Descricao para teste4', 0, 1);