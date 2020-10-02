package AP1.Utils;

import java.util.Scanner;

public class Console {
    private Scanner scanner;
    
    Console(Scanner scanner) {
        this.scanner = scanner;
    }

    // PRINT CONSOLE
    public void log() {
        System.out.print("Digite um inteiro");
    }
    
    public void log(String message) {
        System.out.print(message);
    }

    // MESSAGE DEFAULT
    public String read() {
        this.log();
        return this.scanner.read();
    }
    public int readInt() {
        this.log();
        return this.scanner.readInt();
    }
    public float readFloat() {
         this.log();
        return this.scanner.readFloat();
    }
    public char readChar() {
         this.log();
        return this.scanner.readChar();
    }

    // MESSAGE PARAMS
    public String read(String message) {
        this.log(message);
        return this.scanner.read();
    }
    public int readInt(String message) {
        this.log(message);
        return this.scanner.readInt();
    }
    public float readFloat(String message) {
         this.log(message);
        return this.scanner.readFloat();
    }
    public char readChar(String message) {
         this.log(message);
        return this.scanner.readChar();
    }
}