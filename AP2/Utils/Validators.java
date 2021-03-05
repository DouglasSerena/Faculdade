package Utils;

public class Validators {
  // VALID CPF
  public static boolean cpf(String value) {
    String[] cpfsInvalidos = { 
      "00000000000", 
      "11111111111", 
      "22222222222", 
      "33333333333", 
      "44444444444", 
      "55555555555",
      "66666666666", 
      "77777777777", 
      "88888888888", 
      "99999999999" 
    };

    String cpf = value.replaceAll("[.-]*", "");
    if ((cpf == null) || (cpf.length() != 11))
      return false;

    for (String cpfInvalido : cpfsInvalidos)
      if (cpfInvalido.equals(cpf))
        return false;

    Integer digitOne = calcDigit(cpf.substring(0, 9));
    Integer digitTwo = calcDigit(cpf.substring(0, 9) + digitOne);
    return cpf.equals(cpf.substring(0, 9) + digitOne.toString() + digitTwo.toString());
  }

  private static int calcDigit(String str) {
    int[] peso = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
    int sum = 0;
    for (int index = str.length() - 1, digit; index >= 0; index--) {
      digit = Integer.parseInt(str.substring(index, index + 1));
      sum += digit * peso[peso.length - str.length() + index];
    }
    sum = 11 - sum % 11;
    return sum > 9 ? 0 : sum;
  }

  // VALID STRING
  public static boolean string(String value) {
    return value.matches("^[a-zA-Z ]*");
  }

  // VALID INTEGER
  public static boolean integer(String value) {
    return value.matches("^[0-9]*");
  }

  // VALID PHONE
  public static boolean phone(String phone) {
    String pattern = "^[0-9]{2,3}(-[0-9]{8,9}| [0-9]{4,5}-[0-9]{4}| 9 [0-9]{4}-[0-9]{4})$";
    return pattern(phone, pattern);
  }

  // VALID EMAIL
  public static boolean email(String email) {
    String pattern = "^[a-zA-Z]{1,}[a-zA-Z.+-]{0,}@[a-zA-Z]{2,}([.][a-zA-Z]{2,}|[.][a-zA-Z]{2,}[.][a-zA-Z]{2,})$";
    return pattern(email, pattern);
  }

  // VALID TIME
  public static boolean time(String time) {
    String pattern = "^([0-1]{0,1}[0-9]|2[0-3]):([0-5]{0,1}[0-9])(:[0-5]{0,1}[0-9])?$";
    return pattern(time, pattern);
  }

  // VALID DATA
  public static boolean date(String date) {
    String pattern = "^(0[1-9]|3[0-1]|[1-9]|[1-2][0-9])/(0[1-9]|1[0-2]|[1-9])/[0-9]{4}$";
    boolean formateValid = pattern(date, pattern);

    if (!formateValid)
      return formateValid;

    String[] dateSlit = date.split("/");

    int day = Integer.parseInt(dateSlit[0]);
    int month = Integer.parseInt(dateSlit[1]);
    int year = Integer.parseInt(dateSlit[2]);

    int[] month_day_31 = { 1, 3, 5, 7, 8, 10, 12 };
    int[] month_day_30 = { 4, 6, 9, 11 };

    if (containsArrayInt(month, month_day_31))
      return day <= 31;

    if (containsArrayInt(month, month_day_30))
      return day <= 30;

    if (month == 2)
      if (year % 4 == 0)
        return day <= 29;
      else
        return day <= 28;
    return true;
  }

  // EXISTING VALUER IN ARRAY OF INT
  public static Boolean containsArrayInt(int value, int[] array) {
    for (int arrayValue : array)
      if (value == arrayValue)
        return true;
    return false;
  }

  // VALID WITH PATTERN
  public static Boolean pattern(String value, String pattern) {
    return value.matches(pattern);
  }
}
