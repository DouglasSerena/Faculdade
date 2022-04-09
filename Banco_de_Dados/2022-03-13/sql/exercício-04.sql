-- #1 Exercício
SELECT COUNT(*) FROM vendas;

-- #2 Exercício
SELECT livros.titulo, livros.valor, categorias.nome AS categoria FROM livros
	JOIN categorias
		ON categorias.id = livros.categoria_id
WHERE categorias.nome = 'Música';

-- #3 Exercício
SELECT livros.titulo, livros.valor, autores.nome AS autor, clientes.nome AS comprador, cidades.nome AS cidade, cidades.uf FROM livros
	JOIN autores
		ON autores.id = livros.autor_id
    JOIN vendas
		ON vendas.livro_id = livros.id
	JOIN clientes
		ON clientes.id = vendas.cliente_id
	JOIN cidades
		ON cidades.id = clientes.cidade_id
WHERE livros.valor > 300;

-- #4 Exercício
SELECT clientes.nome AS cliente, livros.titulo FROM clientes
	JOIN vendas
		ON vendas.cliente_id = clientes.id
	JOIN livros
		ON livros.id = vendas.livro_id
ORDER BY clientes.nome;

-- #5 Exercício
SELECT livros.id, livros.titulo, autores.nome AS autor FROM livros
	JOIN autores
		ON autores.id = livros.autor_id
	JOIN vendas
		ON vendas.livro_id = livros.id
WHERE vendas.data >= '2021-03-01' AND vendas.data <= '2021-03-31';

-- #6 Exercício
SELECT livros.titulo, autores.nome AS autor FROM livros
	JOIN autores
		ON autores.id = livros.autor_id
	JOIN vendas
		ON vendas.livro_id = livros.id
WHERE vendas.data >= '2022-01-01' AND vendas.data <= '2022-01-31'
ORDER BY vendas.quantidade
LIMIT 5;

-- #7 Exercício
SELECT clientes.nome FROM clientes
	JOIN vendas
		ON vendas.cliente_id = clientes.id
	JOIN livros
		ON livros.id = vendas.livro_id
WHERE livros.titulo = 'Banco de dados powerfu';