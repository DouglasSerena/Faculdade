#include<stdio.h>

int main()
{
    int i, count[20], par = 0;

    for (i=0;i < 20;i++) {
        do {
            printf("Informe um valor : ");
            scanf("%d", &count[i]);
        } while (count[i] < 0);
        
        if ( count[i] % 2 == 0 ) par++;
    }

    printf("Houve um total de %d de N° pares", par);

    return 0;
}