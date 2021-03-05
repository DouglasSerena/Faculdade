package Aula6;

import java.util.Scanner;

public class Godfather04 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Informe uma palavrar que mostrar se é palíndromo: ");
        String res = console.nextLine();
        String palindrome = "";
        int index = res.length() - 1;
        while (index >= 0) {
            palindrome = palindrome + res.charAt(index);
            index--;
        }
        if (palindrome.equals(res)) {
            System.out.println(res + " é um palíndromo.");
            return;
        }
        System.out.println(res + " não é um palíndromo, a palavra ficou " + palindrome);
    }
}