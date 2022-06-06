#include<stdio.h>

int main()
{
    int i, count[10], ValueN = 0;

    for (i=0;i < 10;i++) {
        printf("Informe um valor : ");
        scanf("%d", &count[i]);
    }

    printf("Informe Um multiplo : ");
    scanf("%d", &ValueN);

    for (i=0;i < 10;i++) {
        printf("Vetor[%i] com o valor %d multiplicado por %d = %d \n", i, count[i], ValueN, count[i]*ValueN);
    }

    return 0;
}