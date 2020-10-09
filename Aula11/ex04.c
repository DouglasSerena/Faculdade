#include <stdio.h>

int main()
{
    int vetor[10], vetorE[10];

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor: ");
        scanf("%d", &vetor[i]);
        vetorE[i] = vetor[i];
    }

    for (int i = 0; i < 10; i++)
        printf("vetor => %d\n", vetor[i]);
    for (int i = 0; i < 10; i++)
        printf("valorE => %d\n", vetorE[i]);
}
