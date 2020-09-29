package Aula3;

public class ValuerProduct01 {
    public static void main(String[] args) {
        console.log("Informe o valor do produto:");
        float valueProduct = console.readFloat();

        console.log("Informe o desconto sobre o produto:");
        float discountProduct = console.readFloat();

        float discountProductValue = valueProduct * (discountProduct / 100);
        float productWithDiscount = valueProduct - discountProduct;

        System.out.printf("O Produto ficou no total R$ %.2f Desconto de %.2f\n", productWithDiscount,
                discountProductValue);
    }
}