DROP TABLE IF EXISTS alocacoes;
DROP TABLE IF EXISTS carros;
DROP TABLE IF EXISTS clientes;

CREATE TABLE IF NOT EXISTS clientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  endereco VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS carros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  placa VARCHAR(8),
  modelo VARCHAR(20) NOT NULL,
  ano DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS alocacoes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cliente_id INT NOT NULL,
  carro_id INT NOT NULL,
  data_alocacao DATETIME NOT NULL,
  data_devolucao DATETIME NOT NULL,
  valor FLOAT NOT NULL,
  CONSTRAINT alocacoes_clientes
    FOREIGN KEY (cliente_id)
      REFERENCES clientes(id)
  		ON DELETE RESTRICT
  		ON UPDATE CASCADE,
  CONSTRAINT alocacoes_carros
    FOREIGN KEY (carro_id)
      REFERENCES alocacoes(id)
  		ON DELETE RESTRICT
  		ON UPDATE CASCADE
);