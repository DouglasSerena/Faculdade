import java.util.Scanner;

public class Radians {
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    console("Converter Graus ou radianos\n1 Radianos\n2 Graus\n=> ");
    int option = in.nextInt();
    switch (option) {
      case 1:
        console("Radianos: ");
        double radians = in.nextDouble();
        console("Graus " + radians * (180 / Math.PI));
        break;
      case 2:
        console("Graus: ");
        double degrees = in.nextDouble();
        console("Radianos " + degrees * (Math.PI / 180));
        break;
    }
  }

  private static void console(String message) {
    System.out.print(message);
  }
}
