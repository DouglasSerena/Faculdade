import java.util.Calendar;
import java.util.GregorianCalendar;

import Utils.Validators;

public abstract class People {
    private String CPF;
    private String name; // NOME
    private String birthDay; // DATA DE NASCIMENTO
    private int age; // IDADE
    private double income; // RENDA

    public String getName() {
        return this.name;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public int getAge() {
        return this.age;
    }

    public double getIncome() {
        return this.income;
    }

    People(String CPF, String name, String birthDay, double income) throws Exception {
        if (!Validators.string(name)) {
            throw new Exception("Nome deve haver somente letras.");
        }
        if (!Validators.cpf(CPF)) {
            throw new Exception("Cpf invalid.");
        }
        if (!Validators.date(birthDay)) {
            throw new Exception("Data de aniversario no formato errado (dd/mm/yyyy).");
        }
        if (income < 0) {
            throw new Exception("Uma pessoa não pode ter uma renda menor que R$ 0.00");
        }

        this.CPF = CPF;
        this.name = name;
        this.birthDay = birthDay;
        this.income = income;

        this.calcAge();
    }

    private void calcAge() {
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
