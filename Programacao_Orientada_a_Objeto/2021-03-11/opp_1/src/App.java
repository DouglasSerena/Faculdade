package src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Triangle triangle = new Triangle(console);

        triangle.readData();
        triangle.showData();

        console.close();

        System.out.println("> Programa encerrado.\n");
    }
}
