/* ========================================================== */
DROP TRIGGER trigger_update_before_viagem_finalizar_viagem;
CREATE TRIGGER trigger_update_before_viagem_finalizar_viagem BEFORE UPDATE ON viagens
	FOR EACH ROW
BEGIN
    IF (NEW.data_fim IS NOT NULL) THEN
        SET NEW.status = "FINALIZADA";
    END IF;
END;

UPDATE viagens
SET data_fim = NOW()
WHERE id = 5;

/* ========================================================== */

-- DROP TRIGGER trigger_delete_viagem;
-- CREATE TRIGGER trigger_delete_viagem BEFORE DELETE ON viagens
-- 	FOR EACH ROW
-- BEGIN
--     DELETE FROM tickets WHERE viagem_id = OLD.id;
-- END;

-- DELETE FROM viagens WHERE id = 1;

/* ========================================================== */
DROP TRIGGER trigger_update_after_viagem_utilizar_ticket;
CREATE TRIGGER trigger_update_after_viagem_utilizar_ticket AFTER UPDATE ON viagens
	FOR EACH ROW
BEGIN
    IF (NEW.status = "FINALIZADA") THEN 
        UPDATE tickets
        SET utilizado=1
        WHERE viagem_id = NEW.id;
    END IF;
END;

UPDATE viagens
SET data_fim = NOW()
WHERE id = 3;

/* ========================================================== */
DROP TRIGGER trigger_insert_before_ticket_validar_se_o_trem_esta_ceio;
CREATE TRIGGER trigger_insert_before_ticket_validar_se_o_trem_esta_ceio BEFORE INSERT ON tickets
	FOR EACH ROW
BEGIN
    DECLARE maximo_de_tickets_da_viagem INT;
    DECLARE total_tickets_viagem INT;

    SET maximo_de_tickets_da_viagem = (
        SELECT metros.quantidada_maxima_pessoa FROM viagens 
            JOIN metros
                ON metros.id = viagens.metro_id
        WHERE viagens.id = NEW.viagem_id);
    SET total_tickets_viagem = (SELECT COUNT(*) FROM tickets WHERE viagem_id = NEW.viagem_id);

    IF (total_tickets_viagem + 1 = maximo_de_tickets_da_viagem) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'O metro esta lotado.';
    END IF;
END;

INSERT INTO tickets (valor, data_compra, passageiros_id, viagem_id) 
	VALUES
		(12,"2022-05-21 11:00:00", 1, 1);

/* ========================================================== */