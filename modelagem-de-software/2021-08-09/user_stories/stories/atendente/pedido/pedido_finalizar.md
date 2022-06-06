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

###### *finalizar pedido*
  - **DADO QUE** houve a entrada do pedido
  - **QUANDO** for finalizar o pedido
  - **ENTÃO** devera pedir a forma de pagamento
    - **E** entregar o comprovante

###### *finalizar pedido com forma de pagamento errada*
  - **DADO QUE** houve a entrada do pedido
  - **QUANDO** for finalizar o pedido
    - **E** a forma de pagamento estiver errada
  - **ENTÃO** deve informar para escolher outra forma de pagamento

