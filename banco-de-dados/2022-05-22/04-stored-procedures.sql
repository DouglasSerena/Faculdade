/* ========================================================== */
DROP PROCEDURE quantidade_tickets_procedure;
CREATE PROCEDURE quantidade_tickets_procedure (param_viagem_id INT)
BEGIN
	DECLARE quantidade INT;
    
    SET quantidade = (SELECT COUNT(*) FROM tickets WHERE viagem_id = 1);
    
    SELECT CONCAT("Quantidade: ", quantidade);
END

CALL quantidade_tickets_procedure(3);

/* ========================================================== */

DROP PROCEDURE insert_ticket_para_proxima_viagem_procedure;
CREATE PROCEDURE insert_ticket_para_proxima_viagem_procedure (	param_valor FLOAT,
                                                                param_data_compra DATETIME,
                                                                param_passageiro_id INT)
BEGIN
	DECLARE viagem_id INT;
    
    SET viagem_id = (SELECT id FROM viagens WHERE data_inicio >= NOW() ORDER BY data_inicio LIMIT 1);
	
    INSERT INTO tickets (valor, data_compra, passageiros_id, viagem_id)
        VALUES (param_valor, param_data_compra, param_passageiro_id, viagem_id);
END

CALL insert_ticket_para_proxima_viagem_procedure(999999999, NOW(), 2);

/* ========================================================== */

DROP PROCEDURE valor_total_do_dia_procedure;
CREATE PROCEDURE valor_total_do_dia_procedure (param_data DATE)
BEGIN
	DECLARE total FLOAT;
    
    SET total = (SELECT SUM(valor) FROM tickets WHERE DATE(data_compra) = param_data);
    
    SELECT CONCAT("Total: R$ ", total);
END

CALL valor_total_do_dia_procedure("2022-05-22");

/* ========================================================== */

DROP PROCEDURE quantidade_de_passageiros_procedure;
CREATE PROCEDURE quantidade_de_passageiros_procedure (param_viagem_id INT)
BEGIN
	DECLARE quantidade INT;
    
    SET quantidade = (SELECT COUNT(*) FROM tickets WHERE viagem_id = param_viagem_id);
    
    SELECT CONCAT("Quantidade: ", quantidade);
END

CALL quantidade_de_passageiros_procedure(2)

/* ========================================================== */