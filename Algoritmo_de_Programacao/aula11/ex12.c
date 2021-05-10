#include <stdio.h>

int main()
{
    int vetor[10], result[5], point = 0, valid = 0;

    for (int i = 0; i < 5; i++)
    {
        do
        {
            printf("primeiro numero da loto ( %d ): ", i + 1);
            scanf("%d", &result[i]);
        } while (result[i] < 0);
    }

    for (int i = 0; i < 10; i++)
    {
        do
        {
            printf("Informe o numero a apostar ( %d ): ", i + 1);
            scanf("%d", &vetor[i]);
            valid = 0;
            for (int x = 0; x < i; x++)
                if (vetor[x] == vetor[i])
                {
                    printf("Numero duplicado\n");
                    valid = 1;
                    break;
                }
        } while (vetor[i] < 0 || valid);

        for (int x = 0; x < 5; x++)
            if (result[x] == vetor[i])
                point++;
    }

    if (point == 5)
    {
        printf("Você ganhou!!! teve %d pontos.", point);
        return 0;
    }
    printf("Sua pontuação foi de => %d", point);
}
