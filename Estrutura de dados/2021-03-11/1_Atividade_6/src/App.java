import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Random random = new Random();

        int vector[] = new int[50];

        for (int index = 0; index < 50; index++)
            vector[index] = random.nextInt(250);

        for (int index = 0; index < 50; index++)
            System.out.print("|" + vector[index] + "|");

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
