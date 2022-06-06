#include <stdio.h>

int main()
{
    int age, check = 1;
    float height;
    char option;

    do {
        do {
            printf("Qual é sua altura: ");
            scanf("%f", &height);
        }while (height < 1.60 || height > 1.90);

        printf("\nQual é sua idade: ");
        scanf("%d", &age);

        if(age < 8)
            printf("idade está fora da competiçã");
        else if(age < 10)
            printf("categoria: infantil");
        else if(age < 13)
            printf("categoria: Juvenil A");
        else if(age < 17)
            printf("categoria: Juvenil B");
        else 
            printf("categoria: adulto");

        printf("\nContinuar ( sim || não ): ");
        scanf("%s", &option);

    }while (option == 'S' || option == 's');
}