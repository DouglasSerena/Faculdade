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