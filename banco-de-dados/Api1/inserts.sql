INSERT INTO categorias (nome)
    VALUES ("Ação"),("Comedia"),("Drama"),("Corrida");

INSERT INTO filmes (numero, titulo, quantidade_exemplares, categoria_id)
    VALUES 
        ("2", "Corrida top", 2, 4),
        ("4", "Corrida Maluca", 2, 4),
        ("2", "Ação e aventura", 2, 1),
        ("1", "The batman", 2, 1),
        ("7", "Lucura", 2, 2),
        ("5", "Barbe", 2, 3),
        ("3", "Viatura", 2, 3),
        ("0", "Mar", 2, 3);

INSERT INTO clientes (prenome, sobrenome, fone, endereco, numero_associado)
    VALUES 
        ("Douglas", "Serena", "2213123", "R. Mane leandro", 20),
        ("Amanda", "Serena", "2213123", "R. Mane leandro", 20),
        ("Jonh", "Serena", "2213123", "R. Mane leandro", 20);

INSERT INTO locacoes (data_retirada, cliente_id)
    VALUES 
        ("2022-03-20", 1),
        ("2022-03-01", 2),
        ("2022-03-12", 2),
        ("2022-03-05", 1),
        ("2022-03-17", 3),
        ("2022-03-19", 1),
        ("2022-03-25", 3),
        ("2022-03-11", 3);

INSERT INTO filmes_locacoes (filme_id, locacao_id)
    VALUES 
        (1, 1),
        (2, 3),
        (3, 2),
        (4, 2),
        (6, 1),
        (3, 6),
        (5, 7);
