package Source;

public class Matrix {
  int width;
  byte[][] ref;

  public Matrix(int width) {
    this.width = width;
    this.ref = new byte[width][width];
  }

  public void fill(int value) {
    for (int row = 0; row < this.width; row++) {
      for (int col = 0; col < this.width; col++) {
        this.ref[row][col] = (byte) value;
      }
    }
  }

  public void fillAuto() {
    System.out.println("\n> Preenchendo matrix...");
    for (int row = 0; row < this.width; row++) {
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

  public String searchDefaultAll(byte[][] m) {
    byte s = (byte) m.length;
    int d = 0;
    int w = this.width;
    int ws = w - s;

    Chronometer.start();
    for (int r = 0; r < w; r++) {
      for (int c = 0; c < w; c++) {
        if (ref[r][c] == m[0][0])
          if (find(m, s, r, c) == 1) d++;
        if(ref[r][c+1] == m[0][0]) c++;
        if (c == ws) break;
      }
      if (r == ws) break;
    }

    Chronometer.stop();
    return "Houve um total de " + d;
  }

  public String searchDefaultFirst(byte[][] m) {
    byte s = (byte) m.length;
    int w = this.width;
    int ws = w - s;

    Chronometer.start();
    for (int r = 0; r < w; r++) {
      for (int c = 0; c < w; c++) {
        if (ref[r][c] == m[0][0]) {
          if (find(m, s, r, c) == 1) {
            Chronometer.stop();
            return "Padrão localizado";
          }
        }
        if(ref[r][c+1] == m[0][0]) c++;
        if (c == ws) break;
      }
      if (r == ws) break;
    }

    Chronometer.stop();
    return "Padrão não localizado";
  }

  public byte find(byte[][] m, byte s, int r, int c) {
    for (byte i = 0; i < s; i++)
      for (byte j = 0; j < s; j++)
        if (ref[r + i][c + j] != m[i][j])
          return 0;

    return 1;
  }
}
