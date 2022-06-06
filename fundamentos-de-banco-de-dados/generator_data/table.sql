create table clientes(
  id serial not null primary key,
  nome varchar(100)
);

create table produtos(
  id serial not null primary key,
  descricao varchar(100),
  valor_unit decimal(12, 2) default 0
);

create table notas(
  id serial not null primary key,
  data_emissao date,
  id_cliente int not null,
  foreign key(id_cliente) references clientes(id) on delete restrict on update cascade
);

create table notas_itens(
  id serial not null primary key,
  id_nota int not null,
  id_produto int not null,
  quantidade decimal(12, 2) default 0,
  valor_unit decimal(12, 2) default 0,
  foreign key(id_nota) references notas(id) on delete cascade on update cascade,
  foreign key(id_produto) references produtos(id) on delete restrict on update cascade
);