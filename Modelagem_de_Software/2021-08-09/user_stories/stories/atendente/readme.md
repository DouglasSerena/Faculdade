----

# Atendente

### Atendimento
- **SENDO:** Um atendente da pizzaria
- **POSSO:** Atender o cliente
- **PARA QUE:** Possa ajudar ele no seu pedido
- **RESTRIÇÕES:** (VAZIO)
- **OBSERVAÇÕES:** Primeiro contato do atendente com o cliente.
- **INFORMAÇÕES:** (VAZIO)

#### testes

- **titulo**
  - **DADO QUE:**
  - **QUANDO:**
  - **ENTÃO:**


### Registrar um cliente

- **SENDO:** Um atendente da pizzaria
- **POSSO:** Registrar um cliente
- **PARA QUE:** Possa ter as informações básicas para conseguir fazer um pedido
- **RESTRIÇÕES:** O cliente passar suas informações
- **OBSERVAÇÕES:** Esta etapa pode ser pulada se o usuário ja estiver cadastrado no sistema.
- **INFORMAÇÕES:**
  - Nome
  - Número de telefone
  - Endereço:
    - Rua
    - Número
    - Bairro


### Verificar se o cliente existe

- **SENDO:** Um atendente da pizzaria
- **POSSO:** Verificar no sistema se o cliente existe
- **PARA QUE:** Ajudar o cliente a não ter que ficar passando suas informações varias vezes.
- **RESTRIÇÕES:** (VAZIO)
- **OBSERVAÇÕES:** Esta etapa vem apos o cliente fazer o pedido.
- **INFORMAÇÕES:** (VAZIO)


### Pedido cancelar

- **SENDO:** Um atendente da pizzaria
- **POSSO:** Cancelar o pedido
- **PARA QUE:** Não ocorra de cliente receber algo que não queira mais.
- **RESTRIÇÕES:** Para fazer o cancelamento o pedido não pode ser saído da pizzaria e é obrigatório a passar pelo gerente
- **OBSERVAÇÕES:** Este cancelamento tem que passar pelo gerente para ser feito com sucesso.
- **INFORMAÇÕES:** (VAZIO)


### Pedido criar

- **SENDO:** Um atendente da pizzaria
- **POSSO:** Criar um pedido
- **PARA QUE:** Possa concluir o atendimento
- **RESTRIÇÕES:** O cliente ja estar cadastro no sistema
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Tamanho pizza
  - Sabores
  - Bebidas *(OPCIONAL)*


### Pedido editar

- **SENDO:** Um atendente da pizzaria
- **POSSO:** Editar um pedido
- **PARA QUE:** Possa atualizar suas informações sobre o pedido
- **RESTRIÇÕES:**
  - O pedido não pode ter saído para entrega
  - O pedido já deve ter sido criado
  - O pedido não pode ter sido feito por exemplo a pizza já ter sido preparada e estar pronta
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Tamanho pizza
  - Sabores
  - Bebidas *(OPCIONAL)*


### Pedido finalizar

- **SENDO:** Um atendente da pizzaria
- **POSSO:** Finalizar um pedido
- **PARA QUE:** Possa concluir o pedido com sucesso
- **RESTRIÇÕES:**
  - O pedido tem que ter sido entregue
  - O pedido deve ser pago
  - Deve pedir a forma de pagamento para o cliente
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Forma de pagamento


### Pedido localização

- **SENDO:** Um atendente da pizzaria
- **POSSO:** Localizar um pedido específico
- **PARA QUE:** O cliente possa saber aonde esta o seu pedido
- **RESTRIÇÕES:** Informações sobre o pedido/cliente
- **OBSERVAÇÕES:** (VAZIO)
- **INFORMAÇÕES:** 
  - Sobre o cliente


