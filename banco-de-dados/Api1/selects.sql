/* Faça um SQL para exibir os filmes cadastrados e suas respectivas categorias. */
SELECT * FROM filmes
    JOIN categorias
        ON categorias.id = filmes.categoria_id;

/* Faça um SQL para exibir quantos filmes há para cada categoria. */
SELECT categorias.id, categorias.nome, COUNT(filmes.id) AS quantidade_filmes FROM categorias
    JOIN filmes
        ON filmes.categoria_id = categorias.id
GROUP BY categorias.id;

/* Faça um SQL para exibir o nome de todos os clientes e se houver locação, mostrar quais os filmes que eles (cada um) tem locado. */
SELECT clientes.id, clientes.prenome, clientes.sobrenome, filmes.titulo FROM clientes
    LEFT JOIN locacoes
        ON locacoes.cliente_id = clientes.id
    LEFT JOIN filmes_locacoes
        ON filmes_locacoes.locacao_id = locacoes.id
    LEFT JOIN filmes
        ON filmes.id = filmes_locacoes.filme_id
GROUP BY clientes.id, clientes.prenome, clientes.sobrenome, filmes.titulo;

/* Faça um SQL para saber qual titulo do filme que tem o maior número de locações. */
SELECT filmes.titulo, COUNT(filmes_locacoes.locacao_id) as quantidade_locacao FROM filmes_locacoes
    JOIN filmes
        ON filmes.id = filmes_locacoes.filme_id
GROUP BY filmes.titulo
ORDER BY quantidade_locacao DESC
LIMIT 1;

/* Faça uma View que de condições de um client consultar filmes que foram e que não foram locados. Teste a View mostrando os dois resultados. Lista dos filmes locados e não locados. */
CREATE VIEW filmes_alocados_view
AS
	SELECT filmes.id AS filme_id, filmes.titulo, clientes.id AS cliente_id, clientes.prenome, clientes.sobrenome, locacoes.id AS locacao_id, locacoes.data_retirada, locacoes.data_entrega FROM filmes
		LEFT JOIN filmes_locacoes
			ON filmes_locacoes.filme_id = filmes.id
		LEFT JOIN locacoes
			ON locacoes.id = filmes_locacoes.locacao_id
		LEFT JOIN clientes
			ON clientes.id = locacoes.cliente_id
	ORDER BY filmes.id;

/* Alocado */
SELECT * FROM filmes_alocados_view
WHERE locacao_id IS NOT NULL;

/* Não alocado */
SELECT * FROM filmes_alocados_view
WHERE locacao_id IS NULL;