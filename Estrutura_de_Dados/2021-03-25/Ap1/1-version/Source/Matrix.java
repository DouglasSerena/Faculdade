package Source;

public class Matrix {
  int width;
  int height;
  byte[][] ref;

  public Matrix(int width, int height) {
    this.width = width;
    this.height = height;
    this.ref = new byte[width][height];
  }

  public void fill(int value) {
    for (int row = 0; row < this.height; row++) {
      for (int col = 0; col < this.width; col++) {
        this.ref[row][col] = (byte) value;
      }
    }
  }

  public void fillAuto() {
    System.out.println("> Preenchendo matrix...");
    for (int row = 0; row < this.height; row++) {
      for (int col = 0; col < this.width; col++) {
        this.ref[row][col] = (byte) Math.round(Math.random());
      }
    }
  }

  public void setDefault() {
    this.ref[98][0] = 1;
    this.ref[98][1] = 1;
    this.ref[99][0] = 1;
    this.ref[99][1] = 0;

    this.ref[98][98] = 1;
    this.ref[98][99] = 1;
    this.ref[99][98] = 1;
    this.ref[99][99] = 0;
  }

  public String searchDefaultAll(byte[][] matrixDefault) {
    int size = matrixDefault.length;
    int countDefault = 0;

    Chronometer.start();
    for (int rows = 0; rows < this.height; rows++) {
      for (int cols = 0; cols < this.width; cols++) {
        if (ref[rows][cols] == matrixDefault[0][0]) {
          if (findMatrixDefault(matrixDefault, size, rows, cols) == "FOUND") {
            countDefault++;
          }
        }
        if (cols == this.width - size)
          break;
      }
      if (rows == this.width - size)
        break;
    }

    Chronometer.stop();
    return "Houve um total de " + countDefault;
  }

  public String searchDefaultFirst(byte[][] matrixDefault) {
    int size = matrixDefault.length;

    Chronometer.start();
    for (int rows = 0; rows < this.height; rows++) {
      for (int cols = 0; cols < this.width; cols++) {
        if (ref[rows][cols] == matrixDefault[0][0]) {
          if (findMatrixDefault(matrixDefault, size, rows, cols) == "FOUND") {
            Chronometer.stop();
            return "Padrão localizado";
          }
        }
        if (cols == this.width - size)
          break;
      }
      if (rows == this.width - size)
        break;
    }

    Chronometer.stop();
    return "Padrão não localizado";
  }

  public String findMatrixDefault(byte[][] matrixDefault, int size, int rows, int cols) {
    for (int index_1 = 0; index_1 < size; index_1++)
      for (int index_2 = 0; index_2 < size; index_2++)
        if (ref[rows + index_1][cols + index_2] != matrixDefault[index_1][index_2])
          return null;

    return "FOUND";
  }
}
