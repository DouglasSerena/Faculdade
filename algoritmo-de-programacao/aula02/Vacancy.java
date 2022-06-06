package Aula6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vacancy {
    public static Scanner console = new Scanner(System.in);
    public static String[] vacancies = new String[10];
    public static int options;
    public static boolean running = true;

    public static void main(String[] args) {
        message(Color.BLUE_BOLD + "\n> Iniciado Programa de controle de estacionamento.\n");
        init();
    }

    public static void init() {
        while (running) {
            try {
                optionUser();
                switch (options) {
                    case 1:
                        add();
                        break;
                    case 2:
                        remove();
                        break;
                    case 3:
                        list();
                        break;
                    case 4:
                        end();
                        break;
                    default:
                        message(Color.ERROR + "\nErro: Opção invalida. Tente novamente.\n");
                }
            } catch (InputMismatchException err) {
                message(Color.ERROR + "\nErro: Informe um valor numérico inteiro. Tente novamente.");
                console.next();
            }
        }
    }

    public static void optionUser() {
        message(Color.CYAN_BOLD + "\nOpções:\n" + Color.WHITE_BOLD + "1 ➡ Adicionar carro\n" + "2 ➡ Liberar vaga\n"
                + "3 ➡ Listar vagas\n" + "4 ➡ Encerrar Programa\n" + Color.YELLOW_BOLD + "opção: ");

        options = console.nextInt();
        message("\n");
    }

    private static void add() {
        message(Color.WHITE_BOLD + "10 ➡ Sair\n");
        message(Color.CYAN_BOLD + "Vagas disponíveis: \n");
        int vacancy = 0;
        for (int i = 0; i < 10; i++) {
            if (vacancies[i] == null) {
                message(Color.WHITE_BOLD + "⎪" + i + "|");
                vacancy++;
            }
        }
        if (vacancy > 0) {
            boolean valid = false;
            while (!valid) {
                try {
                    message(Color.YELLOW_BOLD + "\nEscolha uma vaga: ");
                    int res = console.nextInt();
                    if (res == 10)
                        return;
                    if (res >= 0 && res <= 9) {
                        if (vacancies[res] != null) {
                            message(Color.ERROR + "\nErro: Vaga ja preenchida. Tente novamente.\n");
                        } else {
                            do {
                                message(Color.YELLOW_BOLD + "Placa do carro / moto ( AED3521 ): ");
                                String board = console.next();
                                if (board.length() == 7) {
                                    vacancies[res] = board.toUpperCase();
                                    message(Color.GREEN_BOLD + "\nOK. Vaga " + res + " preenchida com sucesso.\n");
                                    valid = true;
                                } else {
                                    message(Color.ERROR
                                            + "\nErro: Placa informada esta invalida, formato correto ( AGD1523 ). Tente novamente.\n\n");
                                }
                            } while (!valid);
                        }
                    } else {
                        message(Color.ERROR + "\nErro: Valor informado esta fora dos parâmetros. Tente novamente.\n");
                    }
                } catch (InputMismatchException err) {
                    message(Color.ERROR
                            + "\nErro: Valor informado esta fora dos paramento, deve ser um valor numérico inteiro. Tente novamente.\n");
                    console.next();
                }
            }
        } else {
            message(Color.YELLOW + "\nTodas vagas estão ocupada.");
        }
    }

    private static void remove() {
        message(Color.WHITE_BOLD + "10 ➡ Sair\n");
        message(Color.CYAN_BOLD + "Vagas ocupadas: \n");
        int vacancy = 0;
        for (int i = 0; i < 10; i++) {
            if (vacancies[i] != null) {
                message(Color.WHITE_BOLD + "⎪" + i + "|");
                vacancy++;
            }
        }
        if (vacancy > 0) {
            boolean valid = false;
            while (!valid) {
                try {
                    message(Color.YELLOW_BOLD + "\nEscolha uma vaga para liberar: ");
                    int res = console.nextInt();
                    if (res == 10)
                        return;
                    if (res >= 0 && res <= 9) {
                        if (vacancies[res] == null) {
                            message(Color.ERROR + "\nErro: Vaga ja esta livre. Tente novamente.\n");
                        } else {
                            message(Color.GREEN_BOLD + "\nOK. Vaga " + res + " desocupada com sucesso.\n");
                            vacancies[res] = null;
                            valid = true;
                        }
                    } else {
                        message(Color.ERROR + "\nErro: Valor informado esta fora dos parâmetros. Tente novamente.\n");
                    }
                } catch (InputMismatchException err) {
                    message(Color.ERROR
                            + "\nErro: Valor informado esta fora dos paramento, deve ser um valor numérico inteiro. Tente novamente.\n");
                    console.next();
                }
            }
        } else {
            message(Color.YELLOW + "\nNão possui vagas ocupadas.");
        }
    }

    private static void end() {
        message(Color.BLUE_BOLD + "Encerrando programa...\n");
        running = false;
    }

    private static void message(String message) {
        System.out.print(message + Color.RESET);
    }

    private static void list() {
        String[] draw = new String[20];
        for (int i = 0; i < 10; i++) {
            if (vacancies[i] == null) {
                draw[i] = "-------";
                draw[i + 10] = "" + i;
            } else {
                draw[i] = vacancies[i];
                draw[i + 10] = "▓";
            }
        }
        drawVacancy(draw);
    }

    private static void drawVacancy(String[] d) {
        message(Color.BLUE_BOLD + " " + d[0] + " " + d[1] + " " + d[2] + " " + d[3] + " " + d[4] + " " + d[5] + " "
                + d[6] + " " + d[7] + " " + d[8] + " " + d[9] + "\n"
                + "  ╔═══╗   ╔═══╗   ╔═══╗   ╔═══╗   ╔═══╗   ╔═══╗   ╔═══╗   ╔═══╗   ╔═══╗   ╔═══╗\n" + "  ║ " + d[10]
                + " ║   ║ " + d[11] + " ║   ║ " + d[12] + " ║   ║ " + d[13] + " ║   ║ " + d[14] + " ║   ║ " + d[15]
                + " ║   ║ " + d[16] + " ║   ║ " + d[17] + " ║   ║ " + d[18] + " ║   ║ " + d[19] + " ║\n"
                + "  ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║   ║\n");
    }
}

class Color {
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
}
