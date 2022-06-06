/*****************************************************************************************************************************************************
 *  2. Faça um programa que faz a leitura de uma matriz de 4 linhas e 4 colunas e um número X.                                                       *
 *  Após a leitura conte quantas vezes o número X aparece na matriz.                                                                                 *
 *****************************************************************************************************************************************************/

#include <stdio.h>

int main()
{
    int matrix[4][4], search, count = 0;


    for (int r = 0; r < 3; r++)
        for (int c = 0; c < 4; c++) {
            printf("Informe valores para a matrix[%d][%d]: ",r,c);
            scanf("%d", &matrix[r][c]);
        }

    printf("Informe um numer ode pesquisa: ");
    scanf("%d", &search);
    
    for (int r = 0; r < 3; r++)
        for (int c = 0; c < 4; c++)
            if (search == matrix[r][c])
                printf("\nValor encontrado na posição [%d][%d]:contagem %d", r, c, ++count);
        
    if (count == 0)
        printf("O valor não foi encontrado na matrix.");
}