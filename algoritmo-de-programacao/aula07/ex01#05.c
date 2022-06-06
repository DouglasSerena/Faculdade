#include <stdio.h>
#include <stdbool.h>

// exercico 1

int table() 
{
    for(int i = 1;i <= 10;i++) {
        printf("\n<==tabuada do %d==>\n",i);
        for(int v = 1;v <= 10;v++) {
            printf("\n%dX%d=%d\n",i,v,i*v);
        }
    }
}

// exercicio 2

int calcHeight() 
{
    char option[3];
    int count = 0;
    float height, result;
    do {
        printf("Qual sera a altura: ");
        scanf("%f", &height);
        printf("Continuar?\nResposta: ");
        scanf("%s", &option);
        height+=height;
        count++;
    }while(option[0] == 's' || option[0] == 'S');
    result=height/count;
    printf("Media das altura é de %.2fm", result);
}

// exercicio 3

int calcValue()
{
    int count_negative = 0, sum = 0, user_value;
    do {
        printf("Digite um valor Negativo ou positivo: ");
        scanf("%d", &user_value);
        if(user_value < 0) count_negative++;
        else sum+=user_value;
        printf("Para haver a para do codigo informe o valor 0\n");
    }while(user_value != 0);
    printf("\nHouve um total de %d valor negativos | soma dos valores positvos ficou %d", count_negative, sum);
}

// exrcicio 4

int createTable() 
{
    int X[] = {10,3,4,9,1}, R, count=0, result;
    for(int i = 0;i < 5;i++) {
        count++;
        R=X[i]+count;
        result=R%2;
        printf("\n==MEMORIA==\n  X  R  C  \n  %d  %d  %d  \n",X[i],R,count);
        if(result == 0) printf("\nTela: R == %d",R);
        R=0;
    }
}

// exrcicio 5

int average()
{
    char sex[10];
    int code, age, bigger, older_age = 0, count_F = 0, count_M = 0;
    float result;
    do {
        printf("\nInforme o codigo do aluno: ");
        scanf("%d", &code);
        printf("Idade do aluno: ");
        scanf("%d", &age);
        printf("Sexo do aluno: ");
        scanf("%s", &sex);
        if(age > older_age) {
            older_age = age;
            bigger = code;
        }
        if(sex[0] == 'm' || sex[0] == 'M') count_M++;
        else count_F++;
        age+=age;
    }while(code != 0);
    result=age/(count_M+count_F);
    printf("\n=> Aluno Mais velho: Aluno %d possui %d anos", bigger, older_age);
    printf("\n=> Idade Média: %.0f", result);
    printf("\n=> Alunos masculinos: %d", count_M);
    printf("\n=> Alunas femininas: %d", count_F);
}

// init

int main() 
{
    int option;
    do{
        printf("Digite o Número do exrecicio : ");
        scanf("%d", &option);
        switch (option) {
            case 1:
                table();
                break;
            case 2:
                calcHeight();
                break;
            case 3:
                calcValue();
                break;
            case 4:
                createTable();
                break;
            case 5:
                average();
                break;
            default:
                printf("Número do exercico iformado esta invalido\n");
                break;
        }
    }while(option < 1 || option > 5);
}