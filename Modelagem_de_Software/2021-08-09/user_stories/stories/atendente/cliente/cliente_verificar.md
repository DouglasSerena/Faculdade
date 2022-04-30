### Verificar se o cliente existe

- **SENDO** Um atendente da pizzaria
- **POSSO** Verificar no sistema se o cliente existe
- **PARA QUE** Ajudar o cliente a não ter que ficar passando suas informações várias vezes.
- **RESTRIÇÕES** (VAZIO)
- **OBSERVAÇÕES** Está etapa vem após o cliente fazer o pedido.
- **INFORMAÇÕES** (VAZIO)

###### *verificar um novo cliente*
  - **DADO QUE** houve um contato com um novo cliente
  - **QUANDO** for verificar ele no sistema
  - **ENTÃO** devera informa que ele não existe no sistema

###### *verificar um cliente*
  - **DADO QUE** houve um contato com um cliente
  - **QUANDO** for verificar ele no sistema
  - **ENTÃO** que ele existe no sistema

###### *verificar um cliente com informações inválidas*
  - **DADO QUE** houve um contato com um cliente
  - **QUANDO** for verificar ele no sistema
    - **E** as informações passadas pelo cliente estiverem erradas
  - **ENTÃO** deve informar que as informações passadas estão erradas