#include <stdio.h>

int main() {
    int n1;

    printf("Digite o numero do exercicio: ");
    scanf("%i", &n1);
    //exercicio 1 

    if (n1 == 1) {
        for (int i = 0;i < 5;i++) {
            printf("=> PROGRAMAÇÃO!!!\n");
        }
        return 0;
    }

    //exercico 2

    if (n1 == 2) {
        int n1;
        printf("DIGITE UM NUMERO: ");
        scanf("%i", &n1);
        for (int i = 0;i < 10;i++) {
            printf("=> SEU NÚMERO É %i\n", n1);
        }
    }

    //exercicio 3

    if (n1 == 3) {
        for (int i = 100;i <= 110;i++) {
            printf("=> %i\n", i);
        } 
    }

    //exercicio 4

    if (n1 == 4) {
        for (int i = 1;i < 10;i+=2) {
            printf("=> NUMEROS IMPAR %i\n", i);
        }
    }

    //exercicio 5

    if (n1 == 5) {
        int n1;
        printf("DIGITE UM NUMERO: ");
        scanf("%i", &n1);
        for (int i = 1;i <= n1;i++) {
            printf("=> %i° VALOR %i\n", i, n1);
        }
    }
    
    //exercicio 6

    if (n1 == 6) {
        int resultado;
        for (int i = 1;i <= 10;i++) {
            resultado = 8*i;
            printf("TABUADA DO OITO = 8 X %i = %i\n", i, resultado);
        }
    }

    //exercicio 7

    if (n1 == 7) {
        int n1, resultado;
        printf("DIGITE UM NUMERO: ");
        scanf("%i", &n1);
        for (int i = 1;i <= 10;i++) {
            resultado = n1*i;
            printf("=> TABUADA DE %i = %i X %i = %i\n", n1, n1, i, resultado);
        }
    }

    //exercici0 8

    if (n1 == 8) {
        int negativo = 0, n1;
        for (int i = 0;i < 10;i++) {
            printf("DIGITE UM VALOR NEGATIVO OU POSITIVO: ");
            scanf("%i", &n1);
            if (n1 < 0) {
                negativo++;
            }
        }
        printf("=> HOUVE UM TOTAL DE %i NEGATIVOS", negativo);
    }

    //exercicio 9

    if (n1 == 9) {
        int n1, invalido = 0, valido = 0;
        for (int i = 1;i <= 10;i++) {
            printf("DIGITE UM NUMERO: ");
            scanf("%i", &n1);
            if (n1 >= 10 && n1 <= 20) {
                valido++;
            }else {
                invalido++;
            }
        }
        printf("=> VALORES INVALIDO (ABAIXO DE 10 E MAIOR de 20) [ %i ] \n", invalido);
        printf("=> VALORES VALIDO (ENTRE 10 e 20) [ %i ] \n", valido);
    }

    //exercicio 10

    if (n1 == 10) {
        int n1 = 0, resultado;
        do {
            for (int i = 1;i <= 10;i++) {
                resultado = i*n1;
                printf("=> %i X %i = %i\n", n1, i, resultado);
            }
            n1++;
        }while (n1 <= 10);
    }

    //exercicio 11

    if (n1 == 11) {
        int alunoR = 0, alunoA = 0, alunosR[10], alunosA[10];
        float notaFinal, notaAP2, notaAP1, notaAS, notaTotal;
        for (int i = 1;i <= 10;i++) {
            do {
                printf("=> (max 1.5) AP1 ALUNO %i = ", i);
                scanf("%f", &notaAP1);
                if (notaAP1 <= 1.5) {
                    printf("=> (max 2.5) AP2 ALUNO %i = ", i);
                    scanf("%f", &notaAP2);
                    if (notaAP2 <= 2.5) {
                        printf("=> (max 6.0) AS ALUNO %i = ", i);
                        scanf("%f", &notaAS);
                        if (notaAS <= 6) {
                            notaFinal = notaAP1+notaAP2+notaAS;
                            notaTotal += notaFinal;

                            printf("NOTA FINAL DO ALUNO %i FOI %.2f\n", i, notaFinal);
                            if (notaFinal >= 7) {
                                alunoA++;
                                alunosA[alunoA] = i;
                            }else {
                                alunoR++;
                                alunosR[alunoR] = i;
                            }
                            i++;
                        }else {
                            printf("[ERRO] NOTA DA AS INVALIDA TENTE NOVAMNETE\n");
                        }
                    }else {
                        printf("[ERRO] NOTA DA AP2 INVALIDA TENTE NOVAMNETE\n");
                    }
                }else {
                    printf("[ERRO] NOTA DA AP1 INVALIDA TENTE NOVAMNETE\n");
                }
            }while(i <= 10);
        for (int i = 1;i <= alunoR;i++) {
            printf("ALUNO %d REPROVADO\n", alunosR[i]);
        }
        for (int i = 1;i <= alunoA;i++) {
            printf("ALUNO %d APROVADO\n", alunosA[i]);
        }
        printf("=> ALUNOS APROVADOS %i\n", alunoA);
        printf("=> ALUNOS REPROVAODS %i\n", alunoR);
        notaTotal = notaTotal/10.0;
        printf("=> MEDIA DA TURMA %.2f", notaTotal);
        }
    }
}