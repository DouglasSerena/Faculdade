import java.util.Random;
import java.util.Scanner;

class Matriz {
  public static int size = 4;
  private int[][] _data;
  private Random _random;
  private Scanner _console;

  Matriz(Random random, Scanner console) {
    this._random = random;
    this._console = console;
    this._data = new int[size][size];
  }

  public void showElements() {
    System.out.println();
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        System.out.print("| " + (this._data[row][col] < 10 ? ("  " + this._data[row][col])
            : this._data[row][col] < 100 ? (" " + this._data[row][col]) : this._data[row][col]) + " |");
      }
      System.out.println("");
    }
    System.out.println();
  }

  public String addElement() {
    System.out.print("Linha (1 a " + size + "): ");
    int row = (this._console.nextInt()) - 1;
    System.out.print("Coluna (1 a " + size + "): ");
    int col = (this._console.nextInt()) - 1;

    System.out.print("Valor: ");
    int value = this._console.nextInt();

    String response = _existPosition(row, col);

    if (response == null) {
      response = _existValueAndPosition(row, col);
      if (response == null) {
        this._addElement(row, col, value);
        return null;
      } else {
        System.out.println(response);
        System.out.print("Continuar (1 - sim | 2 - não): ");
        int option = this._console.nextInt();
        if (option == 1) {
          this._addElement(row, col, value);
        }
        return null;
      }
    }
    return response;
  }

  public String removeElement() {
    System.out.print("Linha (1 a " + size + "): ");
    int row = (this._console.nextInt()) - 1;
    System.out.print("Coluna (1 a " + size + "): ");
    int col = (this._console.nextInt()) - 1;

    String response = _existPosition(row, col);

    if (response == null) {
      this._addElement(row, col, 0);
      return null;
    }
    return response;
  }

  public void clear() {
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        this._data[row][col] = 0;
      }
    }
  }

  private String _existPosition(int row, int col) {
    try {
      int tmp = this._data[row][col];
      return null;
    } catch (Exception error) {
      return "A Coluna ou linha informada não corresponseponde a matriz.";
    }
  }

  private String _existValueAndPosition(int row, int col) {
    String response = this._existPosition(row, col);
    if (response == null) {
      int tmp = this._data[row][col];
      if (tmp == 0)
        return null;
      return "Posição ja preenchida.";
    }
    return response;
  }

  private String _addElement(int row, int col, int value) {
    String response = this._existPosition(row, col);
    if (response == null)
      this._data[row][col] = value;

    return response;
  }
}