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

###### *finalizar pedido*
  - **DADO QUE** será finalizado o pedido
  - **QUANDO** for pegar o pedido
  - **ENTÃO** devera informar a forma de pagamento
    - **E** pegar o pedido

###### *finalizar pedido com forma de pagamento errada*
  - **DADO QUE** será finalizado o pedido
  - **QUANDO** for pegar o pedido
    - **E** informar a forma de pagamento errada
  - **ENTÃO** devera receber o alerta de que a forma de pagamento está incorreta.


