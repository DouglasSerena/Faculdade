package Source;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Options {
  public Scanner console;
  public ArrayList<Item> itens = new ArrayList<>();

  public Options(Scanner console) {
    this.console = console;
  }

  // ADD
  public void add() {
    System.out.print("\n" + whiteTag("CREATE", "\033[1;32m") + "Adicionar um item");

    System.out.print("\n\033[1;37mName: ");
    String name = console.nextLine();

    for (Item item : itens) {
      if (name.toLowerCase().equals(item.getName().toLowerCase())) {
        item.update();
        return;
      }
    }

    itens.add(new Item(name));
  }

  // LIST
  public void list() {
    System.out.print("\n" + whiteTag("LIST", "\033[1;36m") + "Listar itens\n");

    if (itens.size() > 0) {
      for (Item item : itens) {
        System.out.print("[\033[1;33m" + item.getCount() + "\033[1;37m] " + item.getName() + " \033[1;32m"
            + formatPrice(item.getPrice()) + "\033[1;37m\n");
      }
      System.out.print("\n");
    } else
      System.out.print("Sem item no carrinho\n");
  }

  // TOTAL
  public void total() {
    double[] total = { 0, 0.0 };
    for (Item item : itens) {
      total[0] += item.getCount();
      total[1] += item.getPriceFull();
    }

    System.out.print("\n" + whiteTag("VALOR", "\033[1;32m") + "Valor total dos itens\n");
    System.out.print("➡ \033[1;32m" + formatPrice(total[1]) + "\033[1;37m\n");

    System.out.print(whiteTag("COUNT", "\u001B[34m") + "Quantidade de itens\n");
    System.out.print("➡ \u001B[34m" + ((int) total[0]) + "\033[1;37m\n");
  }

  // REMOVE
  public void remove() {
    if (itens.size() > 0) {
      System.out.print("\n" + this.whiteTag("LIST", "\033[1;36m") + "Listar itens\n");
      this.list();

      System.out.print("\n" + this.whiteTag("REMOVE", "\033[1;31m") + "Remover itens");
      System.out.print("\n➡ ");

      String result = console.nextLine();

      int length = itens.size();

      for (Item item : itens) {
        if (result.toLowerCase().equals(item.getName().toLowerCase())) {
          itens.remove(item);
          break;
        }
      }
      if (length == itens.size())
        System.out.print("\n" + this.whiteTag("ERROR", "\033[1;31m") + "Não foi removido '" + result + "' da lista\n");
      else {
        System.out.print("\n" + this.whiteTag("SUCCESS", "\033[1;32m") + "Removido com sucesso \n");
        System.out.print("" + this.whiteTag("ITEM", "\u001B[34m") + result + "\n");
      }
    } else {
      System.out.print("\n" + whiteTag("WARNING", "\033[1;33m") + "Sem itens no carrinho\n");
    }
  }

  // TAG
  private String whiteTag(String tag, String color) {
    return "\033[1;37m[" + color + tag + "\033[1;37m] ";
  }

  // FORMAT
  public static String formatPrice(double value) {
    DecimalFormat df = new DecimalFormat();
    df.applyPattern("R$ #,##0.00");

    return df.format(value);
  }
}
