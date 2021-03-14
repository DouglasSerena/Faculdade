import java.util.Random;
import java.util.Scanner;

class Statistic {
  public static int sizeGraphic = 5;
  private int[][] _data;
  private int _valueTotal;
  private int _moreValue;
  private Random _random;
  private Scanner _console;

  Statistic(Random random, Scanner console) {
    this._random = random;
    this._console = console;
  }

  public void readData() {
    this._moreValue = 0;
    this._data = new int[sizeGraphic][sizeGraphic];
    for (int row = 0; row < sizeGraphic; row++) {
      for (int col = 0; col < sizeGraphic; col++) {
        System.out.print("Informe um valor: ");
        this._data[row][col] = this._console.nextInt();
        this._valueTotal += this._data[row][col];
        if (this._data[row][col] > this._moreValue)
          this._moreValue = this._data[row][col];
      }
    }
  }

  public void readDataRandom() {
    this._moreValue = 0;
    this._data = new int[sizeGraphic][sizeGraphic];
    for (int row = 0; row < sizeGraphic; row++) {
      for (int col = 0; col < sizeGraphic; col++) {
        this._data[row][col] = this._random.nextInt(10);
        this._valueTotal += this._data[row][col];
        if (this._data[row][col] > this._moreValue)
          this._moreValue = this._data[row][col];
      }
    }
  }

  public void elementsClock() {
    int arrayClock[] = new int[this._moreValue + 1];
    for (int index = 0; index < arrayClock.length; index++) {
      for (int row = 0; row < sizeGraphic; row++) {
        for (int col = 0; col < sizeGraphic; col++) {
          if (index == this._data[row][col]) {
            arrayClock[index]++;
          }
        }
      }
    }

    int clock = 0;
    int value = 0;
    for (int index = 0; index < arrayClock.length; index++) {
      if (arrayClock[index] > value) {
        value = index;
        clock = arrayClock[index];
      }
    }
    System.out.println("\n> Elemento " + value + " teve uma frequente de " + clock);
  }

  public void elementsCenter() {
    System.out.println("Valores centrais");
    for (int row = 0; row < sizeGraphic; row++) {
      for (int col = 0; col < sizeGraphic; col++) {
        if (row > 0 && row < sizeGraphic - 1 && col > 0 && col < sizeGraphic - 1) {
          System.out.print(" [" + row + "][" + col + "]" + (this._data[row][col] < 10 ? (this._data[row][col] + "  ")
              : this._data[row][col] < 100 ? (this._data[row][col] + " ") : this._data[row][col]) + " ");
        }
      }
      System.out.println();
    }
  }

  public double calcMedia() {
    return this._valueTotal / (sizeGraphic * sizeGraphic);
  }
}