import java.util.ArrayList;

public class AccountChain extends Account {

    public AccountChain(ArrayList<Holder> holders) throws Exception {
        super(holders);
    }

    public void withdraw(double value) throws Exception {
        this.withdraw(value, true);
    }

    public void withdraw(double value, boolean register) throws Exception {
        if (value < 10)
            throw new Exception("Valor minimo R$ 10,00.");

        if (value < 0)
            throw new Exception("Valor para adicionar ao saldo deve ser maior que R$ 0,00. \n");

        this.subBalance(value);

        if (register) {
            this.setOperation("Saque", this.formatter.format(value));
        }
    }

    public void deposit(double value) throws Exception {
        this.deposit(value, true);
    }

    public void deposit(double value, boolean register) throws Exception {
        this.addBalance(value);
        if (register) {
            this.setOperation("Depositado", this.formatter.format(value));
        }
    }

    public String balances() {
        StringBuilder string = new StringBuilder();

        string.append(
                "\n [ SALDO ] " + (this.getBalance() == 0.0 ? "R$ 0,00" : this.formatter.format(this.getBalance())));
        string.append("\n [ Limite ] " + this.formatter.format(this.getLimit()) + "\n");

        return string.toString();
    }

    public void transfer(String numberAccount, double value) throws Exception {
        AccountChain account = (AccountChain) Account.searchAccountNumber(numberAccount);

        if (account.equals(this)) {
            throw new Exception("Não tem como transferir dinheiro para você mesmo.");
        }

        this.withdraw(value, false);
        this.setOperation("Transferência", this.formatter.format(value) + " para ( " + account.getHoldersName() + " )");

        account.deposit(value, false);
        account.setOperation("Recebido", this.formatter.format(value) + " de ( " + this.getHoldersName() + " )");
    }

    public String loan() throws Exception {
        double income = 0.0;
        for (Holder holder : holders) {
            if (income < holder.getIncome()) {
                income = holder.getIncome();
            }
        }
        double value = rounder(income * 5);
        this.addBalance(value);

        this.setOperation("Empréstimo", this.formatter.format(rounder(income * 5)));

        return this.formatter.format(rounder(income * 5));
    }

    private double rounder(double value) {
        return Math.floor(value * 100) / 100;
    }

    public String extract() {
        String tmp = this.balances();
        for (String operation : this.operations)
            tmp += "\n  > " + operation;
        return operations.size() == 0 ? tmp + " \n> Não hove operações nessa conta." : tmp + "\n";
    }

}
