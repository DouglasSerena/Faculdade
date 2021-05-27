package src;

public class MergeSort {
  public static void order(int[] array) {
    int length = array.length;

    if (length < 2) {
      return;
    }

    int medLength = length / 2;
    int arrayLeft[] = new int[medLength];
    int arrayRight[] = new int[length - medLength];

    for (int index = 0; index < medLength; index++) {
      arrayLeft[index] = array[index];
    }
    for (int index = medLength; index < length; index++) {
      arrayRight[index - medLength] = array[index];
    }

    order(arrayLeft);
    order(arrayRight);

    merge(array, arrayLeft, arrayRight);
  }

  public static void merge(int[] array, int[] arrayLeft, int[] arrayRight) {
    int leftLength = arrayLeft.length;
    int rightLength = arrayRight.length;

    int index = 0;
    int indexJ = 0;
    int indexK = 0;

    while (index < leftLength && indexJ < rightLength) {
      if (arrayLeft[index] <= arrayRight[indexJ]) {
        array[indexK] = arrayLeft[index];
        index++;
      } else {
        array[indexK] = arrayRight[indexJ];
        indexJ++;
      }
      indexK++;
    }

    while (index < leftLength) {
      array[indexK] = arrayLeft[index];
      index++;
      indexK++;
    }

    while (indexJ < rightLength) {
      array[indexK] = arrayRight[indexJ];
      indexJ++;
      indexK++;
    }
  }
}
