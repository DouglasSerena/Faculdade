package Aula3;

import java.util.Scanner;

/**
 * console
 */
public class console {
    private static Scanner scanner = new Scanner(System.in);

    public static void log(final String content) {
        System.out.println(content);
    }

    public static String readString() {
        return scanner.next();
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    public static float readFloat() {
        return scanner.nextFloat();
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
    }
}
