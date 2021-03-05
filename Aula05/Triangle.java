import Utils.*;

class Triangle {
  public static void main(String[] args) {
    Console console = new Console();
    int height = console.readInt(Color.WHITE_BOLD + "Informe a altura de um triangulo: ");
    int base = console.readInt(Color.WHITE_BOLD + "Informe a base de um triangulo: ");

    double area = calcArea(height, base);
    console.log(Color.GREEN_BOLD + "Altura: " + height + "\nBase: " + base + "\nArea: " + area);
  }

  public static double calcArea(int height, int base) {
    return base * height / 2;
  }
}