### Pedido editar

- **SENDO** Um cliente
- **POSSO** Editar um pedido ja criado
- **PARA QUE** Possa atualizar alguma informação do pedido
- **RESTRIÇÕES**
  - Deve ser passado as informações sobre o pedido/cliente
  - O pedido não pode ter saído para entrega
  - O pedido já deve ter sido criado
  - O pedido não pode ter sido feito por exemplo a pizza já ter sido preparada e estar pronta
- **OBSERVAÇÕES** (VAZIO)
- **INFORMAÇÕES** 
  - Tamanho pizza
  - Sabores
  - Bebidas *(OPCIONAL)*

###### *editar pedido*
  - **DADO QUE** foi pedido para editar o pedido
  - **QUANDO** for editar o pedido
    - **E** passar as novas preferencias de pizza
  - **ENTÃO** devera receber a mensagem de que foi editado o pedido

###### *editar pedido com informações invalidas*
  - **DADO QUE** foi pedido para editar o pedido
  - **QUANDO** for editar o pedido
    - **E** as passar as novas preferencias de pizza
    - **E** as novas informações for invalida
  - **ENTÃO** devera receber o alerta de que as informações estão erradas.

###### *editar pedido ja pronto*
  - **DADO QUE** foi pedido para editar o pedido
  - **QUANDO** for editar o pedido
    - **E** o pedido ja estiver pronto
  - **ENTÃO** devera receber o alerta de que não é mais possível altera as informações.



