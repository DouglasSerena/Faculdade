package src;

import java.util.Scanner;

public class Triangle {
  private int _base;
  private int _height;
  private Scanner _console;

  Triangle(Scanner console) {
    this._console = console;
  }

  public void readProps() {
    System.err.print("Informe a base do triangulo: ");
    this._base = this._console.nextInt();
    System.err.print("Informe a altura do triangulo: ");
    this._height = this._console.nextInt();
  }

  public int calcArea() {
    return this.calcArea(this._base, this._height);
  }

  public int calcArea(int base, int height) {
    return base * height / 2;
  }
}
