package Source;

import java.util.Scanner;

/**
 * Main
 */
public class Main {
  private static int index = 0;
  private static int value = 0;
  private static int values = 0;
  private static double media = 0.0;

  public static void main(String[] args) {
    System.out.println("> Programa sendo inciado...\n");

    Scanner console = new Scanner(System.in);

    do {
      System.out.print("Informe um valor: ");
      value = console.nextInt();
      if (value != 0 && value % 3 == 0) {
        ++index;
        values += value;
        media = values / index;
      }
    } while (value != 0);

    System.out.println("Media dos valores: " + media);
    System.out.println("Soma dos valores: " + values);

    console.close();

    System.out.println("> Programa encerrado.\n");
  }
}