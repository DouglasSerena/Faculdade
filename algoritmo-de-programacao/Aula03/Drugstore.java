import java.text.DecimalFormat;
import java.util.Scanner;

public class Drugstore {
  private static Scanner in = new Scanner(System.in);
  private static DecimalFormat df = new DecimalFormat("R$ ###.00");
  private static double present = 1.12;

  public static void main(String[] args) {
    Double value;
    do {
      console("Valor do produto: ");
      value = in.nextDouble();
      if (value != 0)
        console("Novo valor com os 12% de acréscimo " + df.format(calcValueFinish(value)) + "\n");
    } while (value != 0);
    console("Programa encerrado.");
  }

  public static long calcValueFinish(double value) {
    return Math.round(value * present);
  }

  private static void console(String message) {
    System.out.print(message);
  }
}
