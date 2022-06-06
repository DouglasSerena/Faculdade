public class Hash {
  public static void main(String[] args) {
    int value = numberRandom(5, 10);
    console("=> valor entre (5 , 10): " + value + "\n=> senha: " + hash(value));
  }

  private static String hash(int length) {
    String hash = "";
    for (int i = 0; i < length; i++) {
      hash += String.valueOf(numberRandom(0, 10));
    }
    return hash;
  }

  private static void console(String message) {
    System.out.println(message);
  }

  private static int numberRandom(int min, int max) {
    return (int) Math.round(Math.random() * (max - min) + min);
  }
}
