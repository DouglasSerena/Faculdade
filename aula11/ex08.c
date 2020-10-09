#include <stdio.h>

int main()
{
    int vetor[10], valueN, error = 0;

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor: ");
        scanf("%d", &vetor[i]);
        if (i == 9) {
            printf("\nIndice a procurar: ");
            scanf("%d", &valueN);
        }
    }

    for (int i = 0; i < 10; i++)
        if (vetor[i] == valueN) {
            error++;
            printf("índices que o vetor é igual a N => vetor[%d]\n", i, i);
        }

    if (error == 0) 
        printf("Nem um valor foi localizado.");
}
