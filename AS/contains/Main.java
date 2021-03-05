package contains;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    System.out.print("\033[1;37mInforme uma frase: ");
    String phrase = console.nextLine();

    String word = "";
    do {
      System.out.print("Informe um palavra de 5 caracteres: ");
      word = console.nextLine();
      if (word.length() > 5)
        System.out
            .print("\n[\033[1;31mERRO\033[1;37m] A palavra deve possuir menos de 5 caracteres. Tente novamente\n\n");
    } while (word.length() > 5);

    System.out.print(phrase.contains(word)
        ? "A palavra '\033[1;33m" + word + "\033[1;37m' possui na frase '\033[1;33m" + phrase + "\033[1;37m'"
        : "A palavra '\033[1;33m" + word + "\033[1;37m' não possui na frase '\033[1;33m" + phrase + "\033[1;37m'");
  }
}