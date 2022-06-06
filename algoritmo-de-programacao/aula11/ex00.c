// 1

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

// 2

#include <stdio.h>

int main()
{
    int vetor[10];

    for (int i = 0; i < 10; i++)
    {
        printf("Informe um valor positivo: ");
        scanf("%d", &vetor[i]);
        if(vetor[i]%2 && vetor[i] != 0)
            vetor[i] = 10;
        else 
            vetor[i] = 20;
    }

    for (int i = 0; i < 10; i++)
    {
        printf("valor => %d\n", vetor[i]);
    }
}

// 3

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

// 4

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

// 5

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

// 6

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

// 7

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

// 8

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

// 9

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

// 10

#include <stdio.h>

int main()
{
    int vetorR[5], vetorS[10], vetorX[15];

    for (int i = 0; i < 5; i++)
    {
        printf("Informe um valor (vetorR): ");
        scanf("%d", &vetorR[i]);
        vetorX[i] = vetorR[i];
    }

    for (int i = 0; i < 10; i++) {
        printf("Informe um valor (vetorS): ");
        scanf("%d", &vetorS[i]);
        vetorX[i+5] = vetorS[i];
    }

    for (int i = 0; i < 15; i++) 
        printf("valorX => %d\n", vetorX[i]);
}

// 11

#include <stdio.h>

int main()
{
    int vetor[10], max = 0;

    for (int i = 0; i < 10; i++)
    {
        do {
            printf("Informe um valor: ");
            scanf("%d", &vetor[i]);
        } while (vetor[i] < 0);
    }

    for (int i = 0; i < 10; i++) {
        if (max < vetor[i])
            max = vetor[i];
    }

    printf("Maior valor => %d", max);
}

// 12

#include <stdio.h>

int main()
{
    int vetor[10], result[5] = {5,2,16,21,54}, point = 0;

    for (int i = 0; i < 10; i++)
    {
        do {
            printf("Informe o numero a apostar ( %d ): ", i+1);
            scanf("%d", &vetor[i]);
        } while (vetor[i] < 0);
    }

    for ( int x = 0; x < 5; x++)
        for (int i = 0; i < 10; i++)
            if (result[x] == vetor[i]) {
                result[x] = -1;
                point++;
            }
    
    if (point == 5) {
        printf("Você ganhou!!! teve %d pontos.", point);
        return 0;
    }
    printf("Sua pontuação foi de => %d", point);
}
