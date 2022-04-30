DROP TABLE tabuada;
CREATE TABLE tabuada(valor INT, multiplicador INT, resultado INT);

DROP PROCEDURE tabuada;

CREATE PROCEDURE tabuada (valor INT)
BEGIN
	DECLARE indice INT DEFAULT 1;
	DECLARE resultado INT DEFAULT 0;
		
	IF (NOT EXISTS (SELECT * FROM tabuada WHERE tabuada.valor = valor)) THEN 
		WHILE indice <= 10 DO
			SET resultado = indice * valor;
			
			INSERT INTO tabuada (valor, multiplicador, resultado) values (valor, indice, resultado);
			
			SET indice = indice + 1;
		END WHILE;
	END IF;
	
	SELECT * FROM tabuada WHERE tabuada.valor = valor;
END


CALL tabuada(7);

SELECT * FROM tabuada WHERE multiplicador = 7;