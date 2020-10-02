package Aula6;

public class PairOdd08 {
    public static void main(String[] args) {
        int[] pair = new int[10];
        int[] orr = new int[10];

        int index = 0;
        while (index < 10) {
            int random = (int) Math.ceil(Math.random() * 20);
            if (random % 2 == 0 && (pair[index] == 0 || orr[index] == 0)) {
                pair[index] = random;
            } else if (orr[index] == 0) {
                orr[index] = random;
            }
            if (pair[index] != 0 && orr[index] != 0)
                index++;
        }
        index = 0;
        while (index < 10) {
            System.out.println(" Par => " + pair[index] + " | Impar => " + orr[index]);
            index++;
        }
    }
}