create table if not clientes(
  id serial not null primary key,
  nome varchar(100) --eval($.fullName())
);

create table if not produtos(
  id serial not null primary key,
  descricao varchar(100), --eval($.product())
  valor_unit decimal(12, 2) default 0 --eval($.price())
);

create table if not notas(
  id serial not null primary key,
  data_emissao date, --eval($.date())
  id_cliente int not null, --eval($.foreignKey(1000))
  foreign key(id_cliente) references clientes(id) on delete restrict on update cascade
);

create table if not notas_itens(
  id serial not null primary key,
  id_nota int not null, --eval($.foreignKey(1000))
  id_produto int not null, --eval($.foreignKey(1000))
  quantidade decimal(12, 2) default 0, --eval($.amount())
  valor_unit decimal(12, 2) default 0, --eval($.price())
  foreign key(id_nota) references notas(id) on delete cascade on update cascade,
  foreign key(id_produto) references produtos(id) on delete restrict on update cascade
);