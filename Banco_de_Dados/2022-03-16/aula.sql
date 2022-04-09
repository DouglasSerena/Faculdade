SELECT   clientes.nome, SUM(transacoes.valor) as total 
FROM     transacoes
	INNER JOIN clientes 
		ON clientes.id = transacoes.cliente_id
GROUP BY clientes.nome
ORDER BY total DESC;

INSERT INTO clientes (nome) VALUES
	("Zoerandir"),
	("Aegpe"),
	("Varod"),
	("Fleadan"),
	("Bomathalion"),
	("Luauil"),
	("Linxuion"),
	("Halor"),
	("Hoyor");
    
INSERT INTO transacoes (valor, data_emissao, cliente_id) VALUES
	(23, "2022-03-04", 2),
	(5, "2022-03-09", 3),
	(75, "2022-03-21", 1),
	(53, "2022-03-05", 5),
	(24, "2022-03-06", 2),
	(86, "2022-03-04", 3),
	(12, "2022-03-04", 4),
	(23, "2022-03-07", 2),
	(68, "2022-03-02", 1),
	(23, "2022-03-26", 5),
	(50, "2022-03-07", 4),
	(85, "2022-03-12", 3),
	(74, "2022-03-17", 2),
	(5, "2022-03-23", 1);

CREATE TABLE clientes (
	id int auto_increment not null primary key,
    nome varchar(100)
);

CREATE TABLE transacoes (
	id int auto_increment not null primary key,
    valor decimal(18, 2) not null,
    data_emissao datetime not null,
    cliente_id int not null,
	CONSTRAINT transacoes_clientes
		FOREIGN KEY (cliente_id)
			REFERENCES clientes(id)
				ON DELETE RESTRICT
				ON UPDATE CASCADE
);


SELECT   clientes.nome, SUM(transacoes.valor) as total 
FROM     transacoes
	INNER JOIN clientes 
		ON clientes.id = transacoes.cliente_id
GROUP BY clientes.nome
HAVING   total > 100
ORDER BY total DESC;


SELECT   clientes.nome, SUM(transacoes.valor) as total 
FROM     transacoes
	INNER JOIN clientes 
		ON clientes.id = transacoes.cliente_id
WHERE    transacoes.valor > 50
GROUP BY clientes.nome
HAVING   total > 100
ORDER BY total DESC;