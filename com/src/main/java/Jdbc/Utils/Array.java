package Jdbc.Utils;

import java.util.Arrays;

public class Array {
  public static <T> T[] push(T[] arr, T item) {
    T[] tmp = Arrays.copyOf(arr, arr.length + 1);
    tmp[tmp.length - 1] = item;
    return tmp;
  }

  public static <T> T[] pop(T[] arr) {
    T[] tmp = Arrays.copyOf(arr, arr.length - 1);
    return tmp;
  }
}
