public class MyArrays {
  public static void main(String[] args) {
    int[] arrayOne = { 1, 2, 4, 5, 6 };
    int[] arrayTwo = { 1, 2, 3, 4, 5 };
    System.out.println("Encontrado " + fetchArrayInt(arrayOne, arrayTwo, 3));

    System.out.println("=============================");

    int[] array = randomArrayInt(5);
    for (int index = 0; index < array.length; index++)
      System.out.print("|" + array[index] + "|");
  }

  static int fetchArrayInt(int[] arrayOne, int[] arrayTwo, int valueFind) {
    boolean foundOne = existValue(arrayOne, valueFind);
    boolean foundTwo = existValue(arrayTwo, valueFind);
    if (foundOne && foundTwo)
      return 2;
    else if (!foundOne && !foundTwo)
      return 0;
    return 1;
  }

  static boolean existValue(int[] array, int value) {
    for (int i : array)
      if (i == value)
        return true;
    return false;
  }

  static int[] randomArrayInt(int value) {
    int[] array = new int[value];
    for (int index = 0; index < value; index++)
      array[index] = random();
    return array;
  }

  static int random() {
    return (int) Math.round(Math.random() * 1000);
  }
}
