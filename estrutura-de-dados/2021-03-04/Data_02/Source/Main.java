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

    int[] values = new int[5];

    for (int index = 0; index < 5; index++) {
      System.out.print("Informe um valor inteiro: ");
      values[index] = console.nextInt();
    }

    System.out.print("O que fazer: \n");
    System.out.print("- 0: Finalizar\n");
    System.out.print("- 1: Mostrar vetor em order\n");
    System.out.print("- 2: Mostrar vetor em order inversa\n");
    System.out.print("> ");
    int option = console.nextInt();

    switch (option) {
    case 1:
      for (int index = 0; index < 5; index++) {
        System.out.println("Valor " + (index + 1) + ": " + values[index]);
      }
      break;

    case 2:
      int count = values.length;
      for (int index = count - 1; index >= 0; index--) {
        System.out.println("Valor " + (count - index) + ": " + values[index]);
      }
      break;
    }

    console.close();

    System.out.println("\n> Programa encerrado.");
  }
}