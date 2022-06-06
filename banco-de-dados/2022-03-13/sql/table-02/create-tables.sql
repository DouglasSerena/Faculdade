DROP TABLE IF EXISTS vendas;
DROP TABLE IF EXISTS livros;
DROP TABLE IF EXISTS autores;
DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS cidades;

CREATE TABLE IF NOT EXISTS `cidades` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  uf CHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS `categorias` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome TEXT NOT NULL,
  descricao TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS `clientes` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  cidade_id INT,
  CONSTRAINT clientes_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `autores` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  cidade_id INT NOT NULL,
  CONSTRAINT autores_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `livros` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(150) NOT NULL,
  numero_folhas INT NOT NULL,
  editora VARCHAR(150) NOT NULL,
  valor FLOAT NOT NULL,
  autor_id INT NOT NULL,
  categoria_id INT NOT NULL,
  CONSTRAINT livros_autores
    FOREIGN KEY (autor_id)
      REFERENCES autores(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT livros_categorias
    FOREIGN KEY (categoria_id)
      REFERENCES categorias(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `vendas` (
  livro_id INT NOT NULL,
  cliente_id INT NOT NULL,
  quantidade INT NOT NULL,
  data DATETIME DEFAULT NOW(),
  CONSTRAINT vendas_cliente
    FOREIGN KEY (cliente_id)
      REFERENCES clientes(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT vendas_livros
    FOREIGN KEY (livro_id)
      REFERENCES livros(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);