import java.util.Random;
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
    Random random = new Random();

    int[] values_1 = new int[10];
    int[] values_2 = new int[5];

    int controlSizeVector = 0;

    System.out.print("Escrever valores?\n1 - Sim\n2 - Não\n> ");
    int option = console.nextInt();

    for (int index = 0; index < 10; index++) {
      if (option == 1) {
        System.out.print("Informe o valor do primeiro vetor: ");
        values_1[index] = console.nextInt();
      } else
        values_1[index] = random.nextInt(100);

      if (values_1[index] % 2 == 0)
        controlSizeVector++;
    }

    for (int index = 0; index < 5; index++) {
      if (option == 1) {
        System.out.print("Informe o valor do segundo vetor: ");
        values_2[index] = console.nextInt();
      } else
        values_2[index] = random.nextInt(100);
    }

    int[] vectorResultPairs = new int[controlSizeVector];
    int[] vectorResultOdd = new int[10 - controlSizeVector];

    for (int index = 0; index < vectorResultPairs.length; index++)
      for (int index_2 = 0; index_2 < 10; index_2++)
        if (values_1[index_2] % 2 == 0) {
          vectorResultPairs[index] = values_1[index_2];
          for (int index_3 = 0; index_3 < 5; index_3++)
            vectorResultPairs[index] += values_2[index_3];
        }

    for (int index = 0; index < vectorResultOdd.length; index++)
      for (int index_2 = 0; index_2 < 10; index_2++)
        if (values_1[index_2] % 3 == 0) {
          vectorResultOdd[index] = values_1[index_2];
          for (int index_3 = 0; index_3 < 5; index_3++)
            vectorResultOdd[index] += values_2[index_3];
        }

    System.out.println();

    for (int index = 0; index < vectorResultPairs.length; index++) {
      System.out.println("Resultado vetor par na posição " + (index + 1) + ": " + vectorResultPairs[index]);
    }

    System.out.println();

    for (int index = 0; index < vectorResultOdd.length; index++) {
      System.out.println("Resultado vetor impar na posição " + (index + 1) + ": " + vectorResultOdd[index]);
    }

    console.close();

    System.out.println("\n> Programa encerrado.");
  }
}