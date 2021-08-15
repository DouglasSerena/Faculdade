### Pedido cancelar

- **SENDO** Um atendente da pizzaria
- **POSSO** Cancelar o pedido
- **PARA QUE** Não ocorra de cliente receber algo que não queira mais.
- **RESTRIÇÕES** Para fazer o cancelamento o pedido não pode ser saído da pizzaria e é obrigatório a passar pelo gerente
- **OBSERVAÇÕES** Este cancelamento tem que passar pelo gerente para ser feito com sucesso.
- **INFORMAÇÕES** (VAZIO)

###### *cancelar*
  - **DADO QUE** houve uma solicitação de cancelamento
  - **QUANDO** for cancelar o pedido
  - **ENTÃO** deve passar para o gerente

###### *cancelar sem passar pelo gerente*
  - **DADO QUE** houve uma solicitação de cancelamento
  - **QUANDO** for cancelar o pedido
    - **E** não passar pelo gerente
  - **ENTÃO** deve dar um erro informando que deve passar por ele