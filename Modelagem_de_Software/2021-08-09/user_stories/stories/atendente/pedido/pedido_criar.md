### Pedido criar

- **SENDO** Um atendente da pizzaria
- **POSSO** Criar um pedido
- **PARA QUE** Possa concluir o atendimento
- **RESTRIÇÕES** O cliente ja estar cadastro no sistema
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES** 
  - Tamanho pizza
  - Sabores
  - Bebidas *(OPCIONAL)*

###### *criar pedido*
  - **DADO QUE** hove uma solicitação de pedido
  - **QUANDO** for criar o pedido
  - **ENTÃO** devera começar a fazer o pedido

###### *criar pedido com informações invalidas*
  - **DADO QUE** hove uma solicitação de pedido
  - **QUANDO** for criar o pedido
    - **E** as informações do pedido for invalida
  - **ENTÃO** informar que as informações estão invalidas
