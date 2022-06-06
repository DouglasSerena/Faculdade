import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);

        int[] vector = new int[10];
        for (int index = 0; index < vector.length; index++) {
            System.out.print("Informe um valor inteiro: ");
            vector[index] = console.nextInt();
        }

        Arrays.sort(vector);
        System.out.println("Vetor ao contratiro");
        for (int index = 0; index < vector.length; index++) {
            System.out.print("| " + vector[index] + " |");
        }

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
