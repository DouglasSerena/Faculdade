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
        int n1;

        printf("DIGITE UM NUMERO : ");
        scanf("%i" , &n1);

        if (n1 > 0 && n1 < 100) {
            printf("=> SEU NUMERO ESTA ABAIXO DE CEM!\n");
        }else if (n1 < 1000) {
            printf("=> SEU NUMERO É MENOR QUE 1000!\n");
        }

        return 0;
    }

    //exercicio 2

    if (n1 == 2) {
        int n1;
        float res;

        printf("DIGITE UM NUMERO : ");
        scanf("%i" , &n1);

        if (n1 > 30) {
            res = n1/2;
            printf("=> A METADE DO SEU NUMERO FOI %.2F !\n", res);
        }else {
            res = n1*2;
            printf("=> O DOBRO DO SEU NUMERO FOI %.2f !\n", res);
        }

        return 0;
    }

    //exercicio 3

    if (n1 == 3) {
        int n1, n2, n3, res;

        printf("DIGITE UM NUMERO : ");
        scanf("%i" , &n1);
        printf("DIGITE UM SEGUNDO NUMERO : ");
        scanf("%i", &n2);
        printf("DIGITE UM TERCEIRO NUMERO : ");
        scanf("%i", &n3);

        res = n1+n2+n3;

        if (res > 50) {
            printf("=> PARABREM VOCE DESCUBRIU UMA MENSAGEN SECRETA!!!\n");
        }

        return 0;
    }

    //exercicio 4

    if (n1 == 4) {
        int n1, n2, res1, res2;

        printf("DIGITE UM NUMERO : ");
        scanf("%i", &n1);
        printf("DIGITE OUTRO NUMERO : ");
        scanf("%i", &n2);

        res1 = n1+n2;

        if (res1 > 20) {
            res2 = res1+res1+8;
            printf("=> O VALOR FOI %i\n", res2);
        }else {
            res2 = res1-5;
            printf("=> O VALOR FICOU %i!\n", res2);
        }
        
        return 0;
    }

    //exercicio 5

    if (n1 == 5) {
        int idade;
        char sexo;

        printf("QUAL È SUA IDADE : ");
        scanf("%i" , &idade);
        getchar();
        printf("QUAL É SEU SEXO 'INFORME-O COM F OU M' : ");
        scanf("%c" , &sexo);

        if ((sexo == 'F' || sexo == 'f') && (idade <= 25)) {
            printf("=> ACEITO!!!\n");
        }else {
            printf("=> NÃO ACEITO!!!(\n");
        }

        return 0;
    }

    //exercicio 6

    if (n1 == 6) {
        float km, combustivel;
        char car;

        printf("QUANTOS Km FOI PERCORRIDO : ");
        scanf("%f" , &km);
        getchar();
        printf("QUAL É O TIPO DE CARRO (A, B, C) : ");
        scanf("%c", &car);
        if (car == 'A' || car == 'a') {
            combustivel = km/8;
            printf("=> VOCE GASTOU %.2f l\n", combustivel);
        }else if (car == 'B' || car == 'b') {
            combustivel = km/9;
            printf("=> VOCE GASTOU %.2f l\n", combustivel);
        }else if (car == 'C' || car == 'c') {
            combustivel = km/12;
            printf("=> VOCE GASTOU %.2f l\n", combustivel);
        }else {
            printf("=> [ERRO] VOCE INFORMO ALGO ERRADO :(\n");
        }

        return 0;
    }

    //exercicio 7

    if (n1 == 7) {

        int senha;
        //pode usar esta formula
        int senhaCerta = 1524;

        printf("DIGITE SUA SENHA : ");
        scanf("%i" , &senha);

        if (senha == 1524 /*senhaCerta*/) {
            printf("=> ACESSO PERMITIDO!!!\n");
        }else{
            printf("=> ACESSE NEGADO!!!\n");
        }

        return 0;
    }

    //exercicio 8

    if (n1 == 8) {
        int maca;
        float res;

        printf("QUANTAS MAÇAS FORAM COMPRADAS : ");
        scanf("%i", &maca);

        if (maca < 12) {
            res = maca*1.30;
            printf("=> SUA COMPRA FICOU R$ %.2f.\n", res);
        }else {
            res = maca*1;
            printf("=> SUA COMPRA FICOU R$ %.2f.\n", res);
        }

        return 0;
    }

    //exercici 9

    if (n1 == 9) {
        int gol1, gol2;
        char time1, time2;

        getchar();
        printf("DIGITE O PRIMEIRO TIME (somente a primeira letra) : ");
        scanf("%c", &time1);
        getchar();
        printf("QUANTOS GOLS FEZ : ");
        scanf("%i", &gol1);
        getchar();
        printf("DIGITE O SEGUNDO TIME (somente a primeira letra) : ");
        scanf("%c", &time2);
        printf("QUANTOS GOLS FEZ : ");
        scanf("%i", &gol2);

        if (gol1 > gol2) {
            printf("=> O VENCEDOR FOI O TIME (%c) DE %i A %i !!!\n", time1, gol1, gol2);
        }else if (gol1 < gol2) {
            printf("=> O VENCEDOR FOI O TIME (%c) DE %i A %i !!!\n", time2, gol2, gol1);
        }else {
            printf("=> O TIME (%c) EMPATOU COM O TIME (%c) DE %i A %i !!!\n", time1, time2, gol1, gol2);
        }

        return 0;
    }

    //exercico 10

    if (n1 == 10) {
        float saldoAtual, saldo, debito, credito;
        
        printf("QUANTO SALDO VOCE POSSUI : R$ ");
        scanf("%f", &saldo);
        printf("QUAL È SEU DEBITO : R$ ");
        scanf("%f", &debito);
        printf("CREDITO ATUAL : R$ ");
        scanf("%f", &credito);
        
        saldoAtual = saldo-debito+credito;

        if (saldoAtual > 0) {
            printf("=> SEU SALDO È POSITIVO (R$ %.2f)\n", saldoAtual);
        }else if (saldoAtual < 0) {
            printf("=> SEU SALDO È NEGATIVO (R$ %.2f)\n", saldoAtual);
        }else {
            printf("=> VOCE NAO POSSUI SALDO (R$ %.2f)\n", saldoAtual);
        }

        return 0;
    }

    //exercicie 11

    if (n1 == 11) {
        int estoque, max, min, med;

        printf("QUANTIDADE EM ESTOQUE : ");
        scanf("%i", &estoque);
        printf("O MAXIMO QUE O ESTOQUE SUPORTA : ");
        scanf("%i", &max);
        printf("O MINIMO QUE O ESTOQUE SUPORTA : ");
        scanf("%i", &min);

        med = (max+min)/2;

        if (estoque >= med) {
            printf("=> NAO EFETUE COMPRAS, ESTOQUE BOM.\n");
        }else {
            printf("=> ESTOQUE MUITO BAIXO EFETUE COMPRA.\n");
        }

        return 0;
    }

    //exercicio 12

    if (n1 == 12) {
        float salario;
        char cargo;

        getchar();
        printf("QUAL SUA FUNCAÇÂO\n (tecnico = T)\n (gerente = G)\n (outros = O) : ");
        scanf("%c", &cargo);
        getchar();
        printf("SALARIO ATUAL : R$ ");
        scanf("%f", &salario);

        if (cargo == 't' || cargo == 'T') {
            salario = salario+(salario*0.5);
            printf("=> SEU SALARIO FOI REAJUSTADO PARA R$ %.2f\n", salario);
        }else if (cargo == 'g' || cargo == 'G') {
            salario = salario+(salario*0.3);
            printf("=> SEU SALARIO FOI REAJUSTADO PARA R$ %.2f\n", salario);
        }else {
            salario = salario+(salario*0.2);
            printf("=> SEU SALARIO FOI REAJUSTADO PARA R$ %.2f\n", salario);
        }
         return 0;
    }

    //exercico 13

    if (n1 == 13) {
        int condicao;
        float valor;

        printf("VALOR DA VENDA : ");
        scanf("%f", &valor);
        printf("FORMA DE PAGAMENTO:\n");
        printf(" 1 - VENDA A VISTA - DESCONTO DE 10%\n 2 - VENDA A PRAZA 30 DIAS - DESCONTO 5%\n");
        printf(" 3 - VENDA A PRAZA 60 DIAS - MESMO PREÇO\n 4 - VENDA A PRAZA 90 DIAS - ACRÉCIMO DE 5%\n");
        printf(" 5 - VENDA COM CARTÃO DE DÉBITO 8%\n 6 - VENDA COM CARTÃO DE CRÉDITO - DESCONTO 7%\n=> ");
        scanf("%i", &condicao);

        switch (condicao) {
        case 1:
            valor = valor-(valor*0.10);
            break;
        case 2:
            valor = valor-(valor*0.05);
            break;
        case 4:
            valor = valor+(valor*0.05);
            break;
        case 5:
            valor = valor-(valor*0.08);
            break;
        case 6:
            valor = valor-(valor*0.07);
            break;
        default :
            printf("[ERRO] VALOR DIGITADO NAO ENCONTRADO TENTE NOVAMENTE\n");
            return 0;
        }

        printf("=> SUA COMPRA FICOU R$ %.2f\n", valor);

        return 0;
    }

    //exercico 14

    if (n1 == 14) {
        int dia;
        
        printf("ESCOLHA UM NÚMERO de 1 a 7 QUE INFORMAREI O DIA DA SEMANA: ");
        scanf("%i", &dia);

        switch (dia)
        {
        case 1:
            printf("=> DOMINGO!!!\n");
            break;
        case 2:
            printf("=> SEGUNDA-FEIRA!!!\n");
            break;
        case 3:
            printf("=> TERÇA-FEIRA!!!\n");
            break;
        case 4:
            printf("=> QUARTA-FEIRA!!!\n");
            break;
        case 5:
            printf("=> QUINTA-FEIRA!!!\n");
            break;
        case 6:
            printf("=> SEXTA-FEIRA!!!\n");
            break;
        case 7:
            printf("=> SÁBADO\n");
            break;        
        default:
            printf("=> [ERRO] NEM UM VALOR FOI ENCONTRADO.\n");
            break;
        }

        return 0;
    }

    //exercicio 15

    if (n1 == 15) {
        int numero;
        
        printf("DIGITE UM NÚMERO ENTRE 0 e 10 E INFORMAREI ELE POR EXTENSO: ");
        scanf("%i", &numero);

        switch (numero)
        {
        case 0:
            printf("=> ZERO\n");
            break;
        case 1:
            printf("=> UM\n");
            break;
        case 2:
            printf("=> DOIS\n");
            break;
        case 3:
            printf("=> TRÊS\n");
            break;
        case 4:
            printf("=> QUATRO\n");
            break;
        case 5:
            printf("=> CINCO\n");
            break;
        case 6:
            printf("=> SEIS\n");
            break;
        case 7:
            printf("=> SETE\n");
            break;
        case 8:
            printf("=> OITO\n");
            break;   
        case 9:
            printf("=> NOVE\n");
            break; 
        case 10:
            printf("=> DEZ\n");
            break;
        default:
            printf("=> [ERRO] NÚMERO INVÁLIDO.\n");
            break;
        }
    }

    return 0;
}