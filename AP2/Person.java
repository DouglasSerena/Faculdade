import java.util.Calendar;
import java.util.GregorianCalendar;

import Utils.*;

class Person {
  private String name;
  private String cpf;
  private String birthDay;
  private int age;

  public String getName() {
    return name;
  }

  public String getCpf() {
    return cpf;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public int getAge() {
    return age;
  }

  Person(String name, String cpf, String birthDay) throws Exception {
    boolean nameValid = Validators.string(name);
    boolean cpfValid = Validators.cpf(cpf);
    boolean birthDayValid = Validators.date(birthDay);
    if (!nameValid)
      throw new Exception("Nome deve haver somente letras.");
    if (!cpfValid)
      throw new Exception("Cpf invalid.");
    if (!birthDayValid)
      throw new Exception("Data de aniversario no formato errado (dd/mm/yyyy).");
    this.cpf = cpf;
    this.birthDay = birthDay;
    this.name = name;
    this.calcAge();
  }

  private void calcAge() throws Exception {
    Calendar cal = GregorianCalendar.getInstance();
    int yearCurrent = cal.get(Calendar.YEAR);
    int monthCurrent = cal.get(Calendar.MONTH) + 1;
    int dayCurrent = cal.get(Calendar.DAY_OF_MONTH);

    String[] date = this.birthDay.split("/");

    int age = yearCurrent - Integer.parseInt(date[2]);

    int monthPerson = Integer.parseInt(date[1]);
    if (monthCurrent > monthPerson)
      age = age - 1;
    else if (monthCurrent == monthPerson)
      if (dayCurrent > Integer.parseInt(date[0]))
        age = age - 1;
    this.age = age;
  };
}