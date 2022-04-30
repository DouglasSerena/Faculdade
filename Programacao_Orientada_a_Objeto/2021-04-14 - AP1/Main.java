import java.util.ArrayList;

import Source.*;
import Source.Utils.*;

public class Main {
    static Console console = new Console();
    static boolean running = true;
    static AccountChain accountSelect;

    public static void main(String[] args) {
        console.log("> Programa sendo inciado...\n\n");

        try {
            createAccountChain();
            console.log("\n[SUCESSO] Criado conta.");
        } catch (Exception error) {
            console.log("\n[ERRO] " + error.getMessage());
        }

        int option = 0;
        double value = 0.0;
        do {
            console.log("\nTitula: " + accountSelect.getHoldersName());
            console.log("\nEscolha uma opção:\n");
            console.log("\t> 1 - Sacar\n");
            console.log("\t> 2 - Depositar\n");
            console.log("\t> 3 - Transferir\n");
            console.log("\t> 4 - Empréstimo\n");
            console.log("\t> 5 - Extrato\n");
            console.log("\t> 6 - Saldo\n");
            console.log("\t> 7 - Criar um Nova conta\n");
            console.log("\t> 8 - Trocar conta\n");
            console.log("\t> 0 - Fechar\n");
            option = console.readInt("> ");

            switch (option) {
            case 1:
                try {
                    value = console.readDouble("Informe o valor para sacar: ");
                    accountSelect.withdraw(value);
                    console.log("\n[SUCESSO] Saque feito com sucesso.");
                } catch (Exception error) {
                    console.log("[ERRO] " + error.getMessage());
                }
                break;

            case 2:
                try {
                    value = console.readDouble("Informe o valor para depositar: ");
                    accountSelect.deposit(value);
                    console.log("\n[SUCESSO] Deposito feito com sucesso.");
                } catch (Exception error) {
                    console.log("\n[ERRO] " + error.getMessage());
                }
                break;

            case 3:
                try {
                    value = console.readDouble("Informe o valor para transferir: ");

                    listAccounts();

                    console.read("");
                    String numberAccount = console.read("Informe o numero da conta: ");

                    accountSelect.transfer(numberAccount, value);
                    console.log("\n[SUCESSO] Transferência feito com sucesso.");
                } catch (Exception error) {
                    console.log("\n[ERRO] " + error.getMessage());
                }
                break;

            case 4:
                try {
                    String loan = accountSelect.loan();
                    console.log("\n[SUCESSO] Empréstimo feito com sucesso. Sendo adicionado " + loan);
                } catch (Exception error) {
                    console.log("[ERRO] " + error.getMessage());
                }
                break;

            case 5:
                console.log(accountSelect.extract());
                break;

            case 6:
                console.log(accountSelect.balances());
                break;

            case 7:
                try {
                    console.read("");
                    createAccountChain();
                    console.log("\n[SUCESSO] Criado conta.");
                } catch (Exception error) {
                    console.log("\n[ERRO] " + error.getMessage());
                }
                break;

            case 8:
                try {
                    changeAccount();
                    console.log("\n[SUCESSO] Trocado de conta");
                } catch (Exception error) {
                    console.log("\n[ERRO] " + error.getMessage());
                }
                break;

            case 0:
                running = false;
            }
        } while (running);

        console.scanner.close();

        console.log("> Programa encerrado.\n");
    }

    private static void changeAccount() throws Exception {
        if (Account.accounts.size() <= 1) {
            console.read("");
            createAccountChain();
        }
        listAccounts();

        console.read("\n");
        String numberAccount = console.read("Informe o numero da conta: ");

        AccountChain account = (AccountChain) Account.searchAccountNumber(numberAccount);

        if (account.equals(accountSelect)) {
            throw new Exception("Não tem como trocar de conta para a mesma conta selecionada.");
        }

        accountSelect = account;

        console.log("\n");
    }

    private static void listAccounts() {
        console.log("\n");
        for (Account account : Account.accounts) {
            console.log((account.equals(accountSelect) ? "[Atual] " : "") + account.toString());
        }

    }

    private static AccountChain createAccountChain() throws Exception {
        console.log("> Criando conta...\n");

        ArrayList<Holder> holders = new ArrayList<>();

        holders.add(createHolder());

        if (console.readInt("Criar conta conjunta (1 - Sim ou 0 - Não): ") == 1) {
            console.read("");
            holders.add(createHolder());
        }

        AccountChain account = new AccountChain(holders);
        Account.accounts.add(account);

        accountSelect = account;

        return account;
    }

    private static Holder createHolder() throws Exception {
        console.log("> Criando titular...\n");

        boolean invalid = false;

        String name;
        String cpf;
        String birthDay;
        double income;

        do {
            name = console.read("Informe o nome: ");
            invalid = !Validators.string(name);
            if (invalid) {
                console.log("Nome deve haver somente letras.\n");
            }
        } while (invalid);
        do {
            cpf = console.read("Informe o cpf: ");
            invalid = !Validators.cpf(cpf);
            if (invalid) {
                console.log("Cpf invalid.\n");
            }
        } while (invalid);
        do {
            birthDay = console.read("Informe a data: ");
            invalid = !Validators.date(birthDay);
            if (invalid) {
                console.log("Data de aniversario no formato errado (dd/mm/yyyy).\n");
            }
        } while (invalid);
        do {
            income = console.readDouble("Informe a renda: R$ ");
            invalid = income < 0;
            if (invalid) {
                console.log("Uma pessoa não pode ter uma renda menor que R$ 0.00\n");
            }
        } while (invalid);

        return new Holder(cpf, name, birthDay, income);
    }
}