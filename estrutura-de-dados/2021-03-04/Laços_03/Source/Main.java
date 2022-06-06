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

    while (value != 99) {
      System.out.print("Informe um valor: ");
      value = console.nextInt();
      index++;
      values += value;
      media = values / index;
    }

    System.out.println("Media dos valores: " + media);
    System.out.println("Soma dos valores: " + values);

    console.close();

    System.out.println("> Programa encerrado.\n");
  }
}