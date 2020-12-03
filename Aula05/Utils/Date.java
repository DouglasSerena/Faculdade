package Utils;

public class Date {
  public Validators validators;

  public int day;
  public int month;
  public int year;

  public Date() {
    this.validators = new Validators();
  }

  public String getDate() {
    return this.day + "/" + this.month + "/" + this.year;
  }

  public String getDateUSA() {
    return this.month + "/" + this.day + "/" + this.year;
  }

  public String setDate(String date) {
    String res = this.validators.date(date);
    if (res != null) {
      String[] split = res.split("/");
      this.day = Integer.parseInt(split[0]);
      this.month = Integer.parseInt(split[1]);
      this.year = Integer.parseInt(split[2]);
      return res;
    }
    return res;
  }
}
