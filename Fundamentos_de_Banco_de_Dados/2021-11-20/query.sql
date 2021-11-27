-- 1 - FUS que calcule a média de valor unitário dos produtos vendidos num mês de sua escolha.
SELECT produtos.descricao, AVG(produtos.valor_unit) as valor_media  FROM notas 
	JOIN notas_itens
    	on notas_itens.id_nota = notas.id
    JOIN produtos
    	on notas_itens.id_produto = produtos.id
WHERE EXTRACT(MONTH FROM notas.data_emissao) = 12
GROUP BY produtos.id
ORDER BY valor_media DESC;

-- 2 - FUS que mostre os a quantidade de produtos que foram comprados pelos clientes
-- cujo o nome começa com Maria. Pode mostrar o nome do produto, o nome da Maria
-- (similar) e a quantidade comprada. Similar porque podem ter várias Marias.
SELECT
	clientes.id,
    clientes.nome as cliente,
    produtos.descricao as produto,
    notas_itens.quantidade as quantidade
	FROM notas 
      JOIN notas_itens
          on notas_itens.id_nota = notas.id
      JOIN produtos
          on notas_itens.id_produto = produtos.id
      JOIN clientes
          on notas.id_cliente = clientes.id
WHERE clientes.nome LIKE '%Maria%'
ORDER by clientes.id ASC;

-- 3 - NA consulta anterior, acrescente saber qual foi o produto que mais foi comprado.
SELECT clientes.id, clientes.nome as cliente, produtos.descricao as produto, notas_itens.quantidade as quantidade FROM notas 
	JOIN notas_itens
    	on notas_itens.id_nota = notas.id
    JOIN produtos
    	on notas_itens.id_produto = produtos.id
    JOIN clientes
    	on notas.id_cliente = clientes.id
WHERE clientes.nome LIKE '%Maria%' AND notas_itens.quantidade = (
      SELECT MAX(notas_itens.quantidade) FROM notas 
          JOIN notas_itens
              on notas_itens.id_nota = notas.id
          JOIN clientes
              on notas.id_cliente = clientes.id
      WHERE clientes.nome LIKE '%Maria%'
    ) 
ORDER by notas_itens.quantidade DESC;

-- 4 - qual o produto mais caro quem um cliente comprou num determinado período (sua escolha).
SELECT descricao, valor_unit  FROM produtos 
WHERE produtos.valor_unit = (
      SELECT MAX(produtos.valor_unit) FROM notas 
        JOIN notas_itens
            on notas_itens.id_nota = notas.id
        JOIN produtos
            on notas_itens.id_produto = produtos.id
      WHERE notas.data_emissao >= '2020-12-01' AND notas.data_emissao <= '2020-12-31'
    ) 