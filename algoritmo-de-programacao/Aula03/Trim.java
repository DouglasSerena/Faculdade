import java.util.Scanner;

public class Trim {
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    console("Escreva um Frase: ");
    String res = in.nextLine();
    console(reverse(res));
  }

  private static String reverse(String text) {
    return new StringBuilder(text).reverse().toString().replace(" ", "");
  }

  private static String reverseRough(String text) {
    String stringReverse = "";
    for (int i = text.length() - 1; i >= 0; i--) {
      stringReverse += text.charAt(i);
    }
    return stringReverse.replace(" ", "");
  }

  private static void console(String message) {
    System.out.print(message);
  }
}
