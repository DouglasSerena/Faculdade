---

# Atendente
### Atendimento

- **SENDO** Um atendente da pizzaria
- **POSSO** Atender o cliente
- **PARA QUE** Possa ajudar ele no seu pedido
- **RESTRIÇÕES** (VAZIO)
- **OBSERVAÇÕES** Primeiro contato do atendente com o cliente.
- **INFORMAÇÕES** (VAZIO)

###### _atender_

- **DADO QUE** houve um ligação
- **QUANDO** um cliente entrar em contato
- **ENTÃO** atender ele
  - **E** seguir o atendimento normal
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

###### _registrar cliente_

- **DADO QUE** houve um contato com um novo cliente
- **QUANDO** for registrar ele no sistema
- **ENTÃO** deve salvá-lo com sucesso.
  - **E** o cliente passa a ser um cliente do sistema

###### _registrar cliente sem endereço_

- **DADO QUE** houve um contato com um novo cliente
- **QUANDO** for registrar ele no sistema
  - **E** ele não passar o endereço
- **ENTÃO** não a como registrar ele no sistema

###### _registrar cliente com informações inválidas_

- **DADO QUE** houve um contato com um novo cliente
- **QUANDO** for registrar ele no sistema
  - **E** o cliente passar alguma informação errada
- **ENTÃO** devera informar que os dados estão errados.
### Pedido cancelar

- **SENDO** Um atendente da pizzaria
- **POSSO** Cancelar o pedido
- **PARA QUE** Não ocorra de cliente receber algo que não queira mais.
- **RESTRIÇÕES** Para fazer o cancelamento o pedido não pode ser saído da pizzaria e é obrigatório a passar pelo gerente
- **OBSERVAÇÕES** Este cancelamento tem que passar pelo gerente para ser feito com sucesso.
- **INFORMAÇÕES** (VAZIO)

###### _cancelar_

- **DADO QUE** houve uma solicitação de cancelamento
- **QUANDO** for cancelar o pedido
- **ENTÃO** deve passar para o gerente

###### _cancelar sem passar pelo gerente_

- **DADO QUE** houve uma solicitação de cancelamento
- **QUANDO** for cancelar o pedido
  - **E** não passar pelo gerente
- **ENTÃO** deve dar um erro informando que deve passar por ele
### Verificar se o cliente existe

- **SENDO** Um atendente da pizzaria
- **POSSO** Verificar no sistema se o cliente existe
- **PARA QUE** Ajudar o cliente a não ter que ficar passando suas informações várias vezes.
- **RESTRIÇÕES** (VAZIO)
- **OBSERVAÇÕES** Está etapa vem após o cliente fazer o pedido.
- **INFORMAÇÕES** (VAZIO)

###### _verificar um novo cliente_

- **DADO QUE** houve um contato com um novo cliente
- **QUANDO** for verificar ele no sistema
- **ENTÃO** devera informa que ele não existe no sistema

###### _verificar um cliente_

- **DADO QUE** houve um contato com um cliente
- **QUANDO** for verificar ele no sistema
- **ENTÃO** que ele existe no sistema

###### _verificar um cliente com informações inválidas_

- **DADO QUE** houve um contato com um cliente
- **QUANDO** for verificar ele no sistema
  - **E** as informações passadas pelo cliente estiverem erradas
- **ENTÃO** deve informar que as informações passadas estão erradas
### Pedido criar

- **SENDO** Um atendente da pizzaria
- **POSSO** Criar um pedido
- **PARA QUE** Possa concluir o atendimento
- **RESTRIÇÕES** O cliente já estar cadastro no sistema
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Tamanho pizza
  - Sabores
  - Bebidas _(OPCIONAL)_

###### _criar pedido_

- **DADO QUE** houve uma solicitação de pedido
- **QUANDO** for criar o pedido
- **ENTÃO** devera começar a fazer o pedido

###### _criar pedido com informações inválidas_

- **DADO QUE** houve uma solicitação de pedido
- **QUANDO** for criar o pedido
  - **E** as informações do pedido for inválida
- **ENTÃO** informar que as informações estão inválidas
### Pedido finalizar

- **SENDO** Um atendente da pizzaria
- **POSSO** Finalizar um pedido
- **PARA QUE** Possa concluir o pedido com sucesso
- **RESTRIÇÕES**
  - O pedido tem que ter sido entregue
  - O pedido deve ser pago
  - Deve pedir a forma de pagamento para o cliente
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Forma de pagamento

###### _finalizar pedido_

- **DADO QUE** houve a entrada do pedido
- **QUANDO** for finalizar o pedido
- **ENTÃO** devera pedir a forma de pagamento
  - **E** entregar o comprovante

###### _finalizar pedido com forma de pagamento errada_

- **DADO QUE** houve a entrada do pedido
- **QUANDO** for finalizar o pedido
  - **E** a forma de pagamento estiver errada
- **ENTÃO** deve informar para escolher outra forma de pagamento
### Pedido editar

- **SENDO** Um atendente da pizzaria
- **POSSO** Editar um pedido
- **PARA QUE** Possa atualizar suas informações sobre o pedido
- **RESTRIÇÕES**
  - O pedido não pode ter saído para entrega
  - O pedido já deve ter sido criado
  - O pedido não pode ter sido feito por exemplo a pizza já ter sido preparada e estar pronta
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Tamanho pizza
  - Sabores
  - Bebidas _(OPCIONAL)_

###### _editar pedido_

- **DADO QUE** houve uma solicitação de pedido edição
- **QUANDO** for editar o pedido
- **ENTÃO** o pedido será editado

###### _editar pedido com informações inválidas_

- **DADO QUE** houve uma solicitação de pedido edição
- **QUANDO** for editar o pedido
  - **E** as novas informações do pedido for inválida
- **ENTÃO** informar que as informações estão inválidas

###### _editar pedido já pronto_

- **DADO QUE** houve uma solicitação de pedido edição
- **QUANDO** for editar o pedido
  - **E** o pedido já estiver pronto
- **ENTÃO** devera informar que é impossível editar ele
### Pedido localização

- **SENDO** Um atendente da pizzaria
- **POSSO** Localizar um pedido específico
- **PARA QUE** O cliente possa saber onde está o seu pedido
- **RESTRIÇÕES** Informações sobre o pedido/cliente
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Sobre o cliente

###### _localizar pedido_

- **DADO QUE** houve uma solicitação de localização do pedido
- **QUANDO** for for localizar
- **ENTÃO** deve informar onde está o pedido
-

###### _localizar pedido que não saiu para entrega_

- **DADO QUE** houve uma solicitação de localização do pedido
- **QUANDO** for for localizar
  - **E** ele estiver na pizzaria ainda
- **ENTÃO** deve informar que o pedido ainda não saiu para entrega
