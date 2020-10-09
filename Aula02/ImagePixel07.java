package Aula6;

import javax.swing.plaf.ColorUIResource;

public class ImagePixel07 {
    public static void main(String[] args) {
        int[][] Image = new int[40][40];
        for (int r = 0; r < 40; r++) {
            for (int c = 0; c < 40; c++) {
                Image[r][c] = (int) Math.floor(Math.random() * (255 + 1));
                System.out.print(Image[r][c] + " ,");
            }
            System.out.println("");
        }
    }
}
