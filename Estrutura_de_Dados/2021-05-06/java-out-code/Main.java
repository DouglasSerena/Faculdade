/**
 * main
 */
public class Main {
  public static void main(String[] args) {
    int[][] matrix = { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3 } };

    int j = 0, i = 0;

    for (i = 0; i < 4; i++) {
      for (j = 4; j > i; j--) {
        System.out.print("|" + matrix[i][j] + "|");
      }
      System.out.println("");
    }
  }
}