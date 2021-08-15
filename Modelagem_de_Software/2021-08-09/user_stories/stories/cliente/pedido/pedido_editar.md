### Pedido editar

- **SENDO** Um cliente
- **POSSO** Editar um pedido já criado
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
    - **E** passar as novas preferências de pizza
  - **ENTÃO** devera receber a mensagem de que foi editado o pedido

###### *editar pedido com informações inválidas*
  - **DADO QUE** foi pedido para editar o pedido
  - **QUANDO** for editar o pedido
    - **E** as passar as novas preferências de pizza
    - **E** as novas informações for inválida
  - **ENTÃO** devera receber o alerta de que as informações estão erradas.

###### *editar pedido já pronto*
  - **DADO QUE** foi pedido para editar o pedido
  - **QUANDO** for editar o pedido
    - **E** o pedido já estiver pronto
  - **ENTÃO** devera receber o alerta de que não é mais possível alterar as informações.



