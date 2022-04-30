package Aula3;

import java.util.Scanner;

public class SoundFlash {
    private static int sound_speed_distance = 1100; // feet per seconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informa o tempo que o som demorou para chegar a você: ");
        float seconds = scanner.nextFloat(); // use ,

        float distance_flash = calc(seconds);

        System.out
                .println(String.format("A distância do relâmpago em relação a você foi de %.2f pés.", distance_flash));
        scanner.close();
    }

    private static float calc(float seconds) {
        float distance_flash = sound_speed_distance * seconds;
        return distance_flash;
    }
}
