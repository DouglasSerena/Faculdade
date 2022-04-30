create table usuarios (
  id serial not null primary key,
  nome VARCHAR(100) NOT NULL, --eval($.fullName())
  create_at TIMESTAMP DEFAULT NOW(), --eval($.date('2018-01-01', '2020-01-01'))
  update_at TIMESTAMP --eval($.date('2020-01-01', '2022-12-31'))
);

create table servicos (
  id serial not null primary key,
  descricao VARCHAR(100) NOT NULL, --eval($.fullName())
  valor FLOAT NOT NULL, --eval($.price(0.1, 5000))
  id_user int NOT NULL, --eval($.foreignKey(1000000))
  foreign key(id_user) references usuarios(id) on delete restrict on update cascade
);

create table notas (
  id serial not null primary key,
  data_emissao date --eval($.date('2018-01-01', '2022-12-31'))
);

create table notas_servicos (
  id serial not null primary key,
  valor FLOAT NOT NULL, --eval($.price(0.1, 5000))
  id_nota int NOT NULL, --eval($.foreignKey(1000000))
  id_servico int NOT NULL, --eval($.foreignKey(1000000))
  foreign key(id_nota) references notas(id) on delete restrict on update cascade,
  foreign key(id_servico) references servicos(id) on delete restrict on update cascade
);
