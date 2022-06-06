package Aula6;

import java.time.Month;

public class RandomMonth06 {
    public static void main(String[] args) {
        String[] months = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
                "Outubro", "Novembro", "Dezembro" };

        int randomIndex = (int) Math.floor(Math.random() * 12);
        System.out
                .println("Mes com número aleatório => " + months[randomIndex] + " => Índice [ " + randomIndex + " ] ");
    }

}