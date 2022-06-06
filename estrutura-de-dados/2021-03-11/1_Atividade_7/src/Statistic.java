package src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Statistic {
  public static int sizeGraphic = 5;
  private int[][] _data;
  private int[] _dataVetor;
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
    this._dataVetor = new int[sizeGraphic * sizeGraphic];

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
    this._dataVetor = new int[sizeGraphic * sizeGraphic];

    for (int row = 0; row < sizeGraphic; row++) {
      for (int col = 0; col < sizeGraphic; col++) {
        this._data[row][col] = this._random.nextInt(10);
        this._valueTotal += this._data[row][col];
        if (this._data[row][col] > this._moreValue)
          this._moreValue = this._data[row][col];
      }
    }
  }

  public void elementsFrequency() {
    int arrayFrequency[] = new int[this._moreValue + 1];
    for (int index = 0; index < arrayFrequency.length; index++) {
      for (int row = 0; row < sizeGraphic; row++) {
        for (int col = 0; col < sizeGraphic; col++) {
          if (index == this._data[row][col]) {
            arrayFrequency[index]++;
          }
        }
      }
    }

    int frequency = 0;
    int value = 0;
    for (int index = 0; index < arrayFrequency.length; index++) {
      if (arrayFrequency[index] > value) {
        value = index;
        frequency = arrayFrequency[index];
      }
    }
    System.out.println("\n> Elemento " + value + " teve uma frequente de " + frequency);
  }

  public int elementsCenter() {
    int index = 0;
    for (int row = 0; row < sizeGraphic; row++) {
      for (int col = 0; col < sizeGraphic; col++) {
        this._dataVetor[index] = this._data[row][col];
        index++;
      }
    }

    this._dataVetor = this.sort(this._dataVetor);

    int length = this._dataVetor.length;
    return this._dataVetor[length / 2];
  }

  private int[] sort(int... values) {
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

  public double calcMedia() {
    return this._valueTotal / (sizeGraphic * sizeGraphic);
  }
}