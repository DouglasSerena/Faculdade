public class Time {
  private int _hour = -1;
  private int _minutes = -1;
  private int _second = -1;

  public String getTime() {
    return this._hour + ":" + (this._minutes < 10 ? ("0" + this._minutes) : this._minutes) + ":"
        + (this._second < 10 ? ("0" + this._second) : this._second);
  }

  public int getHour() {
    return _hour;
  }

  public int getMinutes() {
    return _minutes;
  }

  public int getSecond() {
    return _second;
  }

  public String setHour(int hour) {
    if (hour >= 0 && hour <= 23) {
      this._hour = hour;
      return null;
    }
    return "Hora deve ser maior ou igual a 0 e menor ou igual a 23";
  }

  public String setMinutes(int minutes) {
    if (minutes >= 0 && minutes < 60) {
      this._minutes = minutes;
      return null;
    }
    return "Minuto deve ser maior ou igual a 0 e menor ou igual a 60";
  }

  public String setSecond(int second) {
    if (second >= 0 && second < 60) {
      this._second = second;
      return null;
    }
    return "Segundos deve ser maior ou igual a 0 e menor ou igual a 60";
  }
}
