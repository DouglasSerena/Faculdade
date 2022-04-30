package Source;

public class Holder extends People {
    Account account;

    Account getAccount() {
        return this.account;
    }

    public Holder(String CPF, String name, String birthDay, double income) throws Exception {
        super(CPF, name, birthDay, income);
    }
}