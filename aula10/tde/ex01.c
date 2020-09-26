#include<stdio.h>

int main()
{
    float notas[10];
    int i;

    for (i=0;i < 10;i++) {
        do {
            printf("Informe a nota do aluno %d : ", i+1);
            scanf("%f", &notas[i]);
        }while (notas[i] < 0 || notas[i] > 10);
    }

    for (i=0;i < 10;i++) {
        printf("Nota do Aluno %d foi de %.2f pontos\n", i+1, notas[i]);
    }

    return 0;
}