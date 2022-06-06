#include <stdio.h>;
#include <stdbool.h>;

int main() {
    int num;

    printf("Número do exercicio: ");
    scanf("%i", &num);

    // exercio de desafio

    if (num == 1) {
        int aluno = 0;
        float ap1, ap2, media;
        char para;

        do {
            aluno++;
            printf("=> Valor da nota 1: ");
            scanf("%f", &ap1);
            printf("=> Valor da nota 2: ");
            scanf("%f", &ap2);
            media = (ap1+ap2)/2;
            printf("=> Media do Aluno %i que foi de %.2f\n", aluno, media);
            printf("=> Continuar a calcular s = Sim | n = não: ");
            scanf("%s", &para);
        }while(para == 's' || para == 'S');
        printf("fim");
        return 0;
    }

    // exercio 1

    if (num == 2) {
        int i = 1;
        while (i <= 100) {
            printf("%d, ", i);
            i++;
        };
        return 0;
    }

    // exercio 2

    if (num == 3) {
        int valor;

        printf("digite um valor: ");
        scanf("%d", &valor);

        while (valor > 0) {
            if(valor == 1) {
                printf("%d", valor);
                return 0;
            }
            printf("%d ,", valor);
            valor--;
        };
    }

    // exercio 3

    if (num == 4) {
        char tecla;

        do {
            printf("aperte um tecla :");
            scanf("%s", &tecla);
        }while (tecla != 'w');
    }

    // exercio 4

    if(num == 5) {
        int valor;
        do {
            printf("digite um tecla: ");
            scanf("%d", &valor);
            getchar();
        }while (valor != 0);
    }

    // exercio 5

    if(num == 6) {
        int valor, count;

        do {
            printf("Digite um numero: ");
            scanf("%d", &valor);
            valor = valor % 2;
            count++;
        }while (valor != 0);
        count--;
        printf("Count %d", count);
    }

    // exercio 6

    if(num == 7) {
        int zero = 0, soma = 0, valor;

        do {
            printf("Digite um numero: ");
            scanf("%d", &valor);
            if (valor > 0) {
                soma += valor;
            }else if(valor == 0) {
                zero++;
            }
        }while (valor >= 0);
        printf("=> Valor total : %d\n=> quantidae de zeros : %d", soma, zero);
    }

    // exercio 7

    if(num == 8) {
        int valor, i = 1;

        printf("digite um numero: ");
        scanf("%d", &valor);
        while (i <= valor) {
            printf("%d ", i);
            i++;
        };
    }

    // exercio 8

    if(num == 9) {
        int n1, resultado, i = 1;

        printf("digite um numero: ");
        scanf("%i", &n1);
        while (i <= 10) {
            resultado = n1*i;
            printf("=> tabuada de %i = %i X %i = %i\n", n1, n1, i, resultado);
            i++;
        }
    }

    // exercio 9
    
    if(num == 10) {
        int senha;

        do {
            printf("digite sua senha: ");
            scanf("%d", &senha);
            if (senha != 2020) {
                printf("SENHA INVÁLIDA\n");
            }else {
                printf("ACESSO PERMITIDO");
                return 0;
            }
        }while (senha != 2020);
    }

    // exercio 10

    if(num == 11) {
        int valor1, valor2;

        do {
            printf("digite um valor1: ");
            scanf("%d", &valor1);
        }while (valor1 < 0);
        do {
            printf("digite um valor2: ");
            scanf("%d", &valor2);
        }while (valor2 > valor1);
        valor1 = valor1/valor2;
        printf("Valores divididos: %d", valor1);
    }

    // exercio 11

    if(num == 12) {
        float salario, resultado, salarios = 0;
        int  contador = 0;
        char opcao;

        do {
            printf("Informe seu salário: R$ ");
            scanf("%f", &salario);
            salarios += salario;

            printf("Dejesa continuar: s - Sim | n - Não: ");
            scanf("%s", &opcao);
            contador++;
        }while (opcao == 's' || opcao == 'S');

        resultado = salarios/contador;
        printf("A média salárial dos %d funcionários é de R$ %.2f", contador, resultado);
        return 0;
    }

    // exercio 12

    if(num == 13) {
        int cor;
        printf("1- azeul\n2- preto\n3- rosa\n4- vermelho\n");
        do {
            printf("escolha uma cor: ");
            scanf("%d", &cor);
        }while(cor < 1 || cor > 4);
        switch (cor) {
        case 1:
            printf("=> AZUL");
            break;
        case 2:
            printf("=> PRETO");
            break;
        case 3:
            printf("=> ROSA");
            break;
        case 4:
            printf("=> VERMELHO");
            break;
        }
    }

    // exercio 13

    if(num == 14) {
        int valor, total = 0, i = 1;

        printf("digite um valor: ");
        scanf("%d", &valor);
        while (i <= valor) {
            total += i;
            if(i == valor) {
                printf("%d = %d", i, total);
                return 0;
            }
            printf("%d + ", i);
            i++;
        }
    }

    // exercio 14

    if(num == 15) {
        int contador = 0;
        float valor = 0;

        printf("digite um valor: ");
        scanf("%f", &valor);
        do {
            valor /= 2;
            contador++;
        }while (valor > 1);
        printf("utima divisão %.2f, e houve %d divisões", valor, contador);
    }

    // exercio 15

    if(num == 16) {
        int idade, maio = 0;
        float altura, Amaio = 0;
        char resposta;

        do {
            printf("digite sua idade: ");
            scanf("%d", &idade);
            printf("digite sua altura: ");
            scanf("%f", &altura);
            if(idade >= 30) {
                maio++;
                Amaio += altura;
            }
            printf("Dejesa continuar: s - Sim | n - Não: ");
            scanf("%s", &resposta);
        }while(resposta == 's' || resposta == 'S');
        altura = Amaio/maio;
        printf("=> houve um total de %d pessoas com mais de 30 anos e a media das alturas foi %.2f", maio, altura);
    }
    
    // exercio 16

    if (num == 17) {
        int fina;//36 a 48
        float valor;

        printf("informe o valor do carro: ");
        scanf("%f", &valor);
        do {
            printf("informe as parcelas (36 a 48): ");
            scanf("%d", &fina);
        }while (fina < 36 || fina > 48);
        valor = valor/fina;
        printf("O veiculo ficou %d vezes de %.2f", fina, valor);
    }

    // exercio 17

    if (num == 18) {
        int codigo, c1, c2, contador = 0;
        float valor, media = 0, Controle = 0, Controle2 = 0;

        do {
            printf("Digite o codigo do produto: ");
            scanf("%d", &codigo);
            printf("Digite o valor do produto: R$ ");
            scanf("%f", &valor);
            if(contador == 0) Controle2 = valor;
            if(valor > Controle) {
                Controle = valor;
                c1 = codigo;
            }
            if(valor < Controle2) {
                Controle2 = valor;
                c2 = codigo;
            }
            media += valor;
            contador++;
        }while (codigo != 0);
        media /= contador;
        printf("O produto mais caro %d => R$ %.2f, mais barato %d => R$ %.2f e a media R$ %.2f", c1, Controle, c2, Controle2, media);
    }

    // exercio 18

    if (num == 19) {
        int G = 0, C = 0, O = 0;
        float pro, total = 0;
        char resposta;
        bool controle = false;

        do {
            printf("G = Gremio || C = Colorado || O = outros || f = Fim");
            printf("\nQUAL SEU TIME :");
            scanf("%s", &resposta);
            if(resposta == 'g' || resposta == 'G') {
                G++;
            }else if (resposta == 'c' || resposta == 'C') {
                C++;
            }else if (resposta == 'o' || resposta == 'O') {
                O++;
            }else if (resposta == 'f' || resposta == 'F') {
                controle = true;
            }else {
                printf("\n=======================================\n");
                printf("\nletra Informada esta fora do paramentro\n");
                printf("\n=======================================\n");
            }
        }while (controle == false);
        total = G+C+O;
        printf("\nHouve um total de %d - Gremistas\n", G);
        pro = (G*100)/total;
        printf("%.0f%% da torcedores são Gremistas\n", pro);
        printf("\nHouve um total de %d - Colorados\n", C);
        pro = (C*100)/total;
        printf("%.0f%% da torcedores são Colorados\n", pro);
        printf("\nHouve um total de %d - Outros\n", O);
        pro = (O*100)/total;
        printf("%.0f%% da torcedores são Outros\n", pro);
        printf("\nHouve um total de %.0f - torcedores\n", total);
    }
}