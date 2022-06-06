/*===================================================================================================*/
/*===========================execute o codigo inteiro e escolha o numero=============================*/
/*==========================do exercicio para executar ele seguindo a msg============================*/
/*===================================================================================================*/

#include <stdio.h>

int main() {

int n1;
int i;
printf("Diga o Numero do exercicio para executar : ");
scanf("%i" , &n1);

    if (n1 == 0) {
        
        int n_funcionario;//int variavel valor inteiro
        float horas, valor, salario;//float variavel valor flutuante
        
        printf("Nemero do funcionario: ");//equivale ao escrever
        scanf("%i" , &n_funcionario);//equivale ao leia - %i ler inteiro - & para fazer a leitura na memória
        printf("Horas Trabalhadas: ");
        scanf("%f" , &horas);
        printf("valor da Horas: ");
        scanf("%f" , &valor);
        
        salario = valor * horas;
        
        printf("salario do funcionario: \n=> R$ %.2f ", salario);//.2 server para limitar o numero de zeros
        
        return 0;//para finalizar o programa
    }

    //sugundo codigo

    if (n1 == 0.1) {
        
        float base, altura, area;
        
        printf("Qual é base do triangulo: ");
        scanf("%f" , &base);
        printf("Qual é a altura do triangulo: ");
        scanf("%f" , &altura);
        
        area = base*altura/2;
        
        printf("A area do triangulo é \n=> %.2f ", area);

        return 0;
    }

    //refazendo os codigos

    //exercicio 1 [PRONTO]

    if (n1 == 1) {
        
        int ndf;
        float ht, vt, vp;

        printf("Seu código : ");
        scanf("%i" , &ndf);
        printf("Horas trabalhadas : ");
        scanf("%f" , &ht);
        printf("Valor pro horas trabalhadas : ");
        scanf("%f" , &vt);

        vp = ht * vt;

        printf("=> TRABALHADOR: %i\n   PAGAMENTO: R$ %.2f", ndf, vp);

        return 0;
    }

    //exercicio 2 [PRONTO]

    if (n1 == 2) {

        int codigo1, quant1, codigo2, quant2;
        float valor1, valor2, percentual, valorIpi, total;

        printf("CODIGO DO SEU PRODUTO : ");
        scanf("%i" , &codigo1);
        printf("QUANTOS PRODUTOS FORAM ADQUIRIDOS : ");
        scanf("%i" , &quant1);
        printf("VALOR DO MESMO : ");
        scanf("%f" , &valor1);
        printf("CODIGO DO SEGUNDO PRODUTO : ");
        scanf("%i" , &codigo2);
        printf("QUANTOS FORAM COMPRADOS : ");
        scanf("%i" , &quant2);
        printf("VALOR DO MESMO : ");
        scanf("%f" , &valor2);
        printf("PERCENTAGEN DO IPI : ");
        scanf("%f" , &percentual);

        total = quant1 * valor1 + quant2 * valor2;
        valorIpi = total + total * (percentual/100);

        printf("=> TOTAL: R$ %.2f\n TOTAL+IPI: R$ %.2f", total, valorIpi);

        return 0;
    }

    //exercicio 3 [PRONTO]

    if (n1 == 3) {

        int a,b;
        float resultado;

        printf("DIGITE O NUMERO A : ");
        scanf("%i" , &a);
        printf("DIGITE O NUMERO B : ");
        scanf("%i" , &b);
        resultado = a * b;
        printf("=> MUTIPLICAÇÃO: %.2f\n", resultado);
        resultado = a / b;
        printf("   DIVISÃO: %.2f\n", resultado);
        resultado = a -b;
        printf("   SUBTRAÇÂO: %.2f\n", resultado);
        resultado = a + b;
        printf("   SOMA: %.2f\n", resultado);

        return 0;
    }

    //exercicio 4 [PRONTO]

    if (n1 == 4) {

        int a, b;
        float med;

        printf("DIGITE UM NUMERO DA FAZER A MEDIA COM O SEGUNDO NUMERO : ");
        scanf("%i" , &a);
        printf("DIGITE O SEGUNDO NUMERO : ");
        scanf("%i" , &b);

        med = (a + b) / 2;

        printf("=> MEDIA: %.2f", med);

        return 0;
    }

    //exercicio 5 [PRONTO]

    if (n1 == 5) {

        int valor1, valor2 , X;

        printf("DIGITE UM NUMERO PARA SOMAR COM O SEGUNDO : ");
        scanf("%i" , &valor1);
        printf("DIGITE O SEGUNDO : ");
        scanf("%i" , &valor2);

        X = valor1 + valor2;

        printf("=> RESULTADO: %i", X);

        return 0;
    }

    //exercicio 7 [PRONTO]

    if (n1 == 7){
        
        int NRO_COELHOS;
        float CUSTO;

        printf("QUANTOS COELHOS À : ");
        scanf("%i" , &NRO_COELHOS);

        CUSTO = NRO_COELHOS*0.70/18+10;

        printf("=> COELHOS: %i\n CUSTO: R$ %.2f", NRO_COELHOS, CUSTO);

        return 0;
    }

    //exercicio 8 [PRONTO]

    if (n1 == 8) {
        
        int numero;
        float resultado;

        printf("DIGITE UM NUMERO PARA VER SUA POTENCIAS (EX=X²) : ");
        scanf("%i" , &numero);

        resultado = numero*numero;

        printf("=> RESULTADO: %.2f", resultado);

        return 0;
    }

    //exercicio 9 [PRONTO]

    if (n1 == 9) {

        int numero1, numero2, soma;

        printf("DIGITE UM NUMERO PARA SOMAR COM UM SEGUNDO : ");
        scanf("%i" , &numero1);
        printf("DIGITE O SEGUNDO NUMERO : ");
        scanf("%i" , &numero2);
        
        soma = numero1 + numero2;

        printf("=> RESULTADO: %i", soma);

        return 0;
    }

    //exercico 10 [PRONTO]

    if (n1 == 10) {
        
        float resultado, numero1, numero2;

        printf("DIGITE UM NUMERO PARA SER DIVIDIDO O SEGUNDO : ");
        scanf("%f" , &numero1);
        printf("DIGITE O SEGUNDO : ");
        scanf("%f" , &numero2);

        resultado = numero1 / numero2;

        printf("=> 1° VALOR: %.2f\n 2° VALOR: %.2f\n   RESULTADO: %.2f .",numero1, numero2, resultado);
    }

    //exercicio 11 [PRONTO]

    if (n1 == 11) {
        int numero1, numero2, numero3;
        float media;

        printf("DIGITE UM NUMERO PARA FAZER MEDIA COM OUTROS DOIS : ");
        scanf("%i" , &numero1);
        printf("DIGITE O SEGUNDO NUMERO : ");
        scanf("%i" , &numero2);
        printf("DIGITE O TERCEIRO : ");
        scanf("%i" , &numero3);
        media = (numero1 + numero2 + numero3)/3;
        printf ("=> 1° VALOR: %i\n   2° VALOR: %i\n   3° VALOR: %i\n   MEDIA: %.2f", numero1, numero2, numero3, media);

        return 0;
    }

    //exercicio 12 [PRONTO]

    if (n1 == 12) {
        int a, b, sub, res;

        printf("DIGITE UM NUMERO PARA TER UM DIFERENCA COM O SEGUNDO PARA\nA DIFRENCA PODER RETIRA O QUADRADO DO RESULTADO: ");
        scanf("%i" , &a);
        printf("DIGITE O SEGUNDO NUMERO : ");
        scanf("%i" , &b);
        sub = a - b;
        res = sub*sub;
        printf("=> RESULTADO: %i",res);

        return 0;
    }

    //exercicio 13 [PRONTO]

    if (n1 == 13) {
        int a, b, rusA, rusB;
        float medA, medB;

        printf("DIGITE UM NUMERO PARA HAVER UM MEDIA ENTRE ELE E 4 : ");
        scanf("%i" , &a);
        printf("DIGITE UM NUMERO PARA HAVER UM MEDIA ENTRE ELE E 6 : ");
        scanf("%i" , &b);
        rusA = a*4;
        rusB = b*6;
        medA = rusA/2;
        medB = rusB/2;

        printf("=> 1° VALOR: %i\n   2° VALOR: %i\n", a, b);
        printf("   1° RESULTATO: %i\n   2° VALOR: %i\n", rusA, rusB);
        printf("   1° MEDIA: %.2f\n   2° MEDIA: %.2f", medA, medB);

        return 0;
    }

    //exercicio 14 [PRONTO]

    if (n1 == 14) {
        int a, b, c;
        float d;

        printf("DIGITE O NUMERO A : ");
        scanf("%i" , &a);
        printf("DIGITE O NUMERO B : ");
        scanf("%i" , &b);
        printf("DIGITE O NUMERO C : ");
        scanf("%i" , &c);
        d = b * 2 - 4 * a * c;
        printf("=> valor A = %i \n   valor B = %i \n   valor C = %i.\n   resultado : %.2f", a, b, c, d);

        return 0;
    }

    //exercicio 15 [PRONTO]

    if (n1 == 15) {
        int anos, meses, dias;

        printf("QUAL É SUA IDADE : ");
        scanf("%i" , &anos);
        meses = anos*12;
        dias = meses*30;
        printf("=> IDADE: %i MESES\n   IDADE: %i DIAS", meses, dias);

        return 0;
    }

    //exercicio 16 [PRONTO]

    if (n1 == 16) {
        int distancia, velocidade, litros_usados;
        float tempo;

        printf("Qual é a Velociade media percorida : ");
        scanf("%i" , &velocidade);
        printf("Quanto tempo demorou : ");
        scanf("%f" , &tempo);
        distancia = tempo*velocidade;
        litros_usados = distancia/12;
        printf("=> velocidade %i\n   TEMPO: %.2f Horas\n   DISTANCIA %i KM\n   GASOLINA GASTA: %i litros", velocidade, tempo, distancia, litros_usados);
    }

    //exercicio 17 [PRONTO]

    if (n1 == 17) {
        int gasolina, distancia;
        float distanciaPorLitro;

        printf("quanta gasolina foi gasta : ");
        scanf("%i" , &gasolina);
        printf("qual foi a distancia percorida : ");
        scanf("%i" , &distancia);

        distanciaPorLitro = distancia/gasolina;

        printf("MEDIA: %.2f Km/l", distanciaPorLitro);

        return 0;
    }

    //exercicio 18 [PRONTO]

    if (n1 == 18) {
        int valor1, valor2, valor3, valor4;
        float media;

        printf("DIGITE UM NUMERO PARA FAZER UM MEDIA ENTRE OUTROS 4 : ");
        scanf("%i", &valor1);
        printf("DIGITE OUTRO NUMERO : ");
        scanf("%i" , &valor2);
        printf("DIGITE OUTRO NUMERO : ");
        scanf("%i" , &valor3);
        printf("DIGITE OUTRO NUMERO : ");
        scanf("%i" , &valor4);

        media = (valor1 + valor2 + valor3 + valor4)/4;
        
        printf("=> MEDIA %.2f", media);

        return 0;
    }

    //exercicio 19 [PRONTO]



    if (n1 == 19) {
        
        float total, n1, n2 , n3, n4, n5;

        printf("o numero de moedas de 1 real : ");
        scanf("%f" , &n1);
        printf("o numero de moedas de 50 centavos : ");
        scanf("%f" , &n2);
        printf("o numero de moedas de 25 centavos : ");
        scanf("%f" , &n3);
        printf("o numero de moedas de 10 centavos : ");
        scanf("%f" , &n4);
        printf("o numero de moedas de 5 centavos : ");
        scanf("%f" , &n5);

        n2 = n2 * 50;
        n3 = n3 * 25;
        n4 = n4 * 10;
        n5 = n5 * 5;
        total = (n2 + n3 + n4 + n5)/100;
        total = total + n1;

        printf("=> TOTAL: R$ %.2f ", total);

        return 0;
    }

    //exercicio 20 [PRONTO]

    if (n1 == 20) {

        float total, vha, inss, nam;

        printf("qual é o valor das horas por aula : ");
        scanf("%f" , &vha);
        printf("quantas aulas foram trabalhadas no mês : ");
        scanf("%f" , &nam);
        printf("A porsentagen do inss : ");
        scanf("%f" , &inss);

        inss = inss/100;
        total = vha * nam;

        printf("=> total bruto: R$ %.2f\n", total);

        total = total - total * inss;

        printf("   total liquido: R$ %.2f ", total);

        return 0;
    }

    //exercicio 21 [PRONTO]

    if (n1 == 21) {

        float cel, fah;

        printf("QUAL É A TEMPERATURA EM GRAUS CENTÍGRADOS : ");
        scanf("%f" , &cel);

        fah = (9 * cel + 160)/5;

        printf("=> NA CONVERSÂO DE GRAUS CENTÍGRADOS QUE SERIA %.0f C°\n=> PARA FAHRENHEIT FICOU %.0f F°", cel, fah);

        return 0;
    }

    //exercicio 22 [PRONTO]

    if (n1 == 22) {

        float Cel, Fah, cal;

        printf("QUAL É A TEMPERATURA EM GRAUS FAHRENHEIT : ");
        scanf("%f" , &Fah);

        Cel = (Fah-32)*(5/9.0);

        printf("=> NA CONVERSÂO DE GRAUS FAHRENHEIT QUE SERIA %.0f F°\n=> PARA CENTÍGRADOS FICOU %.0f C°\n", Fah, Cel);

        return 0;
    }

    //exercicio 23 [PRONTO]

    if (n1 == 23) {

        int  ;
        float taxa, prestacao, valor, tempo;

        //calcula o valor total de um prestação com juros de taxa de %

        printf("QUAL È O VALOR DA COBRANÇA : ");
        scanf("%f" , &valor);
        printf("QUANTO TEMPO VAI DEMORAR PARA PAGAR : ");
        scanf("%f" , &tempo);
        printf("TAXA QUE È COBRADA : ");
        scanf("%f" , &taxa);

        prestacao = valor+(valor*(taxa/100)*tempo);

        printf("=> VALOR DA PRESTAÇÃO R$ %.2f", prestacao);

        return 0;
    }

    //exercicio 24 [PRONTO]

    if (n1 == 24) {
        int codigo1, quant1, codigo2, quant2;
        float valor1, valor2, percentual, valorIpi, total, valorIpi1, valorIpi2;

        printf("codigo do produto : ");
        scanf("%i" , &codigo1);
        printf("quantos produtos : ");
        scanf("%i" , &quant1);
        printf("valor do produto : ");
        scanf("%f" , &valor1);
        printf("codigo do produto 2 : ");
        scanf("%i" , &codigo2);
        printf("quantos produtos 2 : ");
        scanf("%i" , &quant2);
        printf("valor do produto 2 : ");
        scanf("%f" , &valor2);
        printf("percentual do Ipi : ");
        scanf("%f" , &percentual);

        valor1 = valor1 * quant1;
        valor2 = valor2 * quant2;
        percentual = percentual/100;
        valorIpi1 = valor1 + valor1 * percentual;
        valorIpi2 = valor2 + valor2 * percentual;
        total = valor1 + valor2;
        valorIpi = valorIpi1 + valorIpi2;

        printf("=> PRODUTO: 1\n   CODIGO: %i\n   QUANTIDADE: %i\n   VALOR: R$ %.2f\n   VALOR COM INSS: R$ %.2f\n",codigo1, quant1, valor1, valorIpi1);
        printf("=> PRODUTO: 2\n   CODIGO: %i\n   QUANTIDADE: %i\n   VALOR: R$ %.2f\n   VALOR COM INSS: R$ %.2f\n",codigo2, quant2, valor2, valorIpi2);
        printf("=> VALOR TOTAL SEM IPI: R$ %.2f\n=> VALOR TOTAL COM IPI R$ %.2f", total, valorIpi);

        return 0;
    }

    //exercicio 25 [arrumar]

    if (n1 == 25) {

        int codigo, vendas;
        float salario, valorProduto, persentual, comissao, total;

        printf("SEU CODIGO : ");
        scanf("%i" , &codigo);
        printf("SEU SALARIO FIXO : R$ ");
        scanf("%f" , &salario);
        printf("QUANTOS PRODUTOS FORAM VENDIDO : ");
        scanf("%i" , &vendas);
        printf("VALOR DO PRODUTO : R$ ");
        scanf("%f" , &valorProduto);
        printf("COMISAO DO VENDEDOR : ");
        scanf("%f" , &persentual);

        valorProduto = valorProduto * vendas;
        persentual = persentual/100;
        comissao = valorProduto * persentual;
        total = salario + comissao;

        printf("=> CODIGO DO VENDEDOR: %i\n   QUANTIDADE VENDIDA: %i\n   SALARIO: R$ %.2f\n   COMISÃO: R$ %.2f\n   SALARIO TOTAL: R$ %.2f",codigo , vendas, salario, comissao, total);

        return 0;
    }

    //exercicio 26

    if (n1 == 26) {
        int id;
        float sal_new, sal_atual, prod, rep;

        printf("ID DO FUNCIONARIO");
        scanf("%i" , &id);
        printf("QUAL È O SALARIO ATUAL DO FUNCIONARIO : ");
        scanf("%f" , &sal_atual);
        printf("QUAL SERA O INDICE DE REPOSIÇÂ SALARIAL : ");
        scanf("%f" , &rep);
        printf("QUAL É O INDECE DE PRODUÇÂO DO FUNCIONARIO : ");
        scanf("%f" , &prod);
        
        prod = prod/100;
        rep = rep/100;
        prod = (sal_atual * rep)+(sal_atual * prod);
        sal_new = sal_atual + prod;

        printf("=> ID FUNCIONARIO: %i\n   SALARIO ANTERIO: R$ %.2f\n   REAJUSTE: R$ %.2f\n   NOVO SALARIO: R$ %.2f", id, sal_atual, prod, sal_new);

    }

    //exercicio 27 [PRONTO]

    if (n1 == 27) {
        int codigoFuncionario;
        float Horas, salario, valorProHOras;

        printf("SEU CODIGO : ");
        scanf("%i" , &codigoFuncionario);
        printf("QUANTAS HORAS TRABALHADAS : ");
        scanf("%f" , &Horas);
        printf("QUANTO VOCE GANHA POR HORA : R$ ");
        scanf("%f" , &valorProHOras);

        salario = valorProHOras*Horas;

        printf("=> SEU SALARIO É R$ %.2f", salario);

        return 0;

    }
    //exercicio 28 [PRONTO]

    if (n1 == 28) {
        int numero_A = 24;
        float taxa = 0.48, valor_E, valor_A;

        printf("QUAL È O VALOR DO EMPRESTIMO : ");
        scanf("%f" , &valor_E);

        /*valor_A = valor_E/numero_A;
        valor_A = (valor_E*taxa);*/
        valor_A = (valor_E*taxa)/numero_A;

        printf("=> VALOR AMORTIZAÇÃO: R$ %.2f", valor_A);

    }

    //exercicio 29 [PRONTO]

    if (n1 == 29) {
        int custoFabrica;
        float imposto = 0.48, distribuidor = 0.24, custoCarro;

        printf("QUANTO CUSTA A FABRICAÇÂO DO VEICULO : R$ ");
        scanf("%i" , &custoFabrica);

        custoCarro = custoFabrica*imposto;
        custoCarro = custoCarro+custoFabrica*distribuidor+custoFabrica;

        printf("=> VALOR CAR: R$ %.2f", custoCarro);

        return 0;
    }

    //exercicio 30 [PRONTO]

    if (n1 == 30) {
        int codigo, vendas;
        float salario, valor, comissao = 5;

        printf("SEU INDENTIFICADOR : ");
        scanf("%i" , &codigo);
        printf("SEU SALARIO : ");
        scanf("%f" , &salario);
        printf("QUANTOS CARROS FORAM VENDIDOS : ");
        scanf("%i" , &vendas);
        printf("VALOR CAR : ");
        scanf("%f" , &valor);

        valor = valor*vendas;
        comissao = comissao/100;
        comissao = valor*comissao;;
        salario = salario + comissao;

        printf("=> VENDEDOR %i\n   SALARIO: R$ %.2f", codigo, salario);

        return 0;
    }

    //senha [PRONTO]

    if (n1 == 31) {

        int senha;
        //pode usar esta formula
        int senhaCerta = 1524;

        printf("DIGITE SUA SENHA : ");
        scanf("%i" , &senha);

        if (senha == 1524 /*senhaCerta*/) {
            printf("PARABENS VOCÊ ESNTROU COM SUCESSO\n");
        }else{
            printf("INFELISMENTE VOCÊ ESTA COLOCANDO SUA SENHA ERRADA\n");
        }

        return 0;
    }
}