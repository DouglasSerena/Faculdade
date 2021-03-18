package src;

import java.util.Scanner;

public class App {
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);

        Square square = new Square(console);
        Cycle cycle = new Cycle(console);
        Rectangle rectangle = new Rectangle(console);
        Triangle triangle = new Triangle(console);

        while (running) {
            System.out.println("Escolha uma opção:");
            System.out.println("- 1 Calcular area de um quadrado");
            System.out.println("- 2 Calcular area de um circulo");
            System.out.println("- 3 Calcular area de um retângulo");
            System.out.println("- 4 Calcular area de um triangulo");
            System.out.println("- 0 Fechar programa");
            System.out.print("> ");
            int options = console.nextInt();

            switch (options) {
            case 1:
                square.readProps();
                System.out.println("\nArea do quadrado: " + square.calcArea() + "cm²\n");
                break;
            case 2:
                cycle.readProps();
                System.out.println("\nArea do circulo: " + cycle.calcArea() + "cm²\n");
                break;
            case 3:
                rectangle.readProps();
                System.out.println("\nArea do retângulo: " + rectangle.calcArea() + "cm²\n");
                break;
            case 4:
                triangle.readProps();
                System.out.println("\nArea do triangulo: " + triangle.calcArea() + "cm²\n");
                break;
            default:
                running = false;
            }
        }

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
