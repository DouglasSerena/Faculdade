package Source;

import java.util.Random;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("> Programa sendo inciado...\n");

    Scanner console = new Scanner(System.in);

    int[] notes = new int[5];
    int index = 0;

    while (index < 5) {
      System.out.print("Informe a nota do aluno: ");
      notes[index] = console.nextInt();
      index++;
    }

    new ListStudent(notes);

    console.close();

    System.out.println("\n> Programa encerrado.");
  }
}