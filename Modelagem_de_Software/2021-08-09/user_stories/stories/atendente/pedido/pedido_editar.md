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
  - Bebidas *(OPCIONAL)*

###### *editar pedido*
  - **DADO QUE** houve uma solicitação de pedido edição
  - **QUANDO** for editar o pedido
  - **ENTÃO** o pedido será editado

###### *editar pedido com informações inválidas*
  - **DADO QUE** houve uma solicitação de pedido edição
  - **QUANDO** for editar o pedido
    - **E** as novas informações do pedido for inválida
  - **ENTÃO** informar que as informações estão inválidas

###### *editar pedido já pronto*
  - **DADO QUE** houve uma solicitação de pedido edição
  - **QUANDO** for editar o pedido
    - **E** o pedido já estiver pronto
  - **ENTÃO** devera informar que é impossível editar ele

