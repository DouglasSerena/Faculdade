#include <stdio.h>

int main()
{
    int vetor[10];

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor positivo: ");
        scanf("%d", &vetor[i]);
        if (vetor[i] < 0)
            vetor[i] = 0;
    }

    for (int i = 0; i < 10; i++)
    {
        printf("valor => %d\n", vetor[i]);
    }
}
