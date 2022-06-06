import src.MergeSort;

class Main {
  public static void main(String[] args) {
    int[] array = new int[] { 15, 12, 67, 7, 15, 19, 21, 12, 55, 5, 9, 11, 90 };

    System.out.print("Array antes: ");
    for (int item : array) {
      System.out.print("|" + item + "|");
    }

    MergeSort.order(array);

    System.out.println("");

    System.out.print("Array depois: ");
    for (int item : array) {
      System.out.print("|" + item + "|");
    }
  }
}