package Aula3;

public class CalcProduct05 {
    private static String[] nameProduct = new String[50];
    private static float[] valueProduct = new float[50];
    private static boolean next;

    public static void main(final String[] args) {
        int count = 0;
        do {
            console.log("Qual o nome do produto " + (1 + count) + ": ");
            nameProduct[count] = console.readString();
            do {
                console.log("Qual o valor deste produto " + (1 + count) + ": ");
                valueProduct[count] = console.readFloat();
                if (valueProduct[count] < 0)
                    console.log("Valor do produto não deve ser menor que 0 tente novamente.");
            } while (valueProduct[count] < 0);
            console.log("Quer continuar informado produtos: ");
            final char res = console.readString().toLowerCase().charAt(0);
            if (res == 's')
                next = true;
            else
                next = false;
            count++;
            if (nameProduct.length == count)
                break;
        } while (next);
        for (int i = 0; i < nameProduct.length; i++) {
            if (i == count)
                break;
            final float valueDiscount = calcDiscount(valueProduct[i]);
            console.log(String.format(
                    (i + 1) + " - name => " + nameProduct[i] + " | value => R$ %.2f | desconto => R$ %.2f ",
                    valueProduct[i], valueDiscount));
        }
    }

    private static float calcDiscount(final float value) {
        if (value >= 50 && value < 200) {
            return value - (value * 5 / 100);
        } else if (value < 500) {
            return value - (value * 6 / 100);
        } else if (value < 1000) {
            return value - (value * 7 / 100);
        }
        return value - (value * 8 / 100);
    }
}