import java.util.Random;
import java.util.Scanner;

class Matriz {
  public static int size = 3;
  private Car[][] _data;
  private Random _random;
  private Scanner _console;

  Matriz(Random random, Scanner console) {
    this._random = random;
    this._console = console;
    this._data = new Car[size][size];
  }

  public void showElements() {
    System.out.println();
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (this._data[row][col] == null)
          System.out.print("|  Vazio   |");
        else
          System.out.print("| " + this._data[row][col].board + " |");
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

    String response = _existPosition(row, col);

    if (response == null) {

      response = _existValueAndPosition(row, col);
      if (response == null) {
        Car value = new Car();
        this._addElement(row, col, value);
        return null;
      } else {
        System.out.println(response);
        System.out.print("Continuar (1 - sim | 2 - não): ");
        int option = this._console.nextInt();
        if (option == 1) {
          Car value = new Car();
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
      this._addElement(row, col, null);
      return null;
    }
    return response;
  }

  public void clear() {
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        this._data[row][col] = null;
      }
    }
  }

  private String _existPosition(int row, int col) {
    try {
      Car tmp = this._data[row][col];
      return null;
    } catch (Exception error) {
      return "A Coluna ou linha informada não corresponseponde a matriz.";
    }
  }

  private String _existValueAndPosition(int row, int col) {
    String response = this._existPosition(row, col);
    if (response == null) {
      Car tmp = this._data[row][col];
      if (tmp == null)
        return null;
      return "Posição ja preenchida.";
    }
    return response;
  }

  private String _addElement(int row, int col, Car value) {
    String response = this._existPosition(row, col);
    if (response == null)
      this._data[row][col] = value;

    return response;
  }
}