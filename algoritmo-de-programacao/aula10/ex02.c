#include<stdio.h>

int main()
{
    int i, count[15], values = 0;

    for (i=0;i < 15;i++) {
        printf("Informe um valor : ");
        scanf("%d", &count[i]);
        if ( count[i] == 10 ) {
            values++;
        } 
    }

    printf("\nHouve um total de %d vezes o N° 10", values);

    return 0;
}
