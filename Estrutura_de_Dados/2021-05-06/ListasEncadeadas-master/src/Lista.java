public class Lista {

    Pessoa inicio;
    Pessoa fim;
    int tamanho;

    public boolean adicionar(Pessoa pessoa) {
        if (this.inicio == null) {
            inicio = pessoa;
            fim = pessoa;
            this.tamanho++;
            return true;
        } else {
            pessoa.proximo = this.inicio;
            this.inicio = pessoa;
            tamanho++;
            return true;
        }
    }

    public boolean adicionarFinal(Pessoa pessoa) {
        if (this.inicio == null) {
            return this.adicionar(pessoa);
        } else {
            this.fim.proximo = pessoa;
            this.fim = pessoa;
            this.tamanho++;
            return true;
        }
    }

    public void remover(int indice) {
        Pessoa aux = this.inicio;
        int contador = 0;

        if (indice == 0) {
            this.inicio = aux.proximo;
        } else {
            while (aux != null) {
                if (indice - 1 == contador) {
                    aux.proximo = aux.proximo.proximo;
                    if (indice == tamanho - 1) {
                        this.fim = aux;
                    }
                }
                aux = aux.proximo;
                contador++;
            }
        }
        tamanho--;
    }

    public void exibir() {
        Pessoa aux = this.inicio;
        if (aux == null) {
            System.out.println("Lista vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.nome);
                aux = aux.proximo;
            }
            System.out.println("");
        }
    }
}
