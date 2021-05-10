import java.util.Scanner;

public class App {
    static boolean running = true;
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Library library = new Library();

        do {
            System.out.print("\nOptions: \n" + "> 1 - Adicionar livro\n" + "> 2 - Remover livro\n"
                    + "> 3 - listar livros\n" + "> 4 - Sair do programa\n" + "> ");
            int option = console.nextInt();

            System.out.println();

            switch (option) {
            case 1:
                library.add(createBook());
                break;

            case 2:
                library.list();
                library.remove(inputInt("\nQual é o Code do livro para remover: "));
                break;

            case 3:
                library.list();
                break;

            case 4:
                running = false;
                break;

            default:
                System.out.println("Opção não definida.");
            }
        } while (running);

        console.close();

        System.out.println("\n> Programa encerrado.");
    }

    private static Book createBook() {
        return new Book(inputString("Qual é o nome do livro: "), inputString("Qual é o autor do libro: "),
                inputInt("Quantas paginas o livro tem: "), inputDouble("Qual é o proço do livro: "));
    }

    private static String inputString(String message) {
        System.out.print(message);
        return console.next();
    }

    private static int inputInt(String message) {
        System.out.print(message);
        return console.nextInt();
    }

    private static double inputDouble(String message) {
        System.out.print(message);
        return console.nextDouble();
    }
}
