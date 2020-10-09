#include <stdio.h>
#include <stdbool.h>
 
int main()
{
    float weight = 0, max = 0, min = 0;
 
    do {
        printf("Informe seu peso para entrar no brinquedo: ");
        scanf("%f", &weight);
    
        if(min == 0) min = weight;
    
        if(max < weight) max = weight;
        if(min > weight && weight != 0) min = weight;
    
        if (weight > 80.00) {
            printf(
                "\nPeso acima do limite permitido, "
                "você não pode ingressar neste brinquedo!\n\n"
            );
        }
    }while (weight != 0);
    printf(
        "\n=> Maior peso = %.2f\n"
        "=> Menor peso = %.2f", max, min
    );
}
