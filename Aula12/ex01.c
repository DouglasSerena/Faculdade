/*****************************************************************************************************************************************************
 *  1. Faça um programa que faz a leitura de uma matriz de 3 linhas e 4 colunas.                                                                     *
 *  Na matriz devem ser armazenados números inteiros. Após a leitura da matriz, leia um número inteiro e multiplique cada número da matriz por ele.  *
 *  Escreva a matriz resultante na tela.                                                                                                             *
 *****************************************************************************************************************************************************/

#include <stdio.h>

int main()
{
    int matrix[3][4], mult, value;

    for (int r = 0; r < 3; r++)
        for (int c = 0; c < 4; c++) {
            printf("valor linha ( %d ) : col ( %d ) : matrix[%d][%d]: ", r+1, c+1, r, c);
            scanf("%d", &matrix[r][c]);
        }

    do {
        printf("Escolha um valor para servir de multiplicador da matrix: ");
        scanf("%d", &mult);
    } while(mult < 1);

    for (int r = 0; r < 3; r++)
        for (int c = 0; c < 4; c++) {
            value = matrix[r][c] * mult;
            printf("\n[%d][%d] : %d mult %d = %d: ", r, c, matrix[r][c], mult, value);
        }

    return 0;
}