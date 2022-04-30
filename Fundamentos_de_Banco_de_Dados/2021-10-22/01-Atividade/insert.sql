INSERT INTO clientes (nome, cpf, telefone, endereco)
	VALUES 
    	("Douglas Schneider", "00000000000", "000000000", "Rua tres prato"),
			("Aline Silva", "00000000000", "000000000", "Rua tres prato"),
			("Cassio Costa", "00000000000", "000000000", "Rua tres prato"),
			("Lucas Silva", "00000000000", "000000000", "Rua tres prato"),
			("Ana oliviera", "00000000000", "000000000", "Rua tres prato");
        
INSERT INTO marcas (nome)
	VALUES 
    	("Fiat"), ("Ford"), ("Chevrolet");
        
INSERT INTO carros (placa, marca_id, modelo, ano)
	VALUES 
    	("das2313", 1, "uno", 2000),
    	("khe2633", 2, "k", 1999),
    	("ljv9723", 3, "celta", 2001),
    	("ybf7831", 3, "corsa", 2005);
        
INSERT INTO alocacoes (cliente_id, carro_id, data_alocacao, valor)
	VALUES
    	(1, 2, "2021-09-23", 200),
        (3, 4, "2021-10-12", 250),
        (2, 1, "2021-09-01", 200);