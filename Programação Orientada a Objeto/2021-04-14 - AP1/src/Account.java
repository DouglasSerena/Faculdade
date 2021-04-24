import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account {
    static ArrayList<String> CPFSRegister = new ArrayList<>();
    static ArrayList<String> numbersAccount = new ArrayList<>();
    static ArrayList<AccountChain> accounts = new ArrayList<>();
    protected DecimalFormat formatter = new DecimalFormat("R$ ###,###,###.00");
    protected ArrayList<String> operations = new ArrayList<String>();

    private int agency = 1; // AGENCIA
    private String number; // NUMERO
    private double balance = 0.0; // SALDO
    private double limit = 0.0; // LIMITE
    ArrayList<Holder> holders = new ArrayList<>(); // TITULAR

    public double getBalance() {
        return this.balance;
    }

    public double getLimit() {
        return this.limit;
    }

    protected void addBalance(double value) throws Exception {
        if (value < 0)
            throw new Exception("O valor deve ser maior que R$ 0,00 \n");

        this.balance = this.balance + value;
    }

    protected void subBalance(double value) throws Exception {
        double valueLimit = this.limit + this.balance;

        if (value > valueLimit)
            throw new Exception("O saldo não pode ficar menor do que o limite da conta \n");

        this.balance = this.balance - value;
    }

    public Account(ArrayList<Holder> holders) throws Exception {
        int legacyAge = 0;

        if (existHolder(holders)) {
            throw new Exception("Titulares algum deles esta com o cpf iguais.");
        }

        for (Holder holder : holders) {

            if (this.existHolder(holder.getCPF())) {
                throw new Exception("Cliente " + holder.getName() + " ja cadastrado.");
            }

            if (holder.getAge() < 16) {
                throw new Exception("Para abrir um conta dever ter mais que 16 anos.");
            }

            this.holders.add(holder);

            Account.CPFSRegister.add(holder.getCPF());

            if (holder.getAge() > legacyAge) {
                legacyAge = holder.getAge();
            }
        }

        this.number = Math.round(Math.random() * 99999) + "";

        if (existAccount(this.number)) {
            throw new Exception("Ocorreu um erro inesperado.");
        }

        Account.numbersAccount.add(this.number);

        if (legacyAge > 60)
            this.limit = 1000;
        else if (legacyAge < 18)
            this.limit = 100;
        else
            this.limit = 300;

        for (Holder holder : this.holders) {
            holder.account = this;
        }
    }

    private boolean existHolder(String cpf) {
        for (String cpfRegister : CPFSRegister) {
            if (cpfRegister == cpf) {
                return true;
            }
        }
        return false;
    }

    private boolean existHolder(ArrayList<Holder> holders) {
        for (int index = 0; index < holders.size() - 1; index++) {

            if (holders.get(index).getCPF() == holders.get(index + 1).getCPF()) {
                return true;
            }
        }
        return false;
    }

    private boolean existAccount(String number) {
        for (String numberAccount : numbersAccount) {
            if (numberAccount == number) {
                return true;
            }
        }
        return false;
    }

    public void setOperation(String operation, String content) {
        this.operations.add(operation + " " + content + ": [ " + timeNow() + " ]");
    }

    public String timeNow() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getHoldersName() {
        if (holders.size() == 1) {
            return holders.get(0).getName();
        }
        return holders.get(0).getName() + " e " + holders.get(1).getName();
    }

    public static Account searchAccountNumber(String number) throws Exception {
        for (Account account : Account.accounts) {
            if (account.number.equals(number)) {
                return account;
            }
        }
        throw new Exception("Não foi possível encontrar a conta com esse number.");
    }

    @Override
    public String toString() {
        StringBuilder stringBuild = new StringBuilder();

        stringBuild.append("Agencia: " + this.agency);
        stringBuild.append(" - Número: " + this.number);
        stringBuild.append(" - Titular(s): " + this.getHoldersName());
        stringBuild.append("\n");

        return stringBuild.toString();
    }
}
