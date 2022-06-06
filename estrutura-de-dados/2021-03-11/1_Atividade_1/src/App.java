package src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Room.student = 3;
        Room room = new Room(console);

        room.readNote();
        room.showNoteMoreMedia();

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
