SELECT * FROM alocacoes WHERE data_alocacao >= '2021-09-01' AND data_alocacao <= '2021-09-30';
SELECT * FROM clientes WHERE nome LIKE "%silva%";

SELECT * FROM marcas;
SELECT * FROM carros;
SELECT * FROM alocacoes;
SELECT * FROM carros
	INNER JOIN marcas
    	ON marcas.id = carros.id;