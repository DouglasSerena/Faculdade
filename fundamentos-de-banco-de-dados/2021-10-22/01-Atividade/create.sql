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