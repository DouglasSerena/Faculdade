/* ========================================================== */
INSERT INTO
	metros (quantidada_maxima_pessoa, nome)
VALUES
	(100, "Metro Torres"),
	(142, "Metro capão da canoa"),
	(231, "Porto alegre");

/* ========================================================== */
INSERT INTO
	passageiros (nome, cpf)
VALUES
	("Douglas", "000.000.000-00"),
	("Lucas", "000.000.000-00"),
	("João", "000.000.000-00");

/* ========================================================== */
INSERT INTO
	enderecos (rua, numero, bairro, cep)
VALUES
	("Rua carlos", "213a", "Bairo casa", "95555-000"),
	("Rua wójaw", "126", "Bairo mar", "95555-000"),
	("Rua barros", "2421", "Bairo rio", "95555-000");

/* ========================================================== */
INSERT INTO
	estacoes (nome, endereco_id)
VALUES
	("Estação rio branco", 1),
	("Estação carro", 2),
	("Estação bela vista", 3);

/* ========================================================== */
INSERT INTO
	viagens (status, data_inicio, metro_id, estacao_id)
VALUES
	("FINALIZADA", "2022-05-22 21:00:00", 1, 3),
	("AGUARDANDO", "2022-05-29 12:00:00", 2, 2),
	("FINALIZADA", "2022-05-22 22:00:00", 3, 1),
	("FINALIZADA", "2022-05-21 15:00:00", 3, 1),
	("INICIADA", "2022-05-22 18:00:00", 3, 1),
	("AGUARDANDO", "2022-06-01 22:00:00", 3, 1);

/* ========================================================== */
INSERT INTO
	tickets (valor, data_compra, passageiros_id, viagem_id)
VALUES
	(12, "2022-05-21 11:00:00", 1, 2),
	(50, "2022-05-22 10:00:00", 2, 1),
	(23.53, "2022-04-22 09:00:00", 3, 3);

/* ========================================================== */