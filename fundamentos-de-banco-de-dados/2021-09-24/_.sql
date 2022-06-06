CREATE TABLE clientes (
  id INT NOT NULL,
  id2 INT NOT NULL,
  nome VARCHAR(150) NOT NULL,
  whats VARCHAR(15),
  PRIMARY KEY (id, id2) -- Chave primaria no final, podendo fazer multiplas chaves primaria
)

CREATE TABLE clientes (
  id INT NOT NULL PRIMARY KEY, -- Chave primaria em linha
  nome VARCHAR(150) NOT NULL,
  whats VARCHAR(15),
)

CREATE TABLE vendas (
  id INT NOT NULL PRIMARY KEY,
  data_emissao DATE NOT NULL,
  id_cliente INT NOT NULL,
  CONSTRAINT faz_venda
    FOREIGN KEY (id_cliente)
      REFERENCES clientes(id)
)