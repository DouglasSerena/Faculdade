package Source;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
  public static boolean reading = true;
  public static double media = 0;
  public static double tempeTotal = 0;

  public static void main(String[] args) {
    System.out.println("> Programa sendo inciado...\n");

    Scanner console = new Scanner(System.in);

    List<Tempe> tempes = new ArrayList<Tempe>();
    for (String day : Date.getWeek()) {
      System.out.print("Informe da temperatura de " + day + ": ");
      double response = console.nextDouble();
      tempeTotal += response;
      tempes.add(new Tempe(response, day));
    }

    media = tempeTotal / tempes.size();

    for (Tempe tempe : tempes) {
      if (tempe.value > media) {
        System.out.printf(
            "\nValor da temperatura " + tempe.day + ": " + tempe.value + "\n- ela esta acima da media: %.2f\n", media);
      }
    }

    console.close();

    System.out.println("\n> Programa encerrado.");
  }
}