import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
  private static boolean running = true;
  private static Scanner console = new Scanner(System.in);
  private static DecimalFormat df = new DecimalFormat();

  public static void main(String[] args) {
    System.out.print("\033[1;37mIniciando o programa...");

    do {
      try {
        System.out.print("\n1 - converter real para dólar");
        System.out.print("\n2 - converter real para bitcoin");
        System.out.print("\n3 - converter dólar para real");
        System.out.print("\n4 - converter dolar para real e bitcoin (exibir)");
        System.out.print("\n➡ ");
        int option = console.nextInt();

        double count = 0.0;
        double price = 0.0;

        switch (option) {
          // CONVERSÃO DE REAIS PARA DÓLAR
          case 1:
            count = getPrice("\u001B[37m\nInforme a quantidade de reais par converter" + "\n=>\033[1;32m R$ ");
            price = getPrice("\u001B[37m\nInforme a cotação do dólar para a conversão" + "\n=>\033[1;32m R$ ");

            showMoney(realToDolar(count, price), "$");
            break;

          // CONVERSÃO DE REAL PARA BITCOIN
          case 2:
            count = getPrice("\u001B[37m\nInforme a quantidade de reais par converter" + "\n=>\033[1;32m R$ ");
            price = getPrice("\u001B[37m\nInforme a cotação do bitcoin para a conversão" + "\n=>\033[1;32m R$ ");

            showMoney(reaToBitcoin(count, price), "BITCOIN");
            break;

          // CONVERSÃO DE DÓLAR PARA REAL
          case 3:
            count = getPrice("\u001B[37m\nInforme a quantidade de dólar par converter" + "\n=>\033[1;32m $ ");
            price = getPrice("\u001B[37m\nInforme a cotação do dólar para a conversão" + "\n=>\033[1;32m R$ ");

            showMoney(dolarToReal(count, price), "R$");
            break;

          // CONVERSÃO DE REAL E BITCOIN PARA DÓLAR
          case 4:
            count = getPrice("\u001B[37m\nInforme a quantidade de dólar par converter" + "\n=>\033[1;32m $ ");
            price = getPrice("\u001B[37m\nInforme a cotação do dólar para a conversão" + "\n=>\033[1;32m R$ ");
            double priceBitcoin = getPrice(
                "\u001B[37m\nInforme a cotação do bitcoin para a conversão" + "\n=>\033[1;32m R$ ");

            showMoney(dolarToRealAndBitcoin(count, price, priceBitcoin), "R$");
            break;
          default:
            System.out.print("\u001B[37m\n[\033[1;31mERRO\033[1;37m] Opção não definida.\n");
        }
      } catch (Exception error) {
        System.out.print("\u001B[37m\n[\033[1;31mERRO\033[1;37m] Valor informado não é um número inteiro.\n");
        console.next();
      }
    } while (running);

    System.out.print("Encerrando o programa...");
  }

  private static double getPrice(String message) {
    System.out.print(message);
    return console.nextDouble();
  }

  // 04/12/2020 - Real ( R$ 5.16 = $ 1 )
  private static double realToDolar(double real, double priceDolar) {
    return Math.round(real / priceDolar * 100) / 100;
  }

  // 04/12/2020 - Bitcoin = ( 1bitcoin = R$ 0,00001 )
  private static double reaToBitcoin(double real, double priceBitcoin) {
    return Math.round(real / priceBitcoin * 10000000) / 10000000;
  }

  // 04/12/2020 - Dólar = ( $1 = R$ 5,16 )
  private static double dolarToReal(double dolar, double priceDolar) {
    return Math.round(dolar * priceDolar * 100) / 100;
  }

  private static double dolarToRealAndBitcoin(double dolar, double priceDolar, double priceBitcoin) {
    double real = dolarToReal(dolar, priceDolar);
    showMoney(reaToBitcoin(real, priceBitcoin), "BITCOIN");
    return real;
  }

  private static void showMoney(double money, String currency) {
    if (currency.equals("BITCOIN")) {
      System.out.print("\n\033[1;37m[\033[1;32mRESULT\033[1;37m]" + " BITCOIN " + money + "\n");
    } else {
      df.applyPattern(currency + " #,##0.00");
      System.out.print("\n\033[1;37m[\033[1;32mRESULT\033[1;37m]" + " " + df.format(money) + "\n");
    }
  }
}
