package src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Date date = new Date();

        String response = null;
        do {
            System.out.print("Informe o ano: ");
            response = date.setYear(console.nextInt());
            if (response != null)
                System.out.println("[Erro] " + response);
        } while (response != null);

        do {
            System.out.print("Informe o mes: ");
            response = date.setMonth(console.nextInt());
            if (response != null)
                System.out.println("[Erro] " + response);
        } while (response != null);

        do {
            System.out.print("Informe o dia: ");
            response = date.setDay(console.nextInt());
            if (response != null)
                System.out.println("[Erro] " + response);
        } while (response != null);

        System.out.println("Data final: " + date.getDate());

        console.close();

        System.out.println("> Programa encerrado.\n");
    }
}
