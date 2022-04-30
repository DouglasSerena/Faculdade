import src.CountingSort;

class Main {
  public static void main(String[] args) {
    char[] array = new char[] { 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J',
        'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };

    System.out.print("Array antes: ");
    for (char item : array) {
      System.out.print("|" + item + "|");
    }

    char[] newArray = CountingSort.order(array);

    System.out.println("");

    System.out.print("Array depois: ");
    for (char item : newArray) {
      System.out.print("|" + item + "|");
    }
  }
}