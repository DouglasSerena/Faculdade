package Aula3;

public class CalcResistance06 {
    private static float numberResistance;
    private static float maxResistance = 0;
    private static float minResistance = 0;

    public static void main(String[] args) {
        console.log("Quantos resistores possui o circuito: ");
        int countResistance = console.readInt();
        for (int i = 0; i < countResistance; i++) {
            console.log("Valor da resistencia em Ω do resistor " + (1 + i) + ": ");
            float res = console.readFloat();
            if (minResistance == 0)
                minResistance = res;
            if (minResistance > res)
                minResistance = res;
            if (maxResistance < res)
                maxResistance = res;
            numberResistance += res;
        }
        console.log(String.format("A resistencia do circuito ficou %.2f Ω a maior resistencia %.2fΩ e a menor %.2fΩ",
                numberResistance, maxResistance, minResistance));
    }
}