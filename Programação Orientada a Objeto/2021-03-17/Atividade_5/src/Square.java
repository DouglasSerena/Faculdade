package src;

import java.util.Scanner;

public class Square {
  private int _side;
  private Scanner _console;

  Square(Scanner console) {
    this._console = console;
  }

  public void readProps() {
    System.err.print("Informe o lateral do quadrado: ");
    this._side = this._console.nextInt();
  }

  public double calcArea() {
    return this.calcArea(this._side);
  }

  public double calcArea(int side) {
    return Math.pow(side, 2);
  }
}
