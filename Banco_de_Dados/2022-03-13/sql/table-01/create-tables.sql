DROP TABLE IF EXISTS `vendas`;
DROP TABLE IF EXISTS `produtos`;
DROP TABLE IF EXISTS `categorias`;
DROP TABLE IF EXISTS `empregados`;
DROP TABLE IF EXISTS `filiais`;
DROP TABLE IF EXISTS `cidades`;

CREATE TABLE IF NOT EXISTS `cidades` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  uf CHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS `filiais` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  cidade_id INT NOT NULL,
  CONSTRAINT filiais_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `empregados` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  rg VARCHAR(14),
  cpf VARCHAR(14) NOT NULL,
  salario FLOAT NOT NULL,
  cidade_id INT,
  filial_id INT,
  CONSTRAINT empregados_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT empregados_filiais
    FOREIGN KEY (filial_id)
      REFERENCES filiais(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `categorias` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome TEXT NOT NULL,
  descricao TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS `produtos` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome TEXT NOT NULL,
  preco FLOAT NOT NULL,
  categoria_id INT NOT NULL,
  CONSTRAINT produtos_categorias
    FOREIGN KEY (categoria_id)
      REFERENCES categorias(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `vendas` (
  filial_id INT NOT NULL,
  produto_id INT NOT NULL,
  CONSTRAINT vendas_produtos
    FOREIGN KEY (produto_id)
      REFERENCES produtos(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT vendas_filiais
    FOREIGN KEY (filial_id)
      REFERENCES filiais(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);