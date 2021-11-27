### Gerador de sql

### Install
```bash
  npm instal
  npm gen
```

### Como usar
##### Para gerar os dados coloque um comentario "--eval()", o que estiver dentro dos parentes sera executado como javascript puro.

- **Utils**
  - $:
    - Funções customizadas
  - faker:
    - Gerar dados usando a lib fakerJs
  - dayjs:
    - Formatar datas/tempo

### Criar novas funções uteis
##### Va em src/functions.js e no objeto adicione a nova função retornando um valor

### Dicas
  - Para saber as opções do faker no arquivo index.ts no inicio use a função 'faker.' que ele ira te mostrar o intellisense
  - Sempre deixe o comentario na mesma linha do campo a ser gerado.

### Exemplos
```sql
create table notas_itens(
  id serial not null primary key,
  id_nota int not null, --eval($.foreignKey(1000))
  id_produto int not null, --eval($.foreignKey(1000))
  quantidade decimal(12, 2) default 0, --eval($.amount())
  valor_unit decimal(12, 2) default 0, --eval($.price())
  foreign key(id_nota) references notas(id) on delete cascade on update cascade,
  foreign key(id_produto) references produtos(id) on delete restrict on update cascade
);
```

### Functions
```js
  // CUSTOM
  $.product()
  $.lorem(20) // QUANTIDADE
  $.foreignKey(10000) // O RANGE DE 0 a 10000
  $.amount(0, 200) // MIN MAX
  $.price(10, 2000) // MIN MAX
  $.fullName()
  $.dateFormat('2021-03-12')
  $.date('2020-01-01', '2021-01-01')

  // FAKER
  faker.address.city()
  faker.animal.cat()
  faker.finance.amount(20, 40, 2)

  // DAYJS
  dayjs(new Date()).format('YYYY-MM')
  dayjs(new Date()).format('YYYY-MM-DD')
  dayjs(new Date()).format('YYYY-MM-DDTHH:mm:ss');
``` 