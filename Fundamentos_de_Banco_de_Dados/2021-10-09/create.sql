DROP TABLE IF EXISTS pedidos_produtos;
DROP TABLE IF EXISTS pedidos;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS fornecedores;
DROP TABLE IF EXISTS categorias;

CREATE TABLE IF NOT EXISTS categorias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(100) NOT NULL,
  data_cadastro DATE DEFAULT NOW(),
  valor_unitario FLOAT NOT NULL,
  categoria_id INT NOT NULL,
  CONSTRAINT produtos_categoria_foreign_key
       	FOREIGN KEY (categoria_id)
           	REFERENCES categorias(id)
              ON DELETE RESTRICT
              ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS fornecedores (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  data_ultima_compra DATE
);

CREATE TABLE IF NOT EXISTS pedidos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fornecedor_id INT NOT NULL,
  data_pedido DATE NOT NULL DEFAULT NOW(),
  numero_pedido VARCHAR(255) NOT NULL,
  CONSTRAINT pedidos_fornecedores_foreign_key
  	FOREIGN KEY (fornecedor_id)
  		REFERENCES fornecedores(id)
          ON DELETE RESTRICT
          ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS pedidos_produtos  (
  produto_id INT NOT NULL,
  pedido_id INT NOT NULL,
  quantidade FLOAT NOT NULL,
  CONSTRAINT pedidos_produtos_pedidos_foreign_key
  	FOREIGN KEY (pedido_id)
  		REFERENCES pedidos(id)
          ON DELETE RESTRICT
          ON UPDATE CASCADE,
  CONSTRAINT pedidos_produtos_produtos_foreign_key
  	FOREIGN KEY (produto_id)
  		REFERENCES produtos(id)
          ON DELETE RESTRICT
          ON UPDATE CASCADE
);