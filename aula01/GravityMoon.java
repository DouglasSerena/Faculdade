package Aula3;

import java.util.Scanner;

/**
 * GravityMoon
 */
public class GravityMoon {
    private static int gravityMoon = 17; // percent

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu Peso: ");
        float weight_user = scanner.nextFloat(); // usar ,

        float weight = calc(weight_user);

        System.out.println(String.format("Seu peso na lua => %.2f KG", weight));
        scanner.close();
    }

    private static float calc(float weight) {
        float weight_moon = weight * gravityMoon / 100;
        return weight_moon;
    }
}