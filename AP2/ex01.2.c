#include <stdio.h>
#include <stdbool.h>

int main()
{
    int codeClient, Atend1 = 0, Atend2 = 0, Atend3 = 0, total = 0, optionInt;
    float sum = 0;
    char option[3];
    bool check;

    do {
        printf("Qual é o codigo do cliente: ");
        scanf("%d", &codeClient);

        do {
            check = true;

            printf(
                "Qual atendimento o cliente Ira fazer: \n"
                "=> 1 - Limpeza de pele\n"
                "=> 2 - Hidratação  capilar\n"
                "=> 3 - Massagem terapêutica\n"
                "=> Resposta: "
            );
            scanf("%d", &optionInt);

            switch (optionInt) {
            case 1:
                sum+=10.00;
                Atend1++;
                break;
            case 2:
                sum+=80.00;
                Atend2++;
                break;
            case 3:
                sum+=150.00;
                Atend3++;
                break;
            default:
                printf("\n[ERRO] Atendimento informado inválido\n\n");
                check = false;
                break;
            }
        }while (check == false);

        total++;

        printf("Pretende continuar?\n=> ");
        scanf("%s", &option);

    }while (option[0] == 's' || option[0] == 'S');
    
    printf(
        "\n\n=> Foi realizado um total de %d atendimento.\n"
        "=> Arrecadou R$ %.2f\n"
        "=> O(s) atendimento(s) que mais ocorreu:", total, sum
    );
    
    if(Atend1 >= Atend2 && Atend1 >= Atend3) printf("\n=> Limpeza de pele");
    if(Atend2 >= Atend1 && Atend2 >= Atend3) printf("\n=> Hidratação  capilar");
    if(Atend3 >= Atend1 && Atend3 >= Atend2) printf("\n=> Massagem terapêutica");
}