#include <stdio.h>

int main()
{
    int vetor[10], vetorY[10];

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor: ");
        scanf("%d", &vetor[i]);
        if (i%2 && i != 0)
            vetorY[i] = vetor[i] * 3;
        else
            vetorY[i] = vetor[i] * 2;
    }

    for (int i = 0; i < 10; i++)
        printf("vetor => %d\n", vetorY[i]);
}
