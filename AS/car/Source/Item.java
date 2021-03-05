package Source;

import java.util.ArrayList;
import java.util.Scanner;

public class Item {
  // ATTRIBUTES
  private String name;
  private int count;
  private double price;

  // TOOLS
  private Scanner console = new Scanner(System.in);

  // GETTERS
  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return this.price;
  }

  public double getPriceFull() {
    return this.price * this.count;
  }

  public int getCount() {
    return this.count;
  }

  // SETTER
  public void setPrice(double price) {
    if (price > 0)
      this.price = price;
  }

  public void setCount(int count) {
    if (count > 0)
      this.count = count;
  }

  public Item() {
    System.out.print("\n\033[1;37mName: ");
    String name = console.nextLine();

    this.create(name);
  }

  public Item(String name) {
    this.create(name);
  }

  public void create(String name) {
    this.name = name;

    int TmpCount = 0;
    do {
      try {
        System.out.print("Quantidade: ");
        TmpCount = console.nextInt();
        if (TmpCount <= 0) {
          System.out
              .print("\n" + whiteTag("ERROR", "\033[1;31m") + "Quantidade deve ser maio que 0. Tente novamente\n");
        }
      } catch (Exception err) {
        console.nextLine();
        System.out.print("\n" + whiteTag("ERROR", "\033[1;31m") + "Deve ser um valor inteiro\n");
      }
    } while (TmpCount <= 0);
    this.count = TmpCount;

    double TmpPrice = 0.0;
    do {
      try {
        System.out.print("Preço: \033[1;32mR$ ");
        TmpPrice = console.nextDouble();
        if (TmpPrice <= 0) {
          System.out
              .print("\n" + whiteTag("ERROR", "\033[1;31m") + "Preço deve ser maio que R$ 0,00. Tente novamente\n");
        }
      } catch (Exception err) {
        console.nextLine();
        System.out.print("\n" + whiteTag("ERROR", "\033[1;31m") + "Deve ser um valor float\n");
      }
    } while (TmpPrice <= 0);
    this.price = TmpPrice;
  }

  public void update() {
    System.out.print("\n" + whiteTag("UPDATE", "\033[1;36m") + "Atualizar item\n");

    int TmpCount = this.count;
    do {
      try {
        System.out.print("Quantidade: ");
        TmpCount = console.nextInt();
        if (TmpCount <= 0) {
          System.out
              .print("\n" + whiteTag("ERROR", "\033[1;31m") + "Quantidade deve ser maio que 0. Tente novamente\n");
        }
      } catch (Exception err) {
        console.nextLine();
        System.out.print("\n" + whiteTag("ERROR", "\033[1;31m") + "Deve ser um valor inteiro\n");
      }
    } while (TmpCount <= 0);
    this.count = TmpCount;

    double TmpPrice = this.price;
    do {
      try {
        System.out.print("Preço: \033[1;32mR$ ");
        TmpPrice = console.nextDouble();
        if (TmpPrice <= 0) {
          System.out
              .print("\n" + whiteTag("ERROR", "\033[1;31m") + "Preço deve ser maio que R$ 0,00. Tente novamente\n");
        }
      } catch (Exception err) {
        console.nextLine();
        System.out.print("\n" + whiteTag("ERROR", "\033[1;31m") + "Deve ser um valor float\n");
      }
    } while (TmpPrice <= 0);
    this.price = TmpPrice;
  }

  // METHODS
  private String whiteTag(String tag, String color) {
    return "\033[1;37m[" + color + tag + "\033[1;37m] ";
  }
}