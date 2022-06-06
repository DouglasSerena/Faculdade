INSERT INTO `autores` (nome, cpf, endereco, data_nascimento, nacionalidade) 
	VALUES 
		("João Carlos", "00000000000", "R. Casa show, 523 - Capão da Canoa, 95555-000 - RS", "2001-03-26", "Brasil"),
        ("Douglas Serena", "00000000000", "R. Casa show, 523 - Capão da Canoa, 95555-000 - RS", "2001-03-26", "Brasil"),
        ("Aline Silva", "00000000000", "R. Casa show, 523 - Capão da Canoa, 95555-000 - RS", "2001-03-26", "Brasil"),
        ("João Oliveira", "00000000000", "R. Casa show, 523 - Capão da Canoa, 95555-000 - RS", "2001-03-26", "Brasil"),
        ("José pedro", "00000000000", "R. Casa show, 523 - Capão da Canoa, 95555-000 - RS", "2001-03-26", "Brasil");

INSERT INTO `editoras` (nome) 
	VALUES 
		("Mirandela Editora"),
        ("Editora Via-norte"),
        ("Editora Ilhas Tijucas"),
        ("Maria José Editora");
        
INSERT INTO `assuntos` (sigla, descricao) 
		("B", "Banco de Dados"),
        ("P", "Programação"),
        ("R", "Redes"),
        ("S", "Sistemas Operacionais");
        
INSERT INTO `livros` (titulo, preco, lancamento, assunto_sigla, editora_id) 
	VALUES 
		("Banco de Dados para a Web", 31.20, "1999-01-10", "B", 1),
		("Programando em Linguagem C", 30.00, "1997-10-01", "P", 1),
		("Programando em Linguagem C++", 111.50, "1998-11-01", "P", 3),
		("Banco de Dados na Bioinformática", 48.00, "1998-07-03", "B", 2),
		("Redes de Computadores", 42.
	VALUES 00, "1996-09-01", "R", 2);
		
INSERT INTO `autores_livros` (autor_id, livro_id) 
	VALUES
		(1, 2),
		(2, 3),
		(1, 4),
		(3, 2),
		(4, 1);
		
ALTER TABLE `autores_livros` RENAME COLUMN autore_id TO autor_id;
ALTER TABLE `livros` RENAME COLUMN lancamento TO data_lancamento;