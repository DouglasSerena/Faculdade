package src;

import java.util.Scanner;

public class Triangle {
  private Scanner _console;
  private double _height = 0.0;
  private double _base = 0.0;

  Triangle(Scanner console) {
    this._console = console;
  }

  public void readData() {
    System.out.print("Base do triangulo (cm): ");
    this._base = this._console.nextDouble();

    System.out.print("Altura do triangulo (cm): ");
    this._height = this._console.nextDouble();
  }

  public void showData() {
    System.out.printf("\nAltura do triangulo %.2fcm\n", this._height);
    System.out.printf("Base do triangulo %.2fcm\n", this._base);
    System.out.printf("Area do triangulo %.2fcm²\n\n", this.calcArea());
  }

  public double calcArea() {
    return this._base * this._height;
  }
}
