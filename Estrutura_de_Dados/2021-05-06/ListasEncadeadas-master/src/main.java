public class main {
    public static void main(String[] args) {

        Lista lista = new Lista();

        Pessoa pessoa = new Pessoa("nome_3", 30);
        lista.adicionar(pessoa);

        pessoa = new Pessoa("nome_2", 30);
        lista.adicionar(pessoa);

        pessoa = new Pessoa("nome_1", 30);
        lista.adicionar(pessoa);

        pessoa = new Pessoa("nome_0", 30);
        lista.adicionar(pessoa);
        lista.remover(0);

        lista.exibir();
    }
}
