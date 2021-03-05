class Month {
  public static void main(String[] args) {
    System.out.println(getMonthByExtension(random(0, 11), 1));
    System.out.println(getMonthByExtension(random(0, 11), 2));
    System.out.println(getMonthByExtension(random(0, 11), 2));
    System.out.println(getMonthByExtension(random(0, 11), 3));
  }

  static int random(int min, int max) {
    return (int) Math.round(Math.random() * (max - min) + min);
  }

  static String getMonthByExtension(int numberMonth, int codeLanguage) {
    String[] monthsPT = { "Janeiro", "Fevereiro", "Março", "April", "Maio", "Junho", "Julho", "Agosto", "Setembro",
        "Outubro", "Novembro", "Dezembro" };
    String[] monthsEN = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December" };
    switch (codeLanguage) {
      case 1:
        return monthsPT[numberMonth];
      case 2:
        return monthsEN[numberMonth];
      default:
        return "Error Idioma não configurado.";
    }
  }
}