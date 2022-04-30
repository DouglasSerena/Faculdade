CREATE TABLE cidades (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,  --eval(faker.address.cityName())
  uf CHAR(2) NOT NULL --eval(faker.address.stateAbbr())
);

CREATE TABLE filiais (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,  --eval(faker.address.cityName())
  endereco VARCHAR(150) NOT NULL, --eval(faker.address.streetAddress())
  cidade_id INT NOT NULL, --eval($.foreignKey(1000))
  CONSTRAINT filiais_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE empregados (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL, --eval($.fullName())
  endereco VARCHAR(150) NOT NULL, --eval(faker.address.streetAddress())
  rg VARCHAR(14), --eval(faker.random.alphaNumeric(11))
  cpf VARCHAR(14) NOT NULL, --eval(faker.random.alphaNumeric(11))
  salario FLOAT NOT NULL, --eval($.price())
  cidade_id INT, --eval($.foreignKey(1000))
  filial_id INT, --eval($.foreignKey(1000))
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

CREATE TABLE categorias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome TEXT NOT NULL, --eval(faker.commerce.department())
  descricao TEXT NOT NULL --eval(faker.lorem.paragraph())
);

CREATE TABLE produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome TEXT NOT NULL, --eval(faker.commerce.product())
  preco FLOAT NOT NULL, --eval($.price())
  categoria_id INT NOT NULL, --eval($.foreignKey(1000))
  CONSTRAINT produtos_categorias
    FOREIGN KEY (categoria_id)
      REFERENCES categorias(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE vendas (
  filial_id INT NOT NULL, --eval($.foreignKey(1000))
  produto_id INT NOT NULL, --eval($.foreignKey(1000))
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