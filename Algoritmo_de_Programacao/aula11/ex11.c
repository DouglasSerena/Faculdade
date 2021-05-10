#include <stdio.h>

int main()
{
    int vetor[10], max = 0, position;

    for (int i = 0; i < 10; i++)
    {
        do
        {
            printf("Informe um valor: ");
            scanf("%d", &vetor[i]);
        } while (vetor[i] <= 0);
    }

    for (int i = 0; i < 10; i++)
    {
        if (max < vetor[i])
        {
            max = vetor[i];
            position = i;
        }
    }

    printf("Maior valor => %d posição [%d]", max, position);
}
