import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Time time = new Time();

        String response = null;
        do {
            System.out.print("Informe as horas: ");
            response = time.setHour(console.nextInt());
            if (response != null)
                System.out.println("[Erro] " + response);
        } while (response != null);

        do {
            System.out.print("Informe os minutos: ");
            response = time.setMinutes(console.nextInt());
            if (response != null)
                System.out.println("[Erro] " + response);
        } while (response != null);

        do {
            System.out.print("Informe os segundos: ");
            response = time.setSecond(console.nextInt());
            if (response != null)
                System.out.println("[Erro] " + response);
        } while (response != null);

        System.out.println("Data final: " + time.getTime());

        console.close();

        System.out.println("> Programa encerrado.\n");
    }
}
