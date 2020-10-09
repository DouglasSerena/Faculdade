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

  static void tell() throws InterruptedException {
    tell(1, 10);
  }

  static void tell(int end) throws InterruptedException {
    tell(1, end);
  }

  static void tell(int start, int end) throws InterruptedException {
    tell(start, end, 0);
  }

  static void tell(int start, int end, int pause) throws InterruptedException {
    for (int index = start; index < end; index++) {
      System.out.print("|" + index + "|");
      Thread.sleep(pause * 1000);
    }
  }
}
