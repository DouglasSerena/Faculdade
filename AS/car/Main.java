import java.util.Scanner;

import Source.*;

public class Main {
  public static Scanner console = new Scanner(System.in);
  public static boolean running = true;

  public static void main(String[] args) {
    Options options = new Options(console);

    do {
      // MENU
      System.out.print("\n\033[1;37mOpções carrinho:\n");
      System.out.print("1 - Adicionar\n");
      System.out.print("2 - Remover\n");
      System.out.print("3 - Listar Itens\n");
      System.out.print("4 - Ver total da lista\n");
      System.out.print("5 - Encerrar\n");
      System.out.print("➡ ");
      String option = console.next();

      switch (option) {
        case "1":
          console.nextLine();
          options.add();
          break;

        case "2":
          console.nextLine();
          options.remove();
          break;

        // LIST
        case "3":
          options.list();
          break;

        // VALOR TOTAL
        case "4":
          options.total();
          break;

        // ENCERRAR
        case "5":
          System.out.print("\nEncerrando programa...\n");
          running = false;
          break;

        // SEM ROTA
        default:
          System.out.print("\n" + whiteTag("WARNING", "\033[1;33m") + "Opção não definida\n");
          break;
      }
    } while (running);
  }

  // TAG
  private static String whiteTag(String tag, String color) {
    return "\033[1;37m[" + color + tag + "\033[1;37m] ";
  }
}
