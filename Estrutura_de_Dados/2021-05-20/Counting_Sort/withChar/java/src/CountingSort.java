package src;

public class CountingSort {
  public static char[] order(char[] array) {
    int size = array.length;

    char[] output = new char[size];
    int[] count = new int[256];

    for (char item : array) {
      int code = (int) item;
      count[code]++;
    }

    for (int i = 1; i < 256; ++i) {
      count[i] += count[i - 1];
    }

    for (var i = size - 1; i >= 0; i--) {
      output[count[(int) array[i]] - 1] = array[i];
      count[(int) array[i]] -= 1;
    }

    return output;
  }
}
