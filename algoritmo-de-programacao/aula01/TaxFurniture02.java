package Aula3;

public class TaxFurniture02 {
    /**
     * OBJ: não a como usar o JOptionPane, pois estou usando o docker e ele não
     * possui interfase gráfica.
     */
    public static void main(String[] args) {
        console.log("Valor da Transação: ");
        Float valueTransaction = console.readFloat();
        console.log("Venal prefeitura: ");
        Float percentageCity = console.readFloat();
        Float valueTaxCity = valueTransaction * (percentageCity / 100);
        console.log(
                String.format("Taxa que esta em cima do valor R$ %.2f foi de R$ %.2f", valueTransaction, valueTaxCity));
    }
}