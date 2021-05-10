import java.lang.invoke.LambdaMetafactory;
import java.util.Arrays;
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

    int[] values = new int[10];

    System.out.print("Escrever valores?\n1 - Sim\n2 - Não\n> ");
    int option = console.nextInt();

    for (int index = 0; index < 10; index++) {
      if (option == 1) {
        System.out.print("Informe o valor: ");
        values[index] = console.nextInt();
      } else
        values[index] = random.nextInt(100);
    }

    boolean valuesMoreFifty = false;
    for (int index = 0; index < 10; index++) {
      if (values[index] > 50) {
        System.out.println("valor " + values[index] + " é maior que 50 e esta na posição " + (index + 1));
        valuesMoreFifty = true;
      }
    }

    if (valuesMoreFifty == false) {
      System.out.println("Não existir nenhum número nessa condição");
    }

    console.close();

    System.out.println("\n> Programa encerrado.");
  }
}