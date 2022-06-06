#include <stdio.h>

int main()
{
    int vetor[10], vetorR[10], error = 0;

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor: ");
        scanf("%d", &vetor[i]);
        if (vetor[i] < 0)
            vetorR[i] = vetor[i];
        else
            vetorR[i] = 0;
    }

    for (int i = 0; i < 10; i++) {
        if (vetorR[i]) {
            error++;
            printf("valor => %d => indice vetor[%d]\n", vetorR[i], i);
        }
    }

    if (error == 0) 
        printf("Nem um valor foi localizado no vetorR.");
}
