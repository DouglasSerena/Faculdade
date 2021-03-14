import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Random random = new Random();

        Statistic statistic = new Statistic(random, console);

        statistic.readData();
        statistic.elementsCenter();
        statistic.elementsClock();
        System.out.println("\b> Media dos valore: " + statistic.calcMedia());

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
