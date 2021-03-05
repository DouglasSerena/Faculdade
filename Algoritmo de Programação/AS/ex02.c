/******************************************************************************************************************************************************
 *   2 - No ambiente Aula, nas avaliações realizadas pelo aluno, são exibidas:                                                                        *
 *   a média das notas dos alunos, a maior nota e a menor nota. Faça um programa que leia as notas de uma turma de 30 alunos.                         *
 *   As notas devem ser armazenadas em um vetor de 30 elementos. Calcule e exiba:                                                                     *
 *                                                                                                                                                    *
 *   a média de notas da turma;                                                                                                                       *    
 *   a nota mais alta;                                                                                                                                *
 *   a nota mais baixa;                                                                                                                               *
 *   o número de aprovados(alunos que tiraram nota maior ou igual a 7).                                                                               *
 *                                                                                                                                                    *
 ******************************************************************************************************************************************************/

#include <stdio.h>

int main()
{
    /** 
     * AR[0] = Aprovado
     * AR[1] = Reprovado 
     */
    int x;
    float med, note[30], max = 0, min = 10, AR[2] = {0, 0};
    for (x = 0; x < 30; x++)
    {
        do {
            printf("\nNota do aluno ( %d ): ", x + 1);
            scanf("%f", &note[x]);
        } while (note[x] < 0 || note[x] > 10);

        // regras de negocio
        if (note[x] < min)
            min = note[x];
        if (note[x] > max)
            max = note[x];

        note[x] > 6 ? AR[0]++ : AR[1]++;
        
        med += note[x];
    }

    printf("\nAprovados (%.0f) || Reprovados (%.0f)\n"
           "\n=> %.2f maior nota"
           "\n=> %.2f media das notas da turma"
           "\n=> %.2f menor nota",
           AR[0], AR[1], max, med / 30, min);
}