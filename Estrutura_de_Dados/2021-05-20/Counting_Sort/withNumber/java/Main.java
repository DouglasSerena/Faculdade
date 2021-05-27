import src.CountingSort;

class Main {
  public static void main(String[] args) {
    int[] array = new int[] { 1, 4, 1, 2, 7, 5, 2 };

    System.out.print("Array antes: ");
    for (int item : array) {
      System.out.print("|" + item + "|");
    }

    int[] newArray = CountingSort.order(array);

    System.out.println("");

    System.out.print("Array depois: ");
    for (int item : newArray) {
      System.out.print("|" + item + "|");
    }
  }
}