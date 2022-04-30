/* Escreva uma SP que receba, como parâmetro, o CPF de um autor e retorne a quantidade de livros escrito pelo mesmo. */

DROP PROCEDURE quantidade_livros_por_cpf;
CREATE PROCEDURE quantidade_livros_por_cpf (cpf VARCHAR(11))
BEGIN
	SELECT COUNT(*) FROM livros
		JOIN autores_livros
			ON autores_livros.livro_id = livros.id
		JOIN autores
			ON autores.id = autores_livros.autor_id
	WHERE autores.cpf = cpf;
END

CALL quantidade_livros_por_cpf('10000000000');

/* Crie uma SP que receba, como um parâmetro, a data de publicação de um livro e seu código. O procedimento deve atualizar a tabela de livros, especificando a data de lançamento para o livro em questão. */

DROP PROCEDURE publicar_livro;
CREATE PROCEDURE publicar_livro(livro_id INT, data_lancamento DATE)
BEGIN
	UPDATE livros SET livros.data_lancamento = data_lancamento
	WHERE livros.id = livro_id;
END

CALL publicar_livro(1, '2020-01-01');

/* Em algumas situações, SPs são utilizados para a manutenção da segurança do banco de dados. Nestes casos, realizamos inclusões, alterações e exclusões de dados, através de SPs. Crie SPs que recebem os parâmetros adequados e realizam as seguintes operações:
	a) Inserir uma linha na tabela de livros
	b) Excluir uma linha da tabela de livros
	c) Atualizar valores na tabela de livros
*/

DROP PROCEDURE nome;
CREATE PROCEDURE nome (valor INT)
BEGIN

END

/* Crie uma SP que aumente ou diminua o valor dos preços dos livros de uma editora específica. O aumento pode ser em percentual ou em valor. */

DROP PROCEDURE acrecimo_livro;
CREATE PROCEDURE acrecimo_livro (editora_id INT, valor FLOAT, tipo ENUM('VALOR', 'PORCENTAGEM'))
BEGIN
	DECLARE preco FLOAT DEFAULT 0;
	DECLARE novo_preco FLOAT DEFAULT 0;

	CASE tipo
		WHEN 'VALOR' THEN
			SET novo_preco = preco + valor;
		WHEN 'PORCENTAGEM' THEN
			SET novo_preco = preco + valor;
		ELSE 
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tipo não implementado.';
	END CASE;
	
	UPDATE livros SET livros.preco = novo_preco
	WHERE livros.editora_id = editora_id;
END

UPDATE livros SET livros.preco = 10 WHERE livros.editora_id = 3;
CALL acrecimo_livro(100, 3, 'VALOR');
SELECT * FROM livros WHERE livros.editora_id = 3;