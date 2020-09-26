package Aula11;

public class Count {
  private static int index = 0;

  public static void main(String[] args) throws InterruptedException {
    tell(1, 10, 1);
  }

  static void tell() {
    index = 1;
    while (index <= 10) {
      System.out.print(index + " ");
      index++;
    }
  }

  static void tell(int end) {
    index = 1;
    while (index <= end) {
      System.out.print(index + " ");
      index++;
    }
  }

  static void tell(int start, int end) {
    index = start;
    while (index <= end) {
      System.out.print(index + " ");
      index++;
    }
  }

  static void tell(int start, int end, long pause) throws InterruptedException {
    index = start;
    while (index <= end) {
      System.out.print(index + " ");
      Thread.sleep(pause * 1000);
      index++;
    }
  }
}
