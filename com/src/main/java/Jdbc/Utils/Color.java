package Jdbc.Utils;

public class Color {
  public static String RESET = "\u001B[0m";
  public static String BLACK = "\u001B[30m", BLACK_BOLD = "\033[1;30m", BLACK_BACKGROUND = "\033[40m",
      BLACK_UNDERLINE = "\033[4;30m";
  public static String RED = "\033[0;31m", RED_BOLD = "\033[1;31m", RED_BACKGROUND = "\033[41m",
      RED_UNDERLINE = "\033[4;31m";
  public static String GREEN = "\u001B[32m", GREEN_BOLD = "\033[1;32m", GREEN_BACKGROUND = "\033[42m",
      GREEN_UNDERLINE = "\033[4;32m";
  public static String YELLOW = "\u001B[33m", YELLOW_BOLD = "\033[1;33m", YELLOW_BACKGROUND = "\033[43m",
      YELLOW_UNDERLINE = "\033[4;33m";
  public static String BLUE = "\u001B[34m", BLUE_BOLD = "\033[1;34m", BLUE_BACKGROUND = "\033[44m",
      BLUE_UNDERLINE = "\033[4;34m";
  public static String PURPLE = "\u001B[35m", PURPLE_BOLD = "\033[1;35m", PURPLE_BACKGROUND = "\033[45m",
      PURPLE_UNDERLINE = "\033[4;35m";
  public static String CYAN = "\u001B[36m", CYAN_BOLD = "\033[1;36m", CYAN_BACKGROUND = "\033[46m",
      CYAN_UNDERLINE = "\033[4;36m";
  public static String WHITE = "\u001B[37m", WHITE_BOLD = "\033[1;37m", WHITE_BACKGROUND = "\033[47m",
      WHITE_UNDERLINE = "\033[4;37m";
  public static String ERROR = RED_BOLD + RED_UNDERLINE;

  public static String tag(String name, String color) {
    return Color.WHITE_BOLD + "[" + color + name + Color.WHITE_BOLD + "]";
  }

  public static String tag(String name) {
    return Color.WHITE_BOLD + "[" + CYAN_BOLD + name + Color.WHITE_BOLD + "]";
  }
}
