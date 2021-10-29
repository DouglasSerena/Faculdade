INSERT INTO pesquisadores (nome)
	VALUES 
    	("Douglas Schneider"),
			("João Silva"),
			("Cassio Costa"),
			("Lucas Silva"),
			("João oliviera");

INSERT INTO artigos (id, pesquisador_id, titulo, pagina_inicial, pagina_final,  editor)
	VALUES 
    	(1, 1, "Carro de 9 rodas", 1, 2, "Saraiva"),
    	(20, 1, "Carro de 11 rodas", 1, 2, "Saraiva"),
    	(1234, 1, "Carro de 13 rodas", 1, 2, "Silva");
        
INSERT INTO periodicos (titulo, artigo_id)
	VALUES
    	("20/10/20021 - versão 1", 1234),
			("20/10/20021 - versão 1", 1),
			("20/11/20021 - versão 2", 1234),
			("20/12/20021 - versão 3", 1234);
