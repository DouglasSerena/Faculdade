package Aula6;

import java.util.Arrays;
import java.util.Scanner;

public class Note05 {
    public static void main(String[] args) {
        double[] notes = new double[5];
        double max = 0;

        Scanner console = new Scanner(System.in);

        int index = 0;
        while (index < 5) {
            System.out.println("Informe a nota do aulo " + (index + 1) + ":");
            notes[index] = console.nextDouble();
            if (notes[index] < 0 | notes[index] > 10) {
                System.out.println("A nota deve ser entre 0 e 10. Tente novamente.");
            } else {
                max += notes[index];
                index++;
            }
        }
        Arrays.sort(notes);
        while (index > 0) {
            index--;
            System.out.println("Nota: " + notes[index]);
        }
        System.out.println("Media dos alunos: " + (max / 5));
    }
}