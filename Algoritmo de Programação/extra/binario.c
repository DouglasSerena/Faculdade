#include <stdio.h>
#include <string.h>

int conversor(int valor) {
    int binario[10];
    float num;

    for (int i = 0;i < 10;i++) {
        num = valor % 2;
        binario[i] = num;
        valor /= 2;
    }
    for (int i = 9;i >= 0;i--) {
        printf("%d", binario[i]);
    }
}

int main() {
    int valor;

    printf("DIGITE UM VALOR PARA SER CONVERTIDO PARA BINARIO : ");
    scanf("%d", &valor);
    conversor(valor);
}