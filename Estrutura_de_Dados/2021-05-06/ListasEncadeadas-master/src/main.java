public class main {
    public static void main(String[] args) {

        Lista lista = new Lista();

        Pessoa pessoa = new Pessoa("indice_3", 30);
        lista.adicionar(pessoa);

        pessoa = new Pessoa("indice_2", 30);
        lista.adicionar(pessoa);

        pessoa = new Pessoa("indice_1", 30);
        lista.adicionar(pessoa);

        pessoa = new Pessoa("indice_0", 30);
        lista.adicionar(pessoa);
        // pessoa = new Pessoa("indice_4", 30);
        lista.remover(3);

        lista.exibir();
    }
}
