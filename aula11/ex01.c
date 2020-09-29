#include <stdio.h>

int main()
{
    int vetor[10];

    for (int i = 0; i < 10; i++)
    {
        vetor[i] = 10*(i+1);
    }


    for (int i = 0; i < 10; i++)
    {
        printf("valor => %d\n", vetor[i]);
    }
}
