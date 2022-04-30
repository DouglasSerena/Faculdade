### Registrar um cliente

- **SENDO** Um atendente da pizzaria
- **POSSO** Registrar um cliente
- **PARA QUE** Possa ter as informações básicas para conseguir fazer um pedido
- **RESTRIÇÕES** O cliente passar suas informações
- **OBSERVAÇÕES** Esta etapa pode ser pulada se o usuário já estiver cadastrado no sistema.
- **INFORMAÇÕES**
  - Nome
  - Número de telefone
  - Endereço:
    - Rua
    - Número
    - Bairro

###### *registrar cliente*
  - **DADO QUE** houve um contato com um novo cliente
  - **QUANDO** for registrar ele no sistema
  - **ENTÃO** deve salvá-lo com sucesso.
    - **E** o cliente passa a ser um cliente do sistema

###### *registrar cliente sem endereço*
  - **DADO QUE** houve um contato com um novo cliente
  - **QUANDO** for registrar ele no sistema
    - **E** ele não passar o endereço
  - **ENTÃO** não a como registrar ele no sistema

###### *registrar cliente com informações inválidas*
  - **DADO QUE** houve um contato com um novo cliente
  - **QUANDO** for registrar ele no sistema
    - **E** o cliente passar alguma informação errada
  - **ENTÃO** devera informar que os dados estão errados.