package Source;

import java.util.Random;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("> Programa sendo inciado...\n");

    Scanner console = new Scanner(System.in);
    Random random = new Random();

    int index = random.nextInt(12);

    System.out.println(Month.get[index]);

    console.close();

    System.out.println("\n> Programa encerrado.");
  }
}