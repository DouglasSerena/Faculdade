INSERT INTO tipos_socios (descricao)
	VALUES 
    	("Metade"),
			("Inteiro");
        
INSERT INTO socios (tipo_socio_id, telefone, nome, endereco)
	VALUES
    	(1, '00000000000', 'Douglas Serena', 'Barão do Rio branco 152'),
			(2, '00000000000', 'Cassio Costa', 'Barão do Rio branco 152'),
			(1, '00000000000', 'Carlos Silva', 'Outra rua');
        
INSERT INTO servicos (descricao, valor)
	VALUES 
    	('Limpeza de Escritório', 400),
    	('Limpeza de Piscina', 700),
    	('Limpeza de Casa', 500);

INSERT INTO pedidos_servicos(socio_id, servico_id, data_referencia)
	VALUES
		(1, 2, NOW()),
		(2, 1, '2021-01-17'),
		(3, 3, '2021-01-30');