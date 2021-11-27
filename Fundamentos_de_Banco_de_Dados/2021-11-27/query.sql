-- função de agregação (minimo 2. ex. Sum, count)
-- joins
-- group by
-- having

-- Pegar o serviço mais caro
SELECT servicos.descricao, MAX(servicos.valor) as max_valor
FROM servicos
GROUP BY servicos.id
ORDER BY max_valor DESC
LIMIT 1

-- Contabilizar a quantidade arrecadada entre o dia 20 a 25 de dezembro
SELECT SUM(servicos.valor) as total
FROM notas
	JOIN notas_servicos
    	ON notas_servicos.id_nota = notas.id
	JOIN servicos
    	ON notas_servicos.id_servico = servicos.id
WHERE notas.data_emissao >= '2020-12-20' AND notas.data_emissao >= '2020-12-25';

-- Pegar os serviços com a quantidade maior que 2
SELECT COUNT(servicos.id) as quantidade, servicos.descricao
FROM servicos
GROUP BY servicos.descricao
HAVING COUNT(servicos.id) >= 2



