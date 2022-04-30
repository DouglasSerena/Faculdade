![modelo](./02-atividade.png)

departamento (**sigla**, nome);
  - **sigla** CHAVE PRIMARIA;

funcionario (**matricula**, departamento_id, nome);
  - **matricula** CHAVE PRIMARIA;
  - **departamento_id** REFERENCIA departamento(**sigla**);