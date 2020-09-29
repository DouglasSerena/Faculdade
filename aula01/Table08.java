package Aula3;

public class Table08 {
    public static void main(String[] args) {
        console.log("Informe um numero para fazer a tabuada: ");
        int multNumber = console.readInt();
        console.clear();
        for (int i = 1; i <= 10; i++) {
            console.log(multNumber + " X " + i + " = " + (multNumber * i));
        }
    }
}