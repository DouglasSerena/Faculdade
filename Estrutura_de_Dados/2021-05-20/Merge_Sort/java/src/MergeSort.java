package src;

public class MergeSort {
  public static void order(int[] array) {
    int left = 0;
    int middle = array.length / 2;
    int right = array.length;

    int[] helper = array.clone();
    
    int index = left;
    int indexJ = middle;
    int indexK = left;

    while (index < middle && indexJ < right) {
      if (helper[index] < helper[indexJ]) {
        array[indexK] = helper[index];
        index++;
      } else {
        array[indexK] = helper[indexJ];
        indexJ++;
      }
      indexK++;
    }
  
    // se a metade inicial não foi toda consumida, faz o append.
    while (index < middle) {
      array[indexK] = helper[index];
      index++;
      indexK++;
    }
  
    // se a metade final não foi toda consumida, faz o append.
    while (indexJ < right) {
      array[indexK] = helper[indexJ];
      indexJ++;
      indexK++;
    }
  }
}
