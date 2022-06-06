package src;

import java.util.Scanner;

public class Rectangle {
  private int _base;
  private int _height;
  private Scanner _console;

  Rectangle(Scanner console) {
    this._console = console;
  }

  public void readProps() {
    System.err.print("Informe a base do retângulo: ");
    this._base = this._console.nextInt();
    System.err.print("Informe a altura do retângulo:");
    this._height = this._console.nextInt();
  }

  public int calcArea() {
    return calcArea(this._base, this._height);
  }

  public int calcArea(int base, int height) {
    return base * height;
  }
}
