/*****************************************************************************************************************************************************
 *  3. Escreva um programa para preencher automaticamente uma matriz de 3 linhas e 5 colunas com                                                     *
 *  números pares diferentes começando pelo número 2. Escreva a matriz preenchida.                                                                   *
 *****************************************************************************************************************************************************/

#include <stdio.h>

int main()
{
    int matrix[3][5], par = 0;

    for (int r = 0; r < 3; r++)
        for (int c = 0; c < 5; c++) {
            matrix[r][c] = par + 2;
            par += 2;
        }

    for (int r = 0; r < 3; r++)
        for (int c = 0; c < 5; c++)
            printf("\nmatrix[%d][%d] : valor = %d", r, c, matrix[r][c]);
}