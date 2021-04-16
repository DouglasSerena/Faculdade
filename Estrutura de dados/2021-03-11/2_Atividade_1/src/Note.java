package src;

import java.util.Scanner;

class Note {
  private int _note_g1[][] = new int[4][4];
  private int _note_total_g1;
  private int _note_g2[][] = new int[4][4];
  private int _note_total_g2;
  private Scanner _console;

  Note(Scanner console) {
    this._console = console;
  }

  public void read() {
    int index = 0;
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        index++;
        do {
          System.out.print("Informe a nota g1 do aluno '" + index + "': ");
          this._note_g1[row][col] = this._console.nextInt();
        } while (this._note_g1[row][col] < 0 || this._note_g1[row][col] > 10);

        this._note_total_g1 += this._note_g1[row][col];

        do {
          System.out.print("Informe a nota g2 do aluno '" + index + "': ");
          this._note_g2[row][col] = this._console.nextInt();
        } while (this._note_g2[row][col] < 0 || this._note_g2[row][col] > 10);

        this._note_total_g2 += this._note_g2[row][col];
      }
    }
  }

  public void showStatusStudents() {
    int index = 0;
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        index++;
        if (this._note_g1[row][col] >= 7)
          System.out.println("> Aluno '" + index + "' aprovado na g1.");
        else
          System.out.println("> Aluno '" + index + "' reprovado na g1.");

        if (this._note_g2[row][col] >= 7)
          System.out.println("> Aluno '" + index + "' aprovado na g2.");
        else
          System.out.println("> Aluno '" + index + "' reprovado na g2.");

        System.out.println();
      }
    }
  }

  public double calcMediaG1() {
    return this._note_total_g1 / (4 * 4);
  }

  public double calcMediaG2() {
    return this._note_total_g2 / (4 * 4);
  }
}