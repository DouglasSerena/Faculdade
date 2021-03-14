import java.util.Random;
import java.util.Scanner;

public class App {
    static boolean running = true;

    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Random random = new Random();
        Matriz matriz = new Matriz(random, console);

        int option = 0;
        String response = null;
        do {
            System.out.println("Selecione um opção:");
            System.out.println("\t- 1 Adicionar Carro;");
            System.out.println("\t- 2 Remover Carro(colocar valor null);");
            System.out.println("\t- 3 Limpar Matriz;");
            System.out.println("\t- 4 Mostrar Matriz;");
            System.out.println("\t- 5 Sair;");
            System.out.print("> ");
            option = console.nextInt();

            switch (option) {
            case 1:
                response = matriz.addElement();
                if (response != null)
                    System.out.println(response);
                System.out.println("");
                break;
            case 2:
                response = matriz.removeElement();
                if (response != null)
                    System.out.println(response);
                System.out.println("");
                break;
            case 3:
                matriz.clear();
                break;
            case 4:
                matriz.showElements();
                break;
            case 5:
                running = false;
            }
        } while (running);

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
