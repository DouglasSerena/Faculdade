import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("> Programa sendo inciado...\n");

        Scanner console = new Scanner(System.in);
        Note note = new Note(console);

        note.read();
        note.showStatusStudents();

        System.out.println();

        System.out.println("Media dos alunos na g1 " + note.calcMediaG1());
        System.out.println("Media dos alunos na g2 " + note.calcMediaG2());

        console.close();

        System.out.println("\n> Programa encerrado.");
    }
}
