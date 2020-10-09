package Aula3;

public class Signin07 {
    private static String userName = "java8";
    private static String password = "java8";
    private static boolean logged;
    private static int countAttempts = 0;

    public static void main(String[] args) {
        do {
            if (countAttempts == 3) {
                console.log("Máximo de tentativas atingida.");
                return;
            }
            countAttempts++;
            console.log("(" + countAttempts + ") Digite seu usuário: ");
            String resUserName = console.readString();
            console.log("Digite seu Password: ");
            String resPassword = console.readString();
            logged = isValid(resUserName, resPassword);
        } while (!logged);
        console.log("Parabéns logado com sucesso.");
    }

    private static boolean isValid(String resUserName, String resPassword) {
        if (resUserName.equals(userName))
            if (resPassword.equals(password))
                return true;
        console.log("falha ao logar.");
        return false;
    }
}