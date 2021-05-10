/*===================================================================================================*/
/*===========================execute o codigo inteiro e escolha o numero=============================*/
/*==========================do exercicio para executar ele seguindo a msg============================*/
/*===================================================================================================*/

#include <stdio.h>

int main() {
    int n1;
    printf("QUAL É O NUMERO DO EXERCICIO : ");
    scanf("%i" , &n1);

    //exercicio 1

    if (n1 == 1) {
        int n1, n2;
        float res;
        char opera;

        printf("DIGITE UM VALOR : ");
        scanf("%i", &n1);
        printf("DIGITE UM VALOR : ");
        scanf("%i", &n2);
        printf("ESCOLHA UMA OPERAÇÃO \n=> (somar = s)\n=> (subtração = b)\n=> (divisão = d)\n=> (multiplicação = m)\n=> ");
        scanf("%s", &opera);
        getchar();

        if (opera == 's' || opera == 'S') {
            res = n1+n2;
            printf("=> RESULTADO DA SOMA %i + %i = %.2f", n1, n2, res);
        }else if (opera == 'm' || opera == 'M') {
            res = n1*n2;
            printf("=> RESULTADO DA MULTIPLICAÇÃO %i * %i = %.2f", n1, n2, res);
        }else if (opera == 'd' || opera == 'D') {
            res = (float)n1/n2;
            printf("=> RESULTADO DA DIVISÃO %i / %i = %.2f", n1, n2, res);
        }else {
            res = n1-n2;
            printf("=> RESULTADO DA SUBTRAÇÃO %i - %i = %.2f", n1, n2, res);
        }
    }
    
    //exercicio 

    if (n1 == 2) {
        int n1;

        printf("DIGITE UM NÚMERO : ");
        scanf("%i", &n1);

        switch (n1) {
        case 1:
            printf("=> O RESULTADO FOI %i", n1);
            break;
        case 2:
            n1 *= 2;
            printf("=> O RESULTADO FOI %i", n1);
            break;
        case 3:
            n1 *= 3;
            printf("=> O RESULTADO FOI %i", n1);
            break;
        default:
            printf("=> NÚMERO NÃO ESPERADO");
            break;
        }
    }

    //exercico 3

    if (n1 == 3) {
        int a, b, c, res;
        char  codigo;
        do {
            printf("DIGITE UM CODIGO : ");
            scanf("%i", &codigo);
            printf("DIGITE UM VALOR : ");
            scanf("%i", &a);
            printf("DIGITE UM VALOR : ");
            scanf("%i", &b);
            printf("DIGITE UM VALOR : ");
            scanf("%i", &c);

            switch (codigo) {
                case 1:
                    res = a*b*c;
                    printf("=> RESULTADO : %i * %i * %i = %i", a, b, c, res);
                    break;
                case 2:
                    res = a+b+c;
                    printf("=> RESULTADO : %i + %i + %i = %i", a, b, c, res);
                    break;
                case 3:
                    res = a-b-c;
                    printf("=> RESULTADO : %i - %i - %i = %i", a, b, c, res);
                    break;
                case 4:
                    res = a*a+b*b+c*c;
                    printf("=> RESULTADO : %i² + %i² + %i² = %i", a, b, c, res);
                    break;
                case 5:
                    printf("=> RESULTADO :\n=> VALOR 1 = %i\n=> VALOR 2 = %i\n=> VALOR 3 = %i", a, b, c, res);
                    break;
                default:
                    printf("=> [ERRO] CÓDIGO INVÁLIDO TENTE NOVAMENTE\n");
            }
        }while (codigo > 5 || codigo < 1);
    }

    //exercicio 4

    if (n1 == 4) {
        int codigo;
        float preco;

        printf("QUAL O VALOR DO PRODUTO : ");
        scanf("%f", &preco);
        printf("CÓDIGO DE ORIGIN DO PRODUTO : ");
        scanf("%i", &codigo);

        switch(codigo) {
            case 1:
                printf("=> SEU PRODUTO É DO SUL");
                break;
            case 2:
                printf("=> SEU PRODUTO É DO NORTE");
                break;
            case 3:
                printf("=> SEU PRODUTO É DO LESTE");
                break;
            case 4:
                printf("=> SEU PRODUTO É DO OESTE");
                break;
            case 5:
                printf("=> SEU PRODUTO É DO NORDESTE");
                break;
            case 6:
                printf("=> SEU PRODUTO É DO SUDESTE");
                break;
            case 7:
                printf("=> SEU PRODUTO É DO CENTRO OESTE");
                break;
            case 8:
                printf("=> SEU PRODUTO É DO NOROESTE");
                break;
            default:
                printf("=> SEU PRODUTO É IMPORTADO");
        }
        if (codigo <= 9 || codigo > 0) {
            printf(" E SEU VALOR É R$ %.2f ", preco);
        }
    }

    //exercico 5

    if (n1 == 5) {
        int codigo, quantidade = 0;
        float res;
        bool rep = true;

        do {
            printf("DIGITE O CODIGO DO PRODUTO : ");
            scanf("%i", &codigo);
            if (quantidade == 0) {
                printf("QUAL É A QUANTIDADE DE PRODUTOS COMPRADO : ");
                scanf("%i", &quantidade);
            }

            switch(codigo) {
                case 1001:
                    res = quantidade*5.32;
                    printf("VALOR DEVIDO FICOU R$ %.2f", res);
                    return 0;
                case 1324:
                    res = quantidade*6.45;
                    printf("VALOR DEVIDO FICOU R$ %.2f", res);
                    return 0;
                case 6548:
                    res = quantidade*2.37;
                    printf("VALOR DEVIDO FICOU R$ %.2f", res);
                    return 0;
                case 987:
                    res = quantidade*5.32;
                    printf("VALOR DEVIDO FICOU R$ %.2f", res);
                    return 0;
                case 7623:
                    res = quantidade*6.45;
                    printf("VALOR DEVIDO FICOU R$ %.2f", res);
                    return 0;
                default:
                    printf("[ERRO] CODIGO NAO ESPECIFICADO\n");
            }
        }while (rep == true);
    }

    //exercicio 6

    if(n1 == 6) {
        int quantidade = 0, codigo;
        float res;
        bool rep = true;
        do {
            printf("DIGITE O CODIGO DO PRODUTO : ");
            scanf("%i", &codigo);
           if (quantidade == 0) {
                printf("QUAL É A QUANTIDADE DE PRODUTOS COMPRADO : ");
                scanf("%i", &quantidade);
            }

            switch(codigo) {
                case 100:
                    res = quantidade*1.20;
                    printf("VALOR DEVIDO FICOU R$ %.2f", res);
                    return 0;
                case 101:
                    res = quantidade*1.30;
                    printf("VALOR FICOU R$ %.2f", res);
                    return 0;
                case 102:
                    res = quantidade*1.50;
                    printf("VALOR FICOU R$ %.2f", res);
                    return 0;
                case 103:
                    res = quantidade*1.20;
                    printf("VALOR FICOU R$ %.2f", res);
                    return 0;
                case 104:
                    res = quantidade*1.30;
                    printf("VALOR FICOU R$ %.2f", res);
                    return 0;
                case 105:
                    res = quantidade*1.00;
                    printf("VALOR FICOU R$ %.2f", res);
                    return 0;
                default:
                    printf("[ERRO] CODIGO NAO ESPECIFICADO\n");
                    printf("Codigos dos produtors são 100, 101, 102, 103, 104 e 105.\n");
            }
        }while (rep == true);
    }

    //exercicio 7 

    if (n1 == 7) {
        int n1;
        bool res = true;

        do
        {
            printf("digite um numero de (1 a 7) : ");
            scanf("%i", &n1);

            switch (n1) {
            case 1:
                printf("=> O nuero %i corresponde a Domingo", n1);
                return 0;
                break;
            case 2:
                printf("=> O nuero %i corresponde a Segunda", n1);
                return 0;
                break;
            case 3:
                printf("=> O nuero %i corresponde a terça", n1);
                return 0;
                break;
            case 4:
                printf("=> O nuero %i corresponde a quarta", n1);
                return 0;
                break;
            case 5:
                printf("=> O nuero %i corresponde a quinta", n1);
                return 0;
                break;
            case 6:
                printf("=> O nuero %i corresponde a sexta", n1);
                return 0;
                break;
            case 7:
                printf("=> O nuero %i corresponde a sabado", n1);
                return 0;
                break;
            default:
                printf("[ERRO] Numero Digitado invalido tente novamente\n");
            }
        } while (res == true); 
    }

    //exercicio 8

    if (n1 == 8) {
        int n1;
        bool res = true;

        do {
            printf("digite um numero entre (1 a 10) : ");
            scanf("%i", &n1);

            switch (n1) {
                case 1:
                    printf("=> %i = um", n1);
                    return 0;
                case 2:
                    printf("=> %i = dois", n1);
                    return 0;
                case 3:
                    printf("=> %i = tres", n1);
                    return 0;
                case 4:
                    printf("=> %i = quatro", n1);
                    return 0;
                case 5:
                    printf("=> %i = cinco", n1);
                    return 0;
                case 6:
                    printf("=> %i = seis", n1);
                    return 0;
                case 7:
                    printf("=> %i = sete", n1);
                    return 0;
                case 8:
                    printf("=> %i = oito", n1);
                    return 0;
                case 9:
                    printf("=> %i = nove", n1);
                    return 0;
                case 10:
                    printf("=> %i = dez", n1);
                    return 0;
                default:
                    printf("[ERRO] Numero invalido tente novamente\n");
            } 
        }while(res == true);
    }

    if (n1 == 9) {
        char estado;
        bool res = true;

        do {
            printf("Digite a primeira letra do seu estao civil : ");
            scanf("%c", &estado);
            getchar();

            switch (estado) {
                case 's':
                    printf("=> Solteiro");
                    return 0;
                    break;
                case 'c':
                    printf("=> Casado");
                    return 0;
                    break;
                case 'v':
                    printf("=> Viúvo(a)");
                    return 0;
                    break;
                case 'd':
                    printf("=> Divorciado");
                    return 0;
                    break;
                default:
                    printf("[ERRO] Algo deu errado, tente novamente.\n");
                    break;
            }
        }while (res == true);
    }

    //exercicio 10

    if (n1 == 10) {
        char letra;

        printf("Digite uma letra e ira mostrar se é vogal ou consoante : ");
        scanf("%c", &letra);
        getchar();
        
        switch (letra) {
            case 'a':
                printf("=> VOGAL.");
                return 0;
                break;
            case 'e':
                printf("=> VOGAL.");
                return 0;
                break;
            case 'i':
                printf("=> VOGAL.");
                return 0;
                break;
            case 'o':
                printf("=> VOGAL.");
                return 0;
                break;
            case 'u':
                printf("=> VOGAL.");
                return 0;
                break;
            default:
                printf("=> CONSOANTE.");
                return 0;
                break;
        }
    }
}