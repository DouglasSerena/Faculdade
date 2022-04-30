import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);

        int vector[] = new int[50];

        for (int index = 0; index < 50; index++) {
            vector[index] = 100 + (index + 1);
        }

        for (int index = 0; index < 50; index++) {
            System.out.print("|" + vector[index] + "|");
        }

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
