package Utils;

import java.util.Scanner;

public class Console {
    public Scanner scanner;
    public Color color;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    // PRINT CONSOLE
    public void log(String message) {
        System.out.print(Color.RESET + message);
    }

    // MESSAGE DEFAULT
    public String read() {
        String res = this.read("Digite uma String");
        return res;
    }

    public int readInt() {
        int res = this.readInt("Digite uma String");
        return res;
    }

    public float readFloat() {
        float res = this.readFloat("Digite uma String");
        return res;
    }

    public double readDouble() {
        double res = this.readDouble("Digite uma String");
        return res;
    }

    public char readChar() {
        char res = this.readChar("Digite uma String");
        return res;
    }

    // MESSAGE PARAMS
    public String read(String message) {
        this.log(message);
        String res = this.scanner.nextLine();
        return res;
    }

    public int readInt(String message) {
        this.log(message);
        int res = this.scanner.nextInt();
        return res;
    }

    public float readFloat(String message) {
        this.log(message);
        float res = this.scanner.nextFloat();
        return res;
    }

    public double readDouble(String message) {
        this.log(message);
        double res = this.scanner.nextDouble();
        return res;
    }

    public char readChar(String message) {
        this.log(message);
        String res = this.scanner.next();
        return res.charAt(0);
    }
}