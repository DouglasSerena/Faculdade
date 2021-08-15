---

# Cliente
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

###### _registrar cliente_

- **DADO QUE** houve um atendimento
- **QUANDO** for passar as informações
- **ENTÃO** devera receber o sucesso

###### _registrar cliente sem endereço_

- **DADO QUE** houve um atendimento
- **QUANDO** for passar as informações
  - **E** não foi passado o endereço
- **ENTÃO** devera passar o endereço

###### _registrar cliente com informações inválidas_

- **DADO QUE** houve um atendimento
- **QUANDO** for passar as informações
  - **E** passar alguma informação errada
- **ENTÃO** devera receber um alerta de informações erradas
### Atendimento

- **SENDO** Um cliente
- **POSSO** Entrar em contato com a pizzaria
- **PARA QUE** Possa fazer um pedido
- **RESTRIÇÕES** (VAZIO)
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES** (VAZIO)

###### _atender_

- **DADO QUE** foi ligado para pizzaria
- **QUANDO** entrar em contato
- **ENTÃO** seguirá o atendimento normal
### Pedido cancelar

- **SENDO** Um cliente
- **POSSO** Cancelar o pedido que está pendente
- **PARA QUE** Possa cancelar o pedido que não pretenda consumir
- **RESTRIÇÕES** Deve cancelar o pedido antes de sair da pizzaria
- **OBSERVAÇÕES** Deve ser passado informações sobre o pedido para saber qual pedido é para ser cancelado
- **INFORMAÇÕES** Sobre o pedido/cliente

###### _cancelar_

- **DADO QUE** foi pedido o cancelamento
- **QUANDO** for cancelar o pedido
- **ENTÃO** deve cancelar ele
### Pedido criar

- **SENDO** Um cliente
- **POSSO** Pode fazer um pedido de uma pizza
- **PARA QUE** Possa ser consumido pelo cliente
- **RESTRIÇÕES** É que o cliente deve está registrado no sistema
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Tamanho pizza
  - Sabores
  - Bebidas _(OPCIONAL)_

###### _criar pedido_

- **DADO QUE** foi pedido uma pizza
- **QUANDO** for criar o pedido
  - **E** passar as preferências de pizza
- **ENTÃO** devera receber a mensagem de que foi cadastrado o pedido

###### _criar pedido com informações inválidas_

- **DADO QUE** foi pedido uma pizza
- **QUANDO** for criar o pedido
  - **E** passar as preferências de pizza
  - **E** as informações do pedido for inválida
- **ENTÃO** devera receber o alerta de que as informações estão erradas.
### Pedido editar

- **SENDO** Um cliente
- **POSSO** Editar um pedido já criado
- **PARA QUE** Possa atualizar alguma informação do pedido
- **RESTRIÇÕES**
  - Deve ser passado as informações sobre o pedido/cliente
  - O pedido não pode ter saído para entrega
  - O pedido já deve ter sido criado
  - O pedido não pode ter sido feito por exemplo a pizza já ter sido preparada e estar pronta
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Tamanho pizza
  - Sabores
  - Bebidas _(OPCIONAL)_

###### _editar pedido_

- **DADO QUE** foi pedido para editar o pedido
- **QUANDO** for editar o pedido
  - **E** passar as novas preferências de pizza
- **ENTÃO** devera receber a mensagem de que foi editado o pedido

###### _editar pedido com informações inválidas_

- **DADO QUE** foi pedido para editar o pedido
- **QUANDO** for editar o pedido
  - **E** as passar as novas preferências de pizza
  - **E** as novas informações for inválida
- **ENTÃO** devera receber o alerta de que as informações estão erradas.

###### _editar pedido já pronto_

- **DADO QUE** foi pedido para editar o pedido
- **QUANDO** for editar o pedido
  - **E** o pedido já estiver pronto
- **ENTÃO** devera receber o alerta de que não é mais possível alterar as informações.
### Pedido finalizar

- **SENDO** Um cliente
- **POSSO** Finalizar um pedido
- **PARA QUE** Possa consumir e receber a pizza
- **RESTRIÇÕES**
  - Deve ser pago
  - Deve ser escolhido a forma de pagamento
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Forma de pagamento

###### _finalizar pedido_

- **DADO QUE** será finalizado o pedido
- **QUANDO** for pegar o pedido
- **ENTÃO** devera informar a forma de pagamento
  - **E** pegar o pedido

###### _finalizar pedido com forma de pagamento errada_

- **DADO QUE** será finalizado o pedido
- **QUANDO** for pegar o pedido
  - **E** informar a forma de pagamento errada
- **ENTÃO** devera receber o alerta de que a forma de pagamento está incorreta.
### Pedido localização

- **SENDO** Um cliente
- **POSSO** Localizar o meu pedido pedido
- **PARA QUE** Consiga acompanhar o pedido
- **RESTRIÇÕES** Informações sobre o pedido/cliente
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES**
  - Sobre o pedido/cliente

###### _localizar pedido_

- **DADO QUE** será localizado o pedido
- **QUANDO** for for localizar
- **ENTÃO** devera receber as informações da localização
-

###### _localizar pedido que não saiu para entrega_

- **DADO QUE** será localizado o pedido
- **QUANDO** for for localizar
  - **E** o pedido ainda não estiver em rota de entrega
- **ENTÃO** devera receber o alerta de que o pedido ainda não saiu para entrega
