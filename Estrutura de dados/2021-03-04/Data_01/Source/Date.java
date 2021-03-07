package Source;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
  public static String[] getWeek() {
    String[] week = new String[7];
    Calendar calendar = new GregorianCalendar();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    for (int index = 0; index < 7; index++) {
      String tmp = getDay(day);
      day--;
      if (tmp == null) {
        day = 6;
        tmp = getDay(7);
      }
      week[index] = tmp;
    }
    return week;
  }

  public static String getDay(int day) {
    switch (day) {
    case Calendar.SUNDAY:
      return "Domingo";
    case Calendar.MONDAY:
      return "Segunda-feira";
    case Calendar.TUESDAY:
      return "Terça-feira";
    case Calendar.WEDNESDAY:
      return "Quarta-feira";
    case Calendar.THURSDAY:
      return "Quinta-feira";
    case Calendar.FRIDAY:
      return "Sexta-feira";
    case Calendar.SATURDAY:
      return "Sábado";
    default:
      return null;
    }
  }
}
