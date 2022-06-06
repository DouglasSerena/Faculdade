#include <stdio.h>

int main()
{
    int vetorR[5], vetorS[10], vetorX[15];

    for (int i = 0; i < 5; i++)
    {
        printf("Informe um valor (vetorR): ");
        scanf("%d", &vetorR[i]);
        vetorX[i] = vetorR[i];
    }

    for (int i = 0; i < 10; i++) {
        printf("Informe um valor (vetorS): ");
        scanf("%d", &vetorS[i]);
        vetorX[i+5] = vetorS[i];
    }

    for (int i = 0; i < 15; i++) 
        printf("valorX => %d\n", vetorX[i]);
}
