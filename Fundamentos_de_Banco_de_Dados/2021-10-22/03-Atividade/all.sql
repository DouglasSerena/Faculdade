DROP TABLE IF EXISTS tipos_socios;
DROP TABLE IF EXISTS socios;
DROP TABLE IF EXISTS pedidos_servicos;
DROP TABLE IF EXISTS servicos;

CREATE TABLE IF NOT EXISTS tipos_socios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS socios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tipo_socio_id INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  endereco VARCHAR(200) NOT NULL,
  CONSTRAINT socios_tipos_socios
    FOREIGN KEY (tipo_socio_id)
      REFERENCES tipos_socios(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS servicos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(200) NOT NULL,
  valor FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS pedidos_servicos (
  socio_id INT NOT NULL,
  servico_id INT NOT NULL,
  data_referencia DATE NOT NULL,
  CONSTRAINT pedidos_servicos_socios
    FOREIGN KEY (socio_id)
      REFERENCES socios(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT pedidos_servicos_servicos
    FOREIGN KEY (servico_id)
      REFERENCES servicos(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

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

UPDATE socios SET telefone="11111111111" WHERE id=2;
UPDATE servicos SET valor=1000 WHERE id=2;

SELECT * FROM servicos WHERE valor > 500;
SELECT * FROM pedidos_servicos WHERE data_referencia >= '2021-01-01' AND data_referencia <= '2021-01-31';
SELECT * FROM socios WHERE endereco LIKE '%Barão do Rio Branco%';
