package Source;

public class Chronometer {
  private static long startTime;
  private static float total = 0;
  private static long count = 0;

  public static void start() {
    startTime = System.currentTimeMillis();
    System.out.println("\nCronometro iniciado.");
  }

  public static void stop() {
    float seconds = System.currentTimeMillis() - startTime;
    System.out.printf("\nCronometro finalizado: %.3f S\n", (seconds / 1000));
    total = total + seconds;
    count++;
  }

  public static void media() {
    System.out.printf("\nMedia de tempo: %.3f S\n", ((total / count) / 1000));
  }

  public static void clearMedia() {
    total = 0;
    count = 0;
  }
}
