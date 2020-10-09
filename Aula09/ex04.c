#include <stdio.h>

int main()
{
    int notaFinal, nota1, nota2, nota3, matricula;

    do {
        printf("\nMatricula do aluno: ");
        scanf("%d", &matricula);

        if(matricula == 9999) return 0;

        do {
            printf("\nNota 1\n=>");
            scanf("%d", &nota1);
        }while (nota1 < 0 || nota1 > 10);

        do {
            printf("\nNota 2\n=>");
            scanf("%d", &nota2);
        }while (nota2 < 0 || nota2 > 10);

        do {
            printf("\nNota 3\n=>");
            scanf("%d", &nota3);
        }while (nota3 < 0 || nota3 > 10);

        notaFinal = ((2 * nota1) +(3 * nota2) + (4 * nota3))/ 9;

        printf("\nAluno com a matricula %d"
            " ficou com a media de %d assim sendo ",
            matricula,
            notaFinal
        );
        if(notaFinal < 5) printf("REPROVADO :(\n");
        else printf("APROVADO!!!\n");

    }while (matricula < 9999);
}