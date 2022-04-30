#include <stdio.h>

int main()
{
    int vetor[10], vetorW[10], count = 10;

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor: ");
        scanf("%d", &vetor[i]);
        count--;
        vetorW[count] = vetor[i];
    }

    for (int i = 0; i < 10; i++)
        printf("vetor => %d || vetorW => %d\n", vetor[i], vetorW[i]);
}
