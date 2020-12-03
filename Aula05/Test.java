import Utils.*;

public class Test {
  public static void main(String[] args) {
    Console console = new Console();

    String res = console.read(Color.WHITE_BOLD + "Informe um data: ");

    Date date = new Date();
    String result = date.setDate(res);
    console.log(result != null ? Color.GREEN_BOLD + "\n" + "Data " + date.getDate() + " valida: " + "\n\n"
        : Color.RED_BOLD + "\n" + "Data " + res + " invalida" + "\n\n");

    res = console.read(Color.WHITE_BOLD + "Informe um tempo (hh:mm:ss): ");

    Time time = new Time();
    result = time.setTime(res);
    console.log(result != null ? Color.GREEN_BOLD + "\n" + "Time " + time.getTime() + " valida: " + "\n\n"
        : Color.RED_BOLD + "\n" + "Time " + res + " invalida" + "\n\n");
  }
}
