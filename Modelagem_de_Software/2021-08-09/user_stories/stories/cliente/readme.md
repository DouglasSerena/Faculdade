## Cliente

#### Atendimento

- **SENDO:** Um cliente
- **POSSO:** Entrara em contato com a pizzaria
- **PARA QUE:** Possa fazer um pedido
- **RESTRIÇÕES:** (VAZIO)
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** (VAZIO)

#### Registrar um cliente

- **SENDO:** Um cliente
- **POSSO:** Me registrar no sistema da pizzaria
- **PARA QUE:** Conseguir fazer pedidos
- **RESTRIÇÕES:** (VAZIO)
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:**
  - Nome
  - Número de telefone
  - Endereço:
    - Rua
    - Número
    - Bairro

#### Pedido cancelar

- **SENDO:** Um cliente
- **POSSO:** Cancelar o pedido que esta pendente
- **PARA QUE:** Possa cancelar o pedido que não pretenda consumir
- **RESTRIÇÕES:** Deve cancelar o pedido antes de sair da pizzaria
- **OBSERVAÇÕES:** Deve ser passado informações sobre o pedido para saber qual pedido é para ser cancelado
- **INFORMAÇÕES:** Sobre o pedido/cliente

#### Pedido criar

- **SENDO:** Um cliente
- **POSSO:** Pode fazer um pedido de uma pizza
- **PARA QUE:** Possa ser consumido pelo cliente
- **RESTRIÇÕES:** É que o cliente deve esta registrado no sistema
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Tamanho pizza
  - Sabores
  - Bebidas *(OPCIONAL)*

#### Pedido editar

- **SENDO:** Um cliente
- **POSSO:** Editar um pedido ja criado
- **PARA QUE:** Possa atualizar alguma informação do pedido
- **RESTRIÇÕES:**
  - Deve ser passado as informações sobre o pedido/cliente
  - O pedido não pode ter saído para entrega
  - O pedido já deve ter sido criado
  - O pedido não pode ter sido feito por exemplo a pizza já ter sido preparada e estar pronta
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Tamanho pizza
  - Sabores
  - Bebidas *(OPCIONAL)*

#### Pedido finalizar

- **SENDO:** Um cliente
- **POSSO:** Finalizar um pedido
- **PARA QUE:** Possa consumir e receber a pizza 
- **RESTRIÇÕES:** 
  - Deve ser pago
  - Deve ser escolhido a forma de pagamento
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Forma de pagamento

#### Pedido localização

- **SENDO:** Um cliente
- **POSSO:** Localizar o meu pedido pedido
- **PARA QUE:** Consiga acompanhar o pedido
- **RESTRIÇÕES:** Informações sobre o pedido/cliente
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Sobre o pedido/cliente

