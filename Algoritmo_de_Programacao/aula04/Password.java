public class Password {
  public static void main(String[] args) {
    System.out.print(generator());
  }

  static String generator() {
    StringBuffer hash = new StringBuffer();
    for (int index = 0; index < 8; index++)
      hash.append(Math.round(Math.random() * (10 - 1) + 1));
    return hash.toString();
  }
}
