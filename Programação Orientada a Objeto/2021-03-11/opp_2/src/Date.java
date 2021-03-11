package src;

import java.util.ArrayList;
import java.util.List;

class Date {
  private int _day = -1;
  private int _month = -1;
  private int _year = -1;
  private List<Integer> _month_31 = new ArrayList<Integer>();
  private List<Integer> _month_30 = new ArrayList<Integer>();

  Date() {
    int[] month_31 = new int[] { 1, 3, 5, 7, 8, 10, 12 };
    for (int month : month_31) {
      this._month_31.add(month);
    }

    int[] month_30 = new int[] { 4, 6, 9, 11 };
    for (int month : month_30) {
      this._month_30.add(month);
    }
  }

  public String getDate() {
    return (this._day < 10 ? ("0" + this._day) : this._day) + "/"
        + (this._month < 10 ? ("0" + this._month) : this._month) + "/"
        + (this._year < 10 ? ("0" + this._year) : this._year);
  }

  public int getDay() {
    return this._day;
  }

  public int getMonth() {
    return this._month;
  }

  public int getYear() {
    return this._year;
  }

  public String setDay(int day) {
    if (day > 0 && day <= 31) {
      if (this._month == 0) {
        this._day = day;
        return null;
      }
      if (this._month == 2) {
        if (this._year % 4 == 0 && this._year % 100 != 0) {
          if (day <= 29) {
            this._day = day;
            return null;
          }
        } else {
          if (day <= 28) {
            this._day = day;
            return null;
          }
        }
      } else {
        if (this._month_30.indexOf(this._month) != -1) {
          if (day <= 30) {
            this._day = day;
            return null;
          }
        }
        if (this._month_31.indexOf(this._month) != -1) {
          if (day <= 31) {
            this._day = day;
            return null;
          }
        }
      }
      return "O dia informado esta com o valor invalido.";
    } else {
      return "O dia deve ser " + (day < 1 ? "maior que 0" : "menor que ou igual a (31|30|29|28)");
    }
  }

  public String setMonth(int month) {
    if (month > 0 && month <= 12) {
      this._month = month;
      return null;
    }
    return "O mes deve ser " + (month < 1 ? "maior que 0" : "menor que ou igual a 12");
  }

  public String setYear(int year) {
    this._year = year;
    return null;
  }
}