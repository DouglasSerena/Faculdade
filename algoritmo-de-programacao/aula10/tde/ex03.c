#include<stdio.h>

int main()
{
    float ap1, ap2, media;
    int c[5];
    int i;

    for (i=0;i < 5;i++) {
        do {
            printf("Informe a nota da AP1 do aluno %d : ", i+1);
            scanf("%f", &ap1);
        }while (ap1 > 10 || ap1 < 0);
        do {
            printf("Informe a nota da AP2 do aluno %d : ", i+1);
            scanf("%f", &ap2);
        }while (ap2 > 10 || ap2 < 0);

        media = (ap1+ap2)/2;

        if (media > 7) {
            c[i] = 1;
        } else {
            c[i] = 2;
        }
    }

    for (i=0;i < 5;i++) {
        if (c[i] == 1) {
            printf("Aluno %d foi APROVADO.\n", i+1);
        } else {
            printf("Aluno %d foi REPROVADO.\n", i+1);
        }
    }

    return 0;
}