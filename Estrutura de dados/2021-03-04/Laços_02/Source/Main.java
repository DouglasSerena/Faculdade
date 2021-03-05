package Source;

import java.util.Scanner;

/**
 * Main
 */
public class Main {
  private static int year = 0;
  private static int index = 0;
  private static double mediaYear = 0.0;

  public static void main(String[] args) {
    System.out.println("> Programa sendo inciado...\n");

    Scanner console = new Scanner(System.in);

    while (mediaYear < 20 && index < 10) {
      System.out.print("Informe sua idade: ");
      year += console.nextInt();
      index++;
      mediaYear = year / index;

      System.out.println("Media de idades: " + mediaYear + " anos / pessoa: " + index);
    }

    console.close();

    System.out.println("> Programa encerrado.\n");
  }
}