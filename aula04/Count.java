public class Count {
  public static void main(String[] args) throws InterruptedException {
    tell();
    System.out.print("\n");
    tell(5);
    System.out.print("\n");
    tell(1, 13);
    System.out.print("\n");
    tell(1, 10, 1);
  }

  static void tell() {
    for (int index = 1; index <= 10; index++)
      System.out.print("|" + index + "|");
  }

  static void tell(int end) {
    for (int index = 1; index <= end; index++)
      System.out.print("|" + index + "|");
  }

  static void tell(int start, int end) {
    for (int index = start; index < end; index++)
      System.out.print("|" + index + "|");
  }

  static void tell(int start, int end, long pause) throws InterruptedException {
    for (int index = start; index < end; index++) {
      System.out.print("|" + index + "|");
      Thread.sleep(pause * 1000);
    }
  }
}
