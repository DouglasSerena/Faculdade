import java.util.ArrayList;

import Utils.*;

class Main {
  private static ArrayList<Account> accounts = new ArrayList<Account>();
  private static Account accountSelect = null;
  private static boolean running = true;
  private static Console console = new Console();

  public static void main(String[] args) {
    console.log(Color.PURPLE_BOLD + "\n > Iniciando programa...\n");

    createAccount(false);

    do {
      if (accountSelect != null)
        console.log(Color.WHITE_BOLD + Color.WHITE_UNDERLINE + "\nUsuário:" + Color.RESET + Color.WHITE_BOLD + " "
            + accountSelect.holder.getName());
      char option = console
          .readChar(Color.WHITE_BOLD + "\nOPÇÕES:\n" + Color.BLUE_BOLD + " - Criar conta (1)\n" + Color.BLUE_BOLD
              + " - Balanco da conta (2)\n" + Color.BLUE_BOLD + " - Extrato (3)\n" + Color.BLUE_BOLD + " - Sacar (4)\n"
              + Color.BLUE_BOLD + " - Depositar (5)\n" + Color.BLUE_BOLD + " - Transferência (6)\n" + Color.BLUE_BOLD
              + " - Trocar de conta (7)\n" + Color.BLUE_BOLD + " - Encerrar programa (0)\n" + Color.WHITE_BOLD + " > ");

      switch (option) {
        case '0':
          pauseProgram();
          break;
        case '1':
          console.read("");
          createAccount(true);
          break;
        case '2':
          balances();
          break;
        case '3':
          extract();
          break;
        case '4':
          withdraw();
          break;
        case '5':
          deposit();
          break;
        case '6':
          transfer();
          break;
        case '7':
          toggleAccount();
          break;
        default:
          showError("Opção não encontrada.", false);
      }
    } while (running);
  }

  // OPTION 0
  public static void pauseProgram() {
    console.log(Color.PURPLE_BOLD + "\nPrograma encerado...\n\n");
    running = false;
  }

  // OPTION 1
  public static void createAccount(boolean optionPause) {
    boolean personInvalid = true;
    do {
      try {
        String name = console.read(Color.WHITE_BOLD + "\nQual seu nome: ");
        String cpf = console.read(Color.WHITE_BOLD + "Qual é seu cpf: ");
        String birthDay = console.read(Color.WHITE_BOLD + "Qual sua data de nascimento: ");

        Person client = new Person(name, cpf, birthDay);

        accountSelect = new Account(client, accounts.size());
        accounts.add(accountSelect);

        personInvalid = false;
      } catch (Exception err) {
        showError(err.getMessage(), false);
        if (optionPause) {
          String res = console.read(Color.WHITE_BOLD + "Você quer parar: ");
          if ((res.toLowerCase()).contains("sim"))
            return;
        }
      }
    } while (personInvalid);
  }

  // OPTION 2
  public static void balances() {
    try {
      setAccount();

      console.log("\n" + accountSelect.balances() + "\n");
    } catch (Exception err) {
      showError(err.getMessage(), false);
    }
    stop();
  }

  // OPTION 3
  public static void extract() {
    try {
      setAccount();

      console.log(Color.WHITE_BOLD + "\n" + "Extrato bancário:\n" + accountSelect.extract() + "\n");
    } catch (Exception err) {
      showError(err.getMessage(), false);
    }
    stop();
  }

  // OPTION 4
  public static void withdraw() {
    try {
      setAccount();

      double value = console.readDouble(Color.GREEN_BOLD + "\nQual valor você quer sacar: R$ ");

      accountSelect.withdraw(value);
    } catch (Exception err) {
      showError(err.getMessage(), true);
    }
  }

  // OPTION 5
  public static void deposit() {
    try {
      setAccount();
      int value = console.readInt(Color.GREEN_BOLD + "\nQual valor você quer depositar: R$ ");
      accountSelect.deposit(value);
    } catch (Exception err) {
      showError(err.getMessage(), true);
    }
  }

  // OPTION 6
  public static void transfer() {
    try {
      if (accounts.size() < 2)
        throw new Exception("Adicione mais contas");
      // o usuário pode listar a conta que deseja mandar o dinheiro
      listAccount();

      int res = console.readInt(Color.WHITE_BOLD + "\nSelecione um conta: ") - 1;
      // mas não pode
      if (res == accountSelect.getPosition())
        throw new Exception("Você nâo pode mandar dinheiro para você mesmo.");

      double value = console
          .readDouble(Color.WHITE_BOLD + "\nValor de transferência para " + accounts.get(res).holder.getName() + " : ");

      accountSelect.transfer(accounts.get(res), value);
    } catch (Exception err) {
      showError(err.getMessage(), true);
    }
  }

  // OPTION 7
  public static void toggleAccount() {
    try {
      if (accounts.size() < 2)
        throw new Exception(Color.YELLOW_BOLD + " Adicione mais contas");

      listAccount();

      int res = console.readInt(Color.WHITE_BOLD + "\nSelecione uma conta: ") - 1;

      if (res == accountSelect.getPosition())
        throw new Exception("Você ja esta usando essa conta.");

      accountSelect = accounts.get(res);
    } catch (Exception err) {
      showError(err.getMessage(), true);
    }
  }

  // OTHER
  public static void setAccount() throws Exception {
    if (accountSelect == null)
      throw new Exception(Color.RED_BOLD + "Crie uma conta.");
  }

  public static void listAccount() {
    int index = 0;
    for (Account account : accounts) {
      index++;

      console.log(Color.WHITE_BOLD + "\n - [" + index + "] " + account.holder.getName() + " agencia: " + account.agency
          + " " + account.number);

      if (account.getPosition() == accountSelect.getPosition())
        console.log(Color.YELLOW_BOLD + " (Conta atual)");
    }
  }

  public static void stop() {
    console.read("");
    console.read(Color.WHITE_BOLD + "\n Aperte ENTER para continuar.\n");
  }

  public static void showError(String message, boolean stop) {
    console.log(Color.RED_BOLD + "\n> Error: " + message + "\n");
    if (stop)
      stop();
  }
}
