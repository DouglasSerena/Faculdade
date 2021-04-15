import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Utils.*;

public class Account {
  private ArrayList<String> operations = new ArrayList<String>();
  private DecimalFormat formatter = new DecimalFormat("###,###,###.00");
  private double value = 1.0;
  private double limit = 0.0;
  private int position;
  public String number;
  public int agency;

  public Person holder;

  public Account(Person holder, int position) throws Exception {
    if (Store.existCpf(holder.getCpf()))
      throw new Exception("Cliente ja cadastrado.");

    this.holder = holder;
    Store.pushCpf(holder.getCpf());

    int age = holder.getAge();
    if (age < 16)
      throw new Exception("Para abrir um conta dever ter mais que 16 anos.");

    this.number = Math.round(Math.random() * 99999) + "";
    if (Store.existNumberAccount(this.number))
      throw new Exception("Ocorreu um erro inesperado.");
    Store.pushNumberAccount(this.number);

    if (age > 60)
      this.limit = 1000;
    else if (age >= 18)
      this.limit = 300;
    else
      this.limit = 100;
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public double withdraw(double value) throws Exception {
    if (value < 10)
      throw new Exception("Valor minimo R$ 10,00.");

    double valueMoreLimit = this.limit + this.value;

    this.value = value > 0 ? this.value - value : value - valueMoreLimit;

    this.setOperation(Color.WHITE_BOLD + "Saque", Color.GREEN_BOLD + "R$ " + this.formatter.format(value));
    return value;
  }

  public void deposit(double value) throws Exception {
    if (value < 0)
      throw new Exception("Valor invalido.");
    this.setOperation(Color.WHITE_BOLD + "Depositado", Color.GREEN_BOLD + "R$ " + this.formatter.format(value));
    this.value += value;
  }

  public String balances() {
    return Color.WHITE_BOLD + " [" + (this.value < 0 ? Color.RED_BOLD : Color.GREEN_BOLD) + " SALDO " + Color.WHITE_BOLD
        + " ] " + (this.value < 0 ? Color.RED_BOLD : Color.GREEN_BOLD) + "R$ " + this.formatter.format(this.value)
        + "\n" + Color.WHITE_BOLD + " [ " + Color.CYAN_BOLD + "Limite" + Color.WHITE_BOLD + " ] " + Color.GREEN + "R$ "
        + this.formatter.format(this.limit);
  }

  public void transfer(Account account, double value) throws Exception {
    String name = account.holder.getName();
    this.setOperation(Color.WHITE_BOLD + "Transferência",
        Color.GREEN_BOLD + "R$ " + this.formatter.format(value) + Color.WHITE_BOLD + " para ( " + name + " )");
    account.setOperation(Color.WHITE_BOLD + "Recebido", Color.GREEN_BOLD + "R$ " + this.formatter.format(value)
        + Color.WHITE_BOLD + " de ( " + this.holder.getName() + " )");
    account.deposit(this.withdraw(value));
  }

  public String extract() {
    String tmp = this.balances();
    for (String operation : this.operations)
      tmp += Color.WHITE_BOLD + "\n  > " + operation;
    return operations.size() == 0 ? tmp + Color.YELLOW_BOLD + " \n> Não hove operações nessa conta." : tmp;
  }

  public void setOperation(String operation, String content) {
    this.operations.add(operation + ": " + content + Color.WHITE_BOLD + " [ " + timeNow() + " ]");
  }

  public String timeNow() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    return dateFormat.format(date);
  }
}