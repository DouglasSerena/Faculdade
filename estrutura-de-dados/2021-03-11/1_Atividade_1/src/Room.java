package src;

import java.util.Scanner;

public class Room {
  public static int student = 5;
  private String[] _student;
  private double[] _note;
  private double _noteTotal = 0.0;
  private Scanner _console;

  Room(Scanner console) {
    this._console = console;
  }

  public void readNote() {
    this._student = new String[student];
    this._note = new double[student];

    for (int index = 0; index < student; index++) {
      System.out.print("Nome do aluno: ");
      this._student[index] = this._console.next();

      System.out.print("Nota do aluno: ");
      this._note[index] = this._console.nextDouble();

      this._noteTotal += this._note[index];
    }
  }

  public void showNoteMoreMedia() {
    double media = this.calcMedia();
    for (int index = 0; index < student; index++) {
      if (this._note[index] > media) {
        System.out.println("O aluno " + this._student[index] + " teve a nota maior que a media de " + media);
      }
    }
  }

  public double calcMedia() {
    return this._noteTotal / student;
  }
}
