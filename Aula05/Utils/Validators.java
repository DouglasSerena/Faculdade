package Utils;

public class Validators {
  // VALID INTEGER
  public String typeInteger(String value) {
    return value.matches("^[0-9]*") ? value : null;
  }

  // VALID PHONE
  public String phone(String phone) {
    String pattern = "^[0-9]{2,3}(-[0-9]{8,9}| [0-9]{4,5}-[0-9]{4}| 9 [0-9]{4}-[0-9]{4})$";
    return pattern(phone, pattern);
  }

  // VALID EMAIL
  public String email(String email) {
    String pattern = "^[a-zA-Z]{1,}[a-zA-Z.+-]{0,}@[a-zA-Z]{2,}([.][a-zA-Z]{2,}|[.][a-zA-Z]{2,}[.][a-zA-Z]{2,})$";
    return pattern(email, pattern);
  }

  // VALID TIME
  public String time(String time) {
    String pattern = "^([0-1]{0,1}[0-9]|2[0-3]):([0-5]{0,1}[0-9])(:[0-5]{0,1}[0-9])?$";
    String formateValid = pattern(time, pattern);

    System.out.println(formateValid != null ? "true" : "false");

    if (formateValid == null)
      return null;
    return time;
  }

  // VALID DATA
  public String date(String date) {
    String pattern = "^(0[1-9]|3[0-1]|[1-9]|[1-2][0-9])/(0[1-9]|1[0-2]|[1-9])/[0-9]{4}$";
    String formateValid = pattern(date, pattern);

    if (formateValid == null)
      return null;

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
  public Boolean containsArrayInt(int value, int[] array) {
    for (int arrayValue : array)
      if (value == arrayValue)
        return true;
    return false;
  }

  // VALID WITH PATTERN
  public String pattern(String value, String pattern) {
    if (value.matches(pattern))
      return value;
    return null;
  }
}
