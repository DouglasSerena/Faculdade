package Source;

import java.util.Scanner;

public class Car {
  String color;
  String board;
  String model;

  Car() {
    Scanner console = new Scanner(System.in);
    System.out.print("Informe a cor do carro: ");
    this.color = console.next();
    System.out.print("Informe a placa do carro: ");
    this.board = console.next();
    System.out.print("Informe o modelo do carro: ");
    this.model = console.next();
  }
}
