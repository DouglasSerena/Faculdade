#include<stdio.h>

int main()
{
    float media[5], ap1, ap2;
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
        media[i] = (ap1+ap2)/2;
    }

    for (i=0;i < 5;i++) {
        printf("Media do Aluno %d foi de %.2f pontos\n", i+1, media[i]);
    }

    return 0;
}