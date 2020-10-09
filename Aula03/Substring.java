import java.util.Scanner;

public class Substring {
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    console("Digite um palavrar para ser cortado a ultima letra: ");
    String res = in.nextLine();
    console("Nova String: " + res.substring(0, res.length() - 1));
  }

  private static void console(String message) {
    System.out.print(message);
  }
}
