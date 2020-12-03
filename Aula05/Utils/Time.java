package Utils;

public class Time {
  public int hour;
  public int minute;
  public int second;

  public java.util.Date time = new java.util.Date();
  public Validators validators = new Validators();

  public String getTime() {
    return timeFormat();
  }

  public String setTime(String time) {
    String res = validators.time(time);
    if (res != null) {
      String[] split = res.split(":");
      this.hour = Integer.parseInt(split[0]);
      this.minute = Integer.parseInt(split[1]);
      if (split.length > 2)
        this.second = Integer.parseInt(split[2]);
      return res;
    }
    return res;
  }

  public String now() {
    this.hour = this.time.getHours();
    this.minute = this.time.getMinutes();
    this.second = this.time.getSeconds();
    return timeFormat();
  }

  private String timeFormat() {
    String second = ("" + this.second).length() > 0 ? ":" + this.addZero(this.second) : "";
    return this.addZero(this.hour) + ":" + this.addZero(this.minute) + second;
  }

  private String addZero(int value) {
    return ("" + value).length() == 1 ? "0" + value : "" + value;
  }
}
