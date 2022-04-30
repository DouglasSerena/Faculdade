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

    int[] date = new int[] { 
      random.nextInt(20),
      random.nextInt(20),
      random.nextInt(20),
      random.nextInt(20),
      random.nextInt(20)
    };

    System.out.println("{" + join(date, ",") + "}\n");

    console.close();

    System.out.println("> Programa encerrado.");
  }

  private static String join(int[] array, String separator) {
    String value = "";

    for (int index = 0; index < array.length; index++)
      value += array[index] + (index < array.length - 1 ? separator : "");

    return value;
  }
}