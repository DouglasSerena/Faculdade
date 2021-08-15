### Registrar um cliente

- **SENDO** Um cliente
- **POSSO** Me registrar no sistema da pizzaria
- **PARA QUE** Conseguir fazer pedidos
- **RESTRIÇÕES** (VAZIO)
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Nome
  - Número de telefone
  - Endereço:
    - Rua
    - Número
    - Bairro

###### *registrar cliente*
  - **DADO QUE** hove um atendimento
  - **QUANDO** for passar as informações
  - **ENTÃO** devera receber o sucesso

###### *registrar cliente sem endereço*
  - **DADO QUE** hove um atendimento
  - **QUANDO** for passar as informações
    - **E** não foi passado o endereço
  - **ENTÃO** devera passar o endereço

###### *registrar cliente com informações invalidas*
  - **DADO QUE** hove um atendimento
  - **QUANDO** for passar as informações
    - **E** passar alguma informação errada
  - **ENTÃO** devera receber um alerta de informações erradas