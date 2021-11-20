DROP TABLE IF EXISTS alocacoes;
DROP TABLE IF EXISTS carros;
DROP TABLE IF EXISTS marcas;
DROP TABLE IF EXISTS clientes;

CREATE TABLE IF NOT EXISTS clientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  endereco VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS marcas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS carros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  marca_id INT NOT NULL,
  placa VARCHAR(8),
  modelo VARCHAR(50) NOT NULL,
  ano INT NOT NULL,
  CONSTRAINT carros_marcas
    FOREIGN KEY (marca_id)
      REFERENCES marcas(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS alocacoes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cliente_id INT NOT NULL,
  carro_id INT NOT NULL,
  data_alocacao DATE DEFAULT NOW(),
  data_devolucao DATE,
  valor FLOAT NOT NULL,
  CONSTRAINT alocacoes_clientes
    FOREIGN KEY (cliente_id)
      REFERENCES clientes(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT alocacoes_carros
    FOREIGN KEY (carro_id)
      REFERENCES carros(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

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
        
UPDATE carros SET ano=2000 WHERE id=3;
UPDATE clientes SET nome="Douglas serena" WHERE id=1;
UPDATE alocacoes SET valor=250 WHERE id=1;
UPDATE alocacoes SET valor=valor*1.20;

SELECT * FROM alocacoes WHERE data_alocacao >= '2021-09-01' AND data_alocacao <= '2021-09-30';
SELECT * FROM clientes WHERE nome LIKE "%silva%";

SELECT * FROM marcas;
SELECT * FROM carros;
SELECT * FROM alocacoes;
SELECT * FROM carros
	INNER JOIN marcas
    	ON marcas.id = carros.id;