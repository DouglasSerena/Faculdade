class Date {
  public static void main(String[] args) {
    System.out.print(getDay("26/03/2001"));
  }

  static int getDay(String date) {
    return deform(date, 0);
  }

  static int getMonth(String date) {
    return deform(date, 1);
  }

  static int getYear(String date) {
    return deform(date, 2);
  }

  static int deform(String date, int type) {
    if (!date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"))
      return 0;
    return Integer.parseInt(date.split("/")[type]);
  }
}