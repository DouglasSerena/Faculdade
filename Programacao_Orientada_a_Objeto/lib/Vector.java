public class Vector {
  public int[] sort(int... values) {
    int count = values.length;

    for (int rows = 0; rows < count; rows++)
      for (int cols = rows + 1; cols < count; cols++)
        if (values[rows] > values[cols]) {
          int temp = values[rows];
          values[rows] = values[cols];
          values[cols] = temp;
        }

    return values;
  }
}