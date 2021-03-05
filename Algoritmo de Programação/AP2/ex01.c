#include <stdio.h>
#include <stdbool.h>

int main()
{
    /**
     * count[0] == atendimento 1 quantidade
     * count[1] == atendimento 2 quantidade
     * count[2] == atendimento 3 quantidade
     * count[3] == quantidade total
     */
    int codeClient, count[4] = {0,0,0,0}, optionInt;
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
                count[0]++;
                break;
            case 2:
                sum+=80.00;
                count[1]++;
                break;
            case 3:
                sum+=150.00;
                count[2]++;
                break;
            default:
                printf("\n[ERRO] Atendimento informado inválido\n\n");
                check = false;
                break;
            }
        }while (check == false);

        count[3]++;

        printf("Pretende continuar?\n=> ");
        scanf("%s", &option);

    }while (option[0] == 's' || option[0] == 'S');

    printf(
        "\n\n=> Foi realizado um total de %d atendimento.\n"
        "=> Arrecadou R$ %.2f\n"
        "=> O(s) atendimento(s) que mais ocorreu:", count[3], sum
    );
    
    if(count[0] >= count[1] && count[0] >= count[2]) printf("\n=> Limpeza de pele");
    if(count[1] >= count[0] && count[1] >= count[2]) printf("\n=> Hidratação  capilar");
    if(count[2] >= count[0] && count[2] >= count[1]) printf("\n=> Massagem terapêutica");
}
