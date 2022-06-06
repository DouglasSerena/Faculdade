package src;

import java.util.Scanner;

public class Cycle {
  private int _lightning;
  private Scanner _console;

  Cycle(Scanner console) {
    this._console = console;
  }

  public void readProps() {
    System.err.print("Informe o raio do circulo: ");
    this._lightning = this._console.nextInt();
  }

  public double calcArea() {
    return this.calcArea(this._lightning);
  }

  public double calcArea(int lightning) {
    return Math.PI * Math.pow(lightning, 2);
  }
}
