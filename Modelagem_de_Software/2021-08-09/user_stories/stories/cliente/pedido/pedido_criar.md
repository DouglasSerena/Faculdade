### Pedido criar

- **SENDO** Um cliente
- **POSSO** Pode fazer um pedido de uma pizza
- **PARA QUE** Possa ser consumido pelo cliente
- **RESTRIÇÕES** É que o cliente deve está registrado no sistema
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES** 
  - Tamanho pizza
  - Sabores
  - Bebidas *(OPCIONAL)*

###### *criar pedido*
  - **DADO QUE** foi pedido uma pizza
  - **QUANDO** for criar o pedido
    - **E** passar as preferências de pizza
  - **ENTÃO** devera receber a mensagem de que foi cadastrado o pedido

###### *criar pedido com informações inválidas*
  - **DADO QUE** foi pedido uma pizza
  - **QUANDO** for criar o pedido
    - **E** passar as preferências de pizza
    - **E** as informações do pedido for inválida
  - **ENTÃO** devera receber o alerta de que as informações estão erradas.

