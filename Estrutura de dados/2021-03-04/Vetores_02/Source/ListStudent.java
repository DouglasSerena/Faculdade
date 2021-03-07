package Source;

class ListStudent {
  private int note = 0;
  private double media = 0;

  public ListStudent(int... notes) {
    int index = 0;

    notes = this.desc(notes); // PODE SER USADO O Arrays.sort(notes);

    for (int note : notes) {
      System.out.println("Nota: " + note);
      this.note += note;
      index++;
    }
    this.media = this.note / index;

    System.out.println("\nTotal das notas: " + this.note);
    System.out.println("Media das notas: " + this.media);
  }

  private int[] desc(int... values) {
    int count = values.length;

    for (int rows = 0; rows < count; rows++)
      for (int cols = rows + 1; cols < count; cols++)
        if (values[rows] < values[cols]) {
          int temp = values[rows];
          values[rows] = values[cols];
          values[cols] = temp;
        }

    return values;
  }
}