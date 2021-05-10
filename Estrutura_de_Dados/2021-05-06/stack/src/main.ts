import readline from 'readline';
import Caixa from './caixa';

class Pilha {
  caixas: Caixa[] = [];

  top: number = 0;

  get vazia() {
    return this.caixas.length === 0;
  }
  get maximo() {
    return this.caixas.length === 10;
  }

  empilhar(caixa: Caixa) {
    if (caixa instanceof Caixa) {
      if (this.vazia) {
        this.caixas[this.top] = caixa;
        this.top++;
      } else {
        if (this.maximo) {
          return console.log('\nA pilha esta no máximo');
        }
        if (caixa.peso >= this.caixas[this.top - 1].peso) {
          return console.log('\nO peso deve ser menor que o anterior');
        }
        this.caixas[this.top] = caixa;

        this.top++;
      }
      return false;
    }
    return console.log(`\nDeve ser passado um Caixa não um(a) ${typeof caixa}`);
  }

  pop() {
    if (this.vazia) {
      return console.log('\nA Pilha de caixa esta vazia.');
    }
    const array = [];

    for (let index = 0; index < this.caixas.length - 1; index++) {
      array[index] = this.caixas[index];
    }

    this.caixas = array;
    this.top--;
  }
}

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const pilha = new Pilha();

(function readLine() {
  console.log(
    '\nOptions:\n' +
      '1 - Adicionar a pilha\n' +
      '2 - Remover do top\n' +
      '3 - Ver pilha de caixa\n' +
      '0 - Fechar'
  );
  rl.question('Qual opção:', async (answer) => {
    const option = Number.parseInt(answer);

    try {
      switch (option) {
        case 1:
          rl.question('\nInforme o peso da caixa: ', async (answer) => {
            const peso = Number.parseFloat(answer);
            pilha.empilhar(new Caixa(peso));
            readLine();
          });
          break;
        case 2:
          pilha.pop();
          readLine();
          break;
        case 3:
          console.log('\n', pilha.caixas);
          readLine();
          break;
        default:
          rl.close();
          return false;
      }
    } catch (error) {
      console.log(error.message);
      readLine();
    }
  });
})();
