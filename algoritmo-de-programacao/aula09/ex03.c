#include <stdio.h>

int main()
{
    float max = 0, med = 0, min = 0;
    int valor, count = 0;
    char option;

    do {
        printf("\nQuantas vezes você usou o restaurante?\n=> ");
        scanf("%d", &valor);

        if(valor < 10) min++;
        else if (valor <= 15) med++;
        else max++;

        count++;

        printf("\n    deseja continuar?\n    => ");
        scanf("%s", &option);

    }while (option == 's' || option == 'S');

    if (min > 0) min = min*100/count;
    if (med > 0) med = med*100/count;
    if (max > 0) max = max*100/count;

    printf("\n\nAlunos que usaram menos de 10 vezes - %.0f%%", min);
    printf("\nAlunos que usaram entre 10 e 15 vezes - %.0f%%", med);
    printf("\nAlunos que usaram mais de 15 vezes - %.0f%%", max);
}
