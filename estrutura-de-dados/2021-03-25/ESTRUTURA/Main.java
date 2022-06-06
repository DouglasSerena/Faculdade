import Source.*;

public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz();
        
        //cria a matriz e determina o seu tamanho
        int tam = 100;
        int matrizMaior[][] = new int[tam][tam];

        //cria a matriz principal
        for(int i = 0; i<tam; i++){
            for(int j = 0; j<tam; j++){
                matrizMaior[i][j] = (int)Math.round(Math.random()*1); 
                System.out.print(matrizMaior[i][j]);
            }
        }

        //cria matriz a ser buscada e mostra na tela
        int[][] matrizPadrao = {
            {1, 1},
            {1, 0}
        };

        System.out.println("\nMatriz padrão definida!");

        //Faz a busca pela matriz, mostrando na tela
        //Faz a contagem do tempo gasto para encontrar o padrão
        long tempoInicial = System.currentTimeMillis();

        System.out.println(matriz.matrizContem(matrizPadrao, matrizMaior));

        long tempoFinal = System.currentTimeMillis();

        System.out.println("\nTempo de execução: " + (tempoFinal-tempoInicial) + " millis");
    }
}
