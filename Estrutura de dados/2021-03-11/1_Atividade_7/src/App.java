package src;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Random random = new Random();

        statistic statistic = new Statistic(random, console);

        statistic.readDataRandom();
        statistic.elementsFrequency();
        System.out.println("\b> Valor centrar: " + statistic.elementsCenter());
        System.out.println("\b> Media dos valore: " + statistic.calcMedia());

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
