#include <stdio.h>

int main() {
    int n1;

    printf("Numero do exercicio : ");
    scanf("%i", &n1);

    //exercicio 1

    if (n1 == 1) {
        int peso;
        float altura;
        printf("Qual é seu peso : ");
        scanf("%i", &peso);
        printf("Qual é sua altura : ");
        scanf("%f", &altura);
        if (peso >= 70 && peso <= 80) {
            if (altura < 1.75 || altura >1.9) {
                printf("RECUSADO POR ALTURA!");
            }else if (altura >= 1.75 && altura <= 19) {
                printf("ACEITO!");
            } 
        }else if (altura >= 1.75 && altura <= 1.9) {
            if (peso < 70 || peso > 80) {
                printf("RECUSADO POR PESO!");
            }else if (peso >= 70 && peso <= 80) {
                printf("ACEITO!");
            } 
        }else if (peso < 70 || peso > 80) {
            if (altura < 1.75 || altura < 1.9) {
                printf("TOTALMENTE RECUSADO!");
            }
        }
    }

    //exercico 2


    if (n1 == 2) {
        int peso;
        float altura;
        printf("Qual é seu peso : ");
        scanf("%i", &peso);
        printf("Qual é sua altura : ");
        scanf("%f", &altura);
        if ((peso >= 70 && peso <= 80) && (altura >= 1.75 && altura <= 1.9)) {
            printf("ACEITO!");
        }else if ((peso < 70 || peso > 80) && (altura >= 1.75 && altura <= 1.9)) {
            printf("RECUSADO POR PESO!");
        }else if ((peso >= 70 && peso <= 80) && (altura < 1.75 || altura > 1.9)) {
            printf("RECUSADO POR ALTURA!");
        }else if ((peso < 70 || peso > 80) && (altura < 1.75 || altura > 1.9)) {
            printf("TOTALMENTE RECUSADO!");
        }
    }
}