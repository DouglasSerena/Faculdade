CREATE TABLE cidades (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,  --eval(faker.address.cityName())
  uf CHAR(2) NOT NULL --eval(faker.address.stateAbbr())
);

CREATE TABLE categorias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome TEXT NOT NULL, --eval(faker.commerce.department())
  descricao TEXT NOT NULL --eval(faker.lorem.paragraph())
);


CREATE TABLE clientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL, --eval($.fullName())
  endereco VARCHAR(150) NOT NULL, --eval(faker.address.streetAddress())
  cidade_id INT, --eval($.foreignKey(1000))
  CONSTRAINT clientes_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE autores (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL, --eval($.fullName())
  cidade_id INT, --eval($.foreignKey(1000))
  CONSTRAINT clientes_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE livros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(150) NOT NULL, --eval($.fullName())
  numero_folhas INT NOT NULL, --eval($.amount(20, 2000))
  editora VARCHAR(150) NOT NULL, --eval($.fullName())
  valor FLOAT NOT NULL, --eval($.price())
  autor_id INT NOT NULL, --eval($.foreignKey(1000))
  categoria_id INT NOT NULL, --eval($.foreignKey(1000))
  CONSTRAINT livros_categorias
    FOREIGN KEY (categoria_id)
      REFERENCES categorias(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE vendas (
  livro_id INT NOT NULL, --eval($.foreignKey(1000))
  cliente_id INT NOT NULL, --eval($.foreignKey(1000))
  quantidade INT NOT NULL, --eval($.amount())
  data DATETIME DEFAULT NOW(),
  CONSTRAINT vendas_produtos
    FOREIGN KEY (cliente_id)
      REFERENCES clientes(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT vendas_filiais
    FOREIGN KEY (livro_id)
      REFERENCES livros(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);
