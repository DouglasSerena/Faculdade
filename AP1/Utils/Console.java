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
        return this.read("Digite uma String");
    }

    public int readInt() {
        return this.readInt("Digite uma String");
    }

    public float readFloat() {
        return this.readFloat("Digite uma String");
    }

    public double readDouble() {
        return this.readDouble("Digite uma String");
    }

    public char readChar() {
        return this.readChar("Digite uma String");
    }

    // MESSAGE PARAMS
    public String read(String message) {
        this.log(message);
        return this.scanner.nextLine();
    }

    public int readInt(String message) {
        this.log(message);
        return this.scanner.nextInt();
    }

    public float readFloat(String message) {
        this.log(message);
        return this.scanner.nextFloat();
    }

    public double readDouble(String message) {
        this.log(message);
        return this.scanner.nextDouble();
    }

    public char readChar(String message) {
        this.log(message);
        return (this.scanner.nextLine()).charAt(0);
    }
}