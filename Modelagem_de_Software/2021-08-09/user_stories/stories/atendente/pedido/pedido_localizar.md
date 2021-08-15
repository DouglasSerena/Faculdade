### Pedido localização

- **SENDO** Um atendente da pizzaria
- **POSSO** Localizar um pedido específico
- **PARA QUE** O cliente possa saber aonde está o seu pedido
- **RESTRIÇÕES** Informações sobre o pedido/cliente
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES** 
  - Sobre o cliente

###### *localizar pedido*
  - **DADO QUE** houve uma solicitação de localização do pedido
  - **QUANDO** for for localizar
  - **ENTÃO** deve informara aonde está o pedido
  - 
###### *localizar pedido que não saiu para entrega*
  - **DADO QUE** houve uma solicitação de localização do pedido
  - **QUANDO** for for localizar
    - **E** ele estiver na pizzaria ainda
  - **ENTÃO** deve informar que o pedido ainda não saiu para entrega