#include <stdio.h>
#include <math.h>


int multi(int num1, int num2) {
    int resultado;
    resultado = num1*num2;
    return(resultado);
}
int main(void) {
    int n1, n2, resultado;

    printf("DIGITE UM VALOR: ");
    scanf("%d", &n1);
    printf("DIGITE UM VALOR2: ");
    scanf("%d", &n2);
    resultado = multi(n1,n2);
    printf("\n%d", resultado);
}