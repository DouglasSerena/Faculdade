/*****************************************************************************************************************************************************
 *  1 - Uma pesquisa sobre a pandemia precisa informar o município com mais casos de COVID19 e o município com menos casos.                          *
 * Para apoio a esta pesquisa você deve desenvolver um programa que leia o código do município e o número de casos confirmados da doença.            *
 * A leitura deve ser repetida até que o código de município zero seja informado. Após encerrada a leitura  escreva:                                 *
 *                                                                                                                                                   *
 * o número total de municípios pesquisados;                                                                                                         *
 * o código do município que teve o maior número de casos confirmados, juntamente com o número de casos;                                             *
 * o código do município que teve o menor número de casos confirmados, juntamente com o número de casos.                                             *
 *                                                                                                                                                   *
 * OBS: quando o código zero for informado, o programa deve encerrar imediatamente sem ler o número de casos COVID19.                                *
 *****************************************************************************************************************************************************/

#include <stdio.h>

int main()
{
    int code, codeMax, codeMin, count = 0, max = 0, min = 0, caseCount;

    do
    {
        printf("\nCódigo do municipio (encerra = 0): ");
        scanf("%d", &code);

        if (code == 0)
            break;

        printf("Quantidade de casos ocorrido no municipio: ");
        scanf("%d", &caseCount);
        if (caseCount < 0)
        {
            printf("\nNão é posivel haver casos negativos.\n");
            do
            {
                printf("=> tente novamento com um valor maior: ");
                scanf("%d", &caseCount);
            } while (caseCount < 0);
        }

        count++;

        if (min == 0)
        {
            min = caseCount;
            codeMin = code;
        }

        if (min > caseCount)
        {
            min = caseCount;
            codeMin = code;
        }

        if (max < caseCount)
        {
            max = caseCount;
            codeMax = code;
        }
    } while (code != 0);

    printf("No municipio %d, houve um total de ( %d ) casos, sendo o menor numero de casos ocorridos.\n", codeMin, min);
    printf("No municipio %d, houve um total de ( %d ) casos, sendo o maior numero de casos ocorridos.\n", codeMax, max);
    printf("=> %d municipio participaram", count);

    return 0;
}