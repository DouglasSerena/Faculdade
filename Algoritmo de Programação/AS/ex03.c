/******************************************************************************************************************************************************
 *   3 - Escreva um programa para fazer a leitura de um número indeterminado de valores.                                                              *
 *   Todos os valores pares devem ser armazenados em um vetor de 20 posições.                                                                         *
 *   O programa deve ser encerrado quando o vetor estiver totalmente preenchido.                                                                      *
 ******************************************************************************************************************************************************/

#include <stdio.h>

int main()
{
    int value[20], x = 0;
    do
    {
        do {
            printf("digite um valor se seja par ( %d ): ", x + 1);
            scanf("%d", &value[x]);
        } while(value[x] % 2 == 1);
        x++;
    } while (x != 20);
    
    for (x = 0; x < 20; x++)
        printf("=> value[%d] = %d\n", x, value[x]);
}