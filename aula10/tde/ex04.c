#include<stdio.h>

int main()
{
    int i, conta[10], soma = 0;

    for (i=0;i < 10;i++) {
        printf("Informe um valor : ");
        scanf("%d", &conta[i]);
        // soma += conta[i] == soma = soma + conta[i]
        soma = soma + conta[i];
    }

    printf("Soma dos valores %d", soma);

    return 0;
}