import Utils.*;

class Main {
  public static void main(String[] args) {
    Console console = new Console();

    // STARTING
    console.log(Color.PURPLE_BOLD + "\n> Programa start...");
    boolean running = true;

    while (running) {
      // GET OPTION
      char option = console.readChar(
        Color.WHITE_BOLD + "\n\n> Options: \n" +
        Color.CYAN_BOLD +
          " - 0 end program\n" +
          " - 1 valid date\n" +
          " - 2 valid email \n" +
          " - 3 valid phone \n" +
          " - 4 valid integer \n" +
          " - 5 format date \n" +
        Color.WHITE_BOLD + "Response: "
      );

      switch (option) {
        // FINISH
        case '0':
          console.log(Color.PURPLE_BOLD + "\n> Program ending...\n\n");
          return;
      
        // VALID DATE
        case '1':
          String date = console.read(Color.WHITE_BOLD + "\nEnter a date: ");
          Boolean dateValid = validDate(date) == null ? false : true;

          // RESPONSE USER
          console.log(
            dateValid
              ? Color.GREEN_BOLD + "> Date " + date + " Valid."
              : Color.RED_BOLD + "> Date " + date + " Invalid."
          );

          break;

        // VALID EMAIL
        case '2':
          String email = console.read(Color.WHITE_BOLD + "\nEnter a email: ");
          Boolean emailValid = validEmail(email) == null ? false : true;

          // RESPONSE USER
          console.log(
            emailValid
              ? Color.GREEN_BOLD + "> Email " + email + " Valid."
              : Color.RED_BOLD + "> Email " + email + " Invalid."
          );

          break;

        // VALID PHONE
        case '3':
          String phone = console.read(Color.WHITE_BOLD + "\nEnter a phone: ");
          Boolean phoneValid = validPhone(phone) == null ? false : true;

          // RESPONSE USER
          console.log(
            phoneValid
              ? Color.GREEN_BOLD + "> Phone " + phone + " Valid."
              : Color.RED_BOLD + "> Phone " + phone + " Invalid."
          );

          break;

        // VALID INTEGER
        case '4':
          String integer = console.read(Color.WHITE_BOLD + "\nEnter a integer: ");
          Boolean integerValid = validTypeInteger(integer) == null ? false : true;

          // RESPONSE USER
          console.log(
            integerValid
              ? Color.GREEN_BOLD + "> Integer " + integer + " Valid."
              : Color.RED_BOLD + "> Integer " + integer + " Invalid."
          );

          break;

        // FORMAT DATE
        case '5':
          String dateF = console.read(Color.WHITE_BOLD + "\nEnter a date: ");
          String res = formatDate(dateF);

          Boolean dateFValid = res == null ? false : true;

          // RESPONSE USER
          console.log(
            dateFValid
              ? Color.GREEN_BOLD + "> date " + dateF + " formatted " + res
              : Color.RED_BOLD + "> date " + dateF + " Invalid."
          );

          break;

        // ERROR
        default:
          console.log(
            Color.RED_BOLD + "\n> There was an error please try again."
          );
      }
    }
  }

  // FORMAT DATA
  public static String formatDate(String date) {
    if (validDate(date) == null) return null;

    String[] dateSplit = date.split("/");
    return dateSplit[1] + '/' + dateSplit[0] + '/' + dateSplit[2];
  }

  // VALID INTEGER
  public static String validTypeInteger(String value) {
    return value.matches("^[0-9]*") ? value : null;
  }

  // VALID PHONE
  public static String validPhone(String phone) {
    String[] pattern = { "^[0-9]{2,3}(-[0-9]{8,9}| [0-9]{4,5}-[0-9]{4}| 9 [0-9]{4}-[0-9]{4})$" };
    return pattern(phone, pattern);
  }

  // VALID EMAIL
  public static String validEmail(String email) {
    String[] pattern = { "^[a-zA-Z]{1,}[a-zA-Z.+-]{0,}@[a-zA-Z]{2,}([.][a-zA-Z]{2,}|[.][a-zA-Z]{2,}[.][a-zA-Z]{2,})$" };
    return pattern(email, pattern);
  }

  // VALID DATA
  private static String validDate(String date) {
    String[] pattern = { "^(0[1-9]|3[0-1]|[1-9]|[1-2][0-9])/(0[1-9]|1[0-2]|[1-9])/[0-9]{4}$" };
    String formateValid = pattern(date, pattern);

    if (formateValid == null) return null;

    String[] dateSlit = date.split("/");

    int day = Integer.parseInt(dateSlit[0]);
    int month = Integer.parseInt(dateSlit[1]);
    int year = Integer.parseInt(dateSlit[2]);

    int[] month_day_31 = { 1, 3, 5, 7, 8, 10, 12 };
    int[] month_day_30 = { 4, 6, 9, 11 };

    if (containsArrayInt(month, month_day_31))
      return day <= 31 ? date : null;

    if (containsArrayInt(month, month_day_30))
      return day <= 30 ? date : null;

    if (month == 2)
      if (year % 4 == 0)
        return day <= 29 ? date : null;
      else
        return day <= 28 ? date : null;
    return null;
  }

  // EXISTING VALUER IN ARRAY OF INT
  private static Boolean containsArrayInt(int value, int[] array) {
    for (int arrayValue : array)
      if (value == arrayValue)
        return true;
    return false;
  }

  // VALID WITH PATTERN
  private static String pattern(String value, String[] patterns) {
    for (String pattern : patterns)
      if (value.matches(pattern))
        return value;
    return null;
  }
}