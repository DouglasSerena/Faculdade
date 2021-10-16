CREATE TABLE IF NOT EXISTS categorias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(100) NOT NULL,
  data_cadastro DATE DEFAULT NOW(),
  valor_unitario FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS fornecedores (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedidos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fornecedor_id INT NOT NULL,
  produto_id INT NOT NULL,
  quantidade FLOAT NOT NULL,
  valor_unitario FLOAT NOT NULL,
  `data` DATE,
  CONSTRAINT pedidos_fornecedores
  	FOREIGN KEY (fornecedor_id)
  		REFERENCES fornecedores(id),
  CONSTRAINT pedidos_produtos
  	FOREIGN KEY (produto_id)
  		REFERENCES produtos(id)
);

# Adicionar uma nova coluna
ALTER TABLE fornecedores
	ADD COLUMN data_ultima_compra DATE DEFAULT NOW();

# Alterar o nome do campo data
ALTER TABLE pedidos
	CHANGE `data` data_pedido DATE;

# Deletar a coluna data_cadastro
ALTER TABLE produtos
	DROP COLUMN data_cadastro;

# Adicionar o relacionamento entre produtos e categoria
ALTER TABLE produtos
	ADD COLUMN categoria_id INT NOT NULL;
ALTER TABLE produtos
  	ADD CONSTRAINT produtos_categoria_foreign_key
       	FOREIGN KEY (categoria_id)
           	REFERENCES categorias(id)
              ON DELETE RESTRICT
              ON UPDATE CASCADE;


# Alterar o nome do campo data
ALTER TABLE fornecedores
	MODIFY nome VARCHAR(200) NOT NULL;
    
# Deletar a tabela fornecedores
# Ira dar um erro devido a o fornecedor estar vinculado a pedidos
# DROP TABLE fornecedores;

# Adicionar numero do pedido
ALTER TABLE pedidos
	ADD COLUMN numero_pedido VARCHAR(255) NOT NULL;