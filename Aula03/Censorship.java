import java.util.Scanner;

public class Censorship {
  private static Scanner in = new Scanner(System.in);
  private static String[] filter = { "sexo", "sexual", "java", "php" };

  public static void main(String[] args) {
    console("Digite um palavra: ");
    String word = in.nextLine();
    if (isImproper(word)) {
      console("conteúdo impróprio");
      return;
    }
    console("conteúdo liberado");
  }

  public static boolean isImproper(String word) {
    for (int i = 0; i < filter.length; i++) {
      if (word.contains(filter[i])) {
        return true;
      }
    }
    return false;
  }

  private static void console(String message) {
    System.out.print(message);
  }
}
