### Pedido localização

- **SENDO** Um cliente
- **POSSO** Localizar o meu pedido pedido
- **PARA QUE** Consiga acompanhar o pedido
- **RESTRIÇÕES** Informações sobre o pedido/cliente
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES** 
  - Sobre o pedido/cliente

###### *localizar pedido*
  - **DADO QUE** sera localizado o pedido
  - **QUANDO** for for localizar
  - **ENTÃO** devera receber as informações da localização
  - 
###### *localizar pedido que não sai para entrega*
  - **DADO QUE** sera localizado o pedido
  - **QUANDO** for for localizar
    - **E** o pedido ainda não estiver em rota de entrega
  - **ENTÃO** devera receber o alerta de que o pedido ainda não saiu para entrega