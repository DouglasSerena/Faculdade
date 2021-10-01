/*
    um produto percente a uma categoria e uma categoria tem muitos produtos
    um produto tem muitas fotos e uma foto pertence a mais de um produto

    quantas tabelas eu terei aqui?
      - possui tres tabelas

    comandos DDL?
*/

CREATE TABLE categorias (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
);

CREATE TABLE produtos (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  valor FLOAT NOT NULL,
  quantidade INT NOT NULL,
  id_categoria INT NOT NULL,
  CONSTRAINT produtos_categorias_foreign_key
    FOREIGN KEY (id_categoria)
      REFERENCES categorias(id)
);

CREATE TABLE fotos (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  url VARCHAR(255) NOT NULL
);

CREATE TABLE fotos_produto (
  id_foto INT NOT NULL,
  id_produto INT NOT NULL,
  CONSTRAINT fotos_produto_fotos_foreign_key
    FOREIGN KEY (id_foto)
      REFERENCES fotos(id),
  CONSTRAINT fotos_produto_produtos_foreign_key
    FOREIGN KEY (id_produto)
      REFERENCES produtos(id)
);