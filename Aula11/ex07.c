#include <stdio.h>

int main()
{
    int vetor[10], valueN, count = 0;

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor: ");
        scanf("%d", &vetor[i]);
        if (i == 9) {
            printf("\n\nIndice a procurar: ");
            scanf("%d", &valueN);
        }
    }

    for (int i = 0; i < 10; i++)
        if (vetor[i] == valueN)
            count++;
    
    printf("\n\nNumeros de indices igual a o valor N %d\n", count);
}
