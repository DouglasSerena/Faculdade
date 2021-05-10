import java.util.Scanner;

public class Console {
  public static Scanner scanner = null;

  public static Scanner instanceScanner() {
    if (scanner != null)
      scanner = new Scanner(System.in);
    return scanner;
  }

  // PRINT CONSOLE
  public static void log(String message) {
    System.out.print(Color.RESET + message);
  }

  // MESSAGE DEFAULT
  public static String read() {
    String res = read("Digite uma String");
    return res;
  }

  public static int readInt() {
    int res = readInt("Digite uma String");
    return res;
  }

  public static float readFloat() {
    float res = readFloat("Digite uma String");
    return res;
  }

  public static double readDouble() {
    double res = readDouble("Digite uma String");
    return res;
  }

  public static char readChar() {
    char res = readChar("Digite uma String");
    return res;
  }

  // MESSAGE PARAMS
  public static String read(String message) {
    log(message);
    String res = instanceScanner().nextLine();
    return res;
  }

  public static int readInt(String message) {
    log(message);
    int res = instanceScanner().nextInt();
    return res;
  }

  public static float readFloat(String message) {
    log(message);
    float res = instanceScanner().nextFloat();
    return res;
  }

  public static double readDouble(String message) {
    log(message);
    double res = instanceScanner().nextDouble();
    return res;
  }

  public static char readChar(String message) {
    log(message);
    String res = instanceScanner().next();
    return res.charAt(0);
  }
}