#include<stdio.h>

int main()
{
    int i, count[10], search = 0;

    for (i=0;i < 10;i++) {
        printf("Informe um valor : ");
        scanf("%d", &count[i]);
    }

    printf("Valor para buscar no vetor : ");
    scanf("%d", &search);

    for (i=0;i < 10;i++) {
        if ( count[i] == search ) {
            printf("ACHEI");
            return 0;
        } 
    }
    printf("NÃO ACHEI");

    return 0;
}