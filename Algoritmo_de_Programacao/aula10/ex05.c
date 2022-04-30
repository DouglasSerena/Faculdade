#include<stdio.h>

int main()
{
    int i;
    float salario[10], bonos = 0.1;

    for (i=0;i < 10;i++) {
        printf("Informe o salario do funcionario %d : ", i+1);
        scanf("%f", &salario[i]);
    }

    for (i=0;i < 10;i++) {
        printf("O salario anterior do funcionario %d era R$ %.2f\n", i+1, salario[i]);
        salario[i] += (salario[i]*bonos);
        printf("Novo salario com um bonos de 10%%  R$ %.2f\n\n", salario[i]);
    }

    return 0;
}