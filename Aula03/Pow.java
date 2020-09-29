import java.util.Scanner;

public class Pow {
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    console("Valor: ");
    int value = in.nextInt();
    console("Potencial: ");
    int pow = in.nextInt();
    console("Potencial de " + value + ": " + Math.pow(value, pow));
  }

  private static void console(String message) {
    System.out.print(message);
  }
}
