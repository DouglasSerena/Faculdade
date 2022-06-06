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

    public void adicionar(Pessoa pessoa, int indice) {
        if (this.inicio == null || indice == 0) {
            if (indice == 0) {
                System.out.println("Pessoa adicionado na posição: " + indice);
            } else {
                System.out.println("Posição invalida, Adicionado no começões da lista");
            }
            this.adicionar(pessoa);
            return;
        }
        if (indice >= tamanho) {
            System.out.println("Posição invalida, Adicionado no final da lista");
            adicionarFinal(pessoa);
            return;
        }

        Pessoa aux = this.inicio;
        for (int contador = 0; contador < this.tamanho; contador++) {
            if (indice - 1 == contador) {
                System.out.println("Pessoa adicionado na posição: " + indice);
                pessoa.proximo = aux.proximo;
                aux.proximo = pessoa;
                tamanho++;
                return;
            }
            aux = aux.proximo;
        }
    }

    public void remover(int indice) {
        if (tamanho == 1) {
            this.inicio = null;
            this.fim = null;
            return;
        }

        if (indice < 0 || indice >= tamanho) {
            System.out.println("Posição invalida informa outra posição");
            return;
        }

        Pessoa aux = this.inicio;

        if (indice == 0) {
            this.inicio = aux.proximo;
            System.out.println("Pessoa removida da posição: " + indice);
            return;
        }

        int contador = 0;

        while (aux != null) {
            if (indice - 1 == contador) {
                System.out.println("Pessoa removida da posição: " + indice);
                aux.proximo = aux.proximo.proximo;
                if (indice == tamanho - 1) {
                    this.fim = aux;
                }
                tamanho--;
                return;
            }
            aux = aux.proximo;
            contador++;
        }
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
