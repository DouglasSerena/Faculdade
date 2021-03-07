1. Através de uma pesquisa em livros traga no mínimo três definições sobre os conceitos de
Abstração, Encapsulamento, Herança, Classe, Método, Atributo.
Cara definição deve ter a referência de qual livro foi utilizado. Ao final coloque a definição com as suas palavras.

#### Abstração
  1. O princípio da abstração é a capacidade de abstrair a
    complexidade de um sistema e se concentrar em apenas
    partes desse sistema.
  2. A abstração de dados é utilizada para introduzir um novo tipo de  objeto, que é considerado útil no domínio do problema a ser resolvido.
  3. Quanto mais alta classe na hierarquia, mais ela tende a ser abstrata, ou menos definida, menos atributos e métodos.

##### Minha definição:
###### A Abstração é usada remover a complexidade do programa para focar mais na regra de negocio, um bom exemplo de abstração é as bibliotecas do java pro exemplo, o Math sele abstrai toda a complexidade dos cálculos matemáticos para arrendondar um numero com um simples Math.round();

#### Encapsulamento
  1. Encapsulamento se deriva de cápsula que nos lembra qualquer forma pequena que protege algo em seu interior, como um medicamento.
  2. O encapsulamento, ajuda a desenvolver programas com maior qualidade e flexibilidade para mudanças futuras.
  3. No fundo, o encapsulamento da classe acaba definindo um contrato que determina o que o mundo exterior pode fazer com objetos daquela classe

##### Minha definição:
###### O encapsulamento é usado para proteger as classe de edições ou remoções de métodos ou atributos que são propiá da classe ou de seu pai caso esteja sendo estendido.

#### Herança
  1. Herança é o mecanismo que permite a uma classe herdar todos os atributos e métodos de outra classe.
  2. Toda classe que herda de uma outra, acaba herdando também os seus atributos e métodos.
  3. O mecanismo de herança permite a reutilização das propriedades de uma classe na definição de outra. A classe mais generalizada é chamada superclasse e a  Introdução ao Paradigma de Orientação a Objetos mais especializada, subclasse.

##### Minha definição:
###### A herança é usada para escrever menos código podendo criar uma classe base que possua métodos e atributos genéricos que são usados em em todas as classes que estender ela.

#### Classe
  1. A modelagem e programação de um conjunto de objetos que possuem características (atributos) e comportamentos (métodos) comuns é feita na POO usando o conceito de Classe.
  2.  Cada classe funciona no fundo como um molde para a criação de um dado objeto.
      -  Os objetos são vistos como representações concretas (instâncias) das classes.
  3. Cada objeto criado a partir de uma classe é denominado de instância dessa classe. Uma classe provê toda a informação necessária para construir e  utilizar objetos de um tipo particular, ou seja, descreve a forma da memória privada e como  se realizam as operações das suas instâncias.

##### Minha definição:
###### Um classe seria um modelo que mostrar como dever ser construído um objeto e o que ele tem e pode fazer.

#### Método
  1. Objetos podem também ter comportamentos associados.
      - Um objeto do tipo Pessoa pode andar, correr ou dirigir carros.
      - Um objeto do tipo Carro pode ligar, desligar, acelerar, frear.
  2. Um método implementa algum aspecto do comportamento do objeto. 
  3. Um método é uma função ou procedimento que é definido na classe e tipicamente pode acessar o estado interno de um objeto da classe para  realizar alguma operação.

##### Minha definição:
###### Método é uma ação que o objeto pode fazer como por exemplo um objeto carro pode acelerar e freia, o freia e acelerar são métodos/ações que ele pode fazer.

#### Atributo
  1. Características são tipicamente chamadas de atributos
      - O objeto Pessoa possui RG, nome, data de nascimento, etc.
      - O objeto Carro possui tipo, cor, quantidade de portas.
  2. Cada atributo é de um tipo de dado específico. As especificidades das  implementações dos tipos de dados diversificam, em geral, conforme a linguagem de programação  e/ou plataforma operacional em uso.

##### Minha definição:
###### Atributos são informações sobre o objeto como um nome de um cliente, a cor de um carro, todas as informações sobre o objeto.

#### Referencias

- [Livro: Programação Orientada a Objetos "JAVA - NETBEANS"]('https://intranet.ifs.ifsuldeminas.edu.br/michelle.nery/Linguagem%20de%20Programa%C3%A7%C3%A3o%20Java%20-%20Integrado/Aula%2019%20-%20POO/Aula%2016%20-%20POO.pdf')
- [Livro: Introdução ao Paradigma de Orientação a Objeto - "Carlos Alberto Kamienski"]('https://www.cin.ufpe.br/~rcmg/cefet-al/proo/apostila-poo.pdf')
- [Livro: Conceitos de Orientação a Objetos - "Denis Clayton Alves Ramos"]('http://ftp.unicamp.br/pub/apoio/treinamentos/linguagens/POO.pdf')

---

2. Quais os benefícios da programação Orientada a objetos?;

###### A abstração de complexidade e reutilização de código

---

3. Qual a diferença entre uma classe e um objeto?

###### Uma classe é o modelo/forma, ja o objeto seria a instancia de uma classe sendo assim ele herdar todos os atributos e métodos da classe, uma analogia seria uma receita de bolo e o bolo, a receita de bolo é a classe e o bolo em si é o objeto

---

4. Observe o trecho de código abaixo, escrito na linguagem de programação.Qual o resultado será apresentado:

```java
class Main {
  /** @return 4.0 */
  public static void main(String[] args) {
    double pi = 3.14;
    System.out.println(Math.max(Math.ceil(pi), Math.floor(pi)));
  }
}
```

---

5. Observe o trecho de código abaixo, escrito na linguagem de programação Java. qual será o valor que será apresentado.

```java
class Main {
  /** @return "Lummertz" */
  public static void main(String[] args) {
    String name = "Ramin Lumertz";
    name = name.substring(6);
    name = name.replace("m", "mm");
    System.out.println(name);
  }
}
```

---

6. Através da abstração, conseguimos “transportar“ objetos dos mundo real para o mundo computacional. Pratique esse conceito classificando os atributos e ações dos seguintes objetos.
    - Um cliente;
    - Um venda;
    - Uma cadeira;
    - Um produto;
    - Um cartão de crédito;
    - Um automóvel;

```typescript
class Cliente {
  private _id: number;
  private _nome: string;
  private _dataNascimento: Date;
  private _cpf?: string;

  get name() { return this._nome; };
  get cpf() { return this._cpf; };
  get idade() { return this._dataNascimento; };

  public atualizar(id: number, nome: string) { }
  public remover(id: number) { }
}
```
---
```typescript
class Produto extends Objeto {
  private _preço: number;
  private _validade: Date;
  
  public nome: string;

  get validade() { return this._validade; };
  get preço() {return this._preço; }
  set preço(value: number) { this._preço = value; }

  comprar() {}
}
```
---
```typescript
class Cadeira extends Objeto {
  private _altura: number;

  sentar() {}
  levantar() {}
}
```
---
```typescript
class Automóvel extends Objeto {
  private _peso: number; 
  private _placa: string;
  private _portas: number;

  ligar() {}
  desligar() {}
  virar(para: 'DIREITA' | 'ESQUERDA') {}
  acelerar() {}
  feia() {}
}
```
---
```typescript
abstract class Objeto {
  private _id: number;
  private _modelo: string;
  private _marca: string;
  
  public cor: string;

  get modelo() { return this._modelo; }
  get marca() { return this._marca; }
}
```
---
```typescript
class Venda {
  private _rua: string;
  private _numero: string;
  private _bairro: string;
  private _cidade: string;
  private _estado: string; 

  public horário: Date;
  public produtos: Produto[];

  get endereço() { return "" }

  comprar(produto: string) {}
  abrir() {}
  fechar() {}
}
```
---
```typescript
class CartãoDeCredito {
  private _numero: number;
  private _agencia: number;
  private _senha: number;
  private _saldo: number;
  private _validade: number;

  get saldo() { return this._saldo; }
  
  sacar() {}
  depositar() {}
  transição(conta) {}
}
```