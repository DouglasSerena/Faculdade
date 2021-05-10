package src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);

        System.out.print("Informe a quantidade de alunos: ");
        Room.student = console.nextInt();

        Room room = new Room(console);

        room.readNote();
        room.showNoteMoreMedia();

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
