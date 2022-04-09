CREATE TABLE IF NOT EXISTS `cidades` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,  --eval(faker.address.cityName())
  uf CHAR(2) NOT NULL --eval(faker.address.cityName())
);

CREATE TABLE IF NOT EXISTS `filiais` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,  --eval(faker.address.cityName())
  endereco VARCHAR(150) NOT NULL,
  cidade_id INT NOT NULL, --eval($.foreignKey(1000))
  CONSTRAINT filiais_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `empregados` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL, --eval($.fullName())
  endereco VARCHAR(150) NOT NULL,
  rg VARCHAR(14), --eval(faker.random.alphaNumeric(11))
  cpf VARCHAR(14) NOT NULL, --eval(faker.random.alphaNumeric(11))
  salario FLOAT NOT NULL,
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

CREATE TABLE IF NOT EXISTS `categorias` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome TEXT NOT NULL,
  descricao TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS `produtos` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao TEXT NOT NULL,
  preco FLOAT NOT NULL, --eval($.price())
  categoria_id INT NOT NULL, --eval($.foreignKey(1000))
  CONSTRAINT produtos_categorias
    FOREIGN KEY (categoria_id)
      REFERENCES categorias(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `vendas` (
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

CREATE TABLE cidades (
  id serial primary key,
  nome varchar(255), --eval(faker.address.cityName())
  uf varchar(255) --eval(faker.address.cityName())
);

CREATE TABLE alunos (
  id serial primary key,
  nome varchar(255), --eval($.fullName())
  endereco varchar(100), --eval(`${faker.address.streetName()}`)
  telefone varchar(100), --eval(faker.phone.phoneNumber())
  cidade_id int NOT NULL, --eval($.foreignKey(1000))
  foreign key(cidade_id) references cidades(id)
);

CREATE TABLE professores (
  id serial primary key,
  nome varchar(255), --eval($.fullName())
  email varchar(255), --eval(faker.internet.email())
  endereco varchar(100), --eval(`${faker.address.streetName()}`)
  cpf varchar(100), --eval(faker.random.alphaNumeric(11))
  cidade_id int NOT NULL, --eval($.foreignKey(1000))
  foreign key(cidade_id) references cidades(id)
);

CREATE TABLE disciplinas (
  id serial primary key,
  nome varchar(255) --eval($.fullName())
);

CREATE TABLE cursos (
  id serial primary key,
  nome varchar(255), --eval($.fullName())
  valor float --eval($.price())
);

CREATE TABLE turmas (
  id serial primary key,
  sala varchar(255), --eval(faker.datatype.number(200))
  capacidade int, --eval(faker.datatype.number(30))
  curso_id int NOT NULL, --eval($.foreignKey(1000))
  professor_id int NOT NULL, --eval($.foreignKey(1000))
  foreign key(curso_id) references cursos(id),
  foreign key(professor_id) references professores(id)
);

CREATE TABLE matriculas (
  data DATE, --eval($.date('2018-01-01', '2022-01-01'))
  aluno_id int NOT NULL, --eval($.foreignKey(1000))
  turma_id int NOT NULL, --eval($.foreignKey(1000))
  foreign key(aluno_id) references alunos(id),
  foreign key(turma_id) references turmas(id)
);

CREATE TABLE turmas_disciplinas (
  turma_id int NOT NULL, --eval($.foreignKey(1000))
  disciplina_id int NOT NULL, --eval($.foreignKey(1000))
  foreign key(turma_id) references turmas(id),
  foreign key(disciplina_id) references disciplinas(id)
);