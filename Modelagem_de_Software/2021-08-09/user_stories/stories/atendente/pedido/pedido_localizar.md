### Pedido localização

- **SENDO** Um atendente da pizzaria
- **POSSO** Localizar um pedido específico
- **PARA QUE** O cliente possa saber aonde esta o seu pedido
- **RESTRIÇÕES** Informações sobre o pedido/cliente
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES** 
  - Sobre o cliente

###### *localizar pedido*
  - **DADO QUE** hove uma solicitação de localização do pedido
  - **QUANDO** for for localizar
  - **ENTÃO** deve informara aonde esta o pedido
  - 
###### *localizar pedido que não sai para entrega*
  - **DADO QUE** hove uma solicitação de localização do pedido
  - **QUANDO** for for localizar
    - **E** ele estiver na pizzaria ainda
  - **ENTÃO** deve informar que o pedido ainda não saiu para entrega