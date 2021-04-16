package Source;

public class Matriz {

    public String matrizContem(int[][] matrizPadrao, int[][] matrizMaior) {
        // tamanho das matrizes
        int alturaPadrao = matrizPadrao.length;
        int larguraPadrao = alturaPadrao == 0 ? 0 : matrizPadrao[0].length;
        int alturaMaior = matrizMaior.length;
        int larguraMaior = alturaMaior == 0 ? 0 : matrizMaior[0].length;

        // percorre as linhas da matriz maior para procurar a menor
        for (int a = 0; a <= alturaMaior - alturaPadrao; a++) {

            // percorre as colunas da matriz manior para procurar a menor
            r: for (int b = 0; b <= larguraMaior - larguraPadrao; b++) {

                // percorre as linhas de ambas as matrizes
                for (int c = 0; c < alturaPadrao; c++) {

                    // percorre as colunas de ambas as matrizes
                    for (int d = 0; d < larguraPadrao; d++) {

                        // se os valores encontrados forem diferentes, o processo é interrompido e é
                        // executada
                        // uma nova busca pela matrizMaior
                        if (matrizMaior[a + c][b + d] != matrizPadrao[c][d])
                            continue r;
                    }
                }
                // retorna true se encontrar os valores da matrizPadrao dentro da matrizMaior
                String mensagem1 = "\nA matriz padrão foi encontrada!";
                return mensagem1;
            }
        }
        // retorna false se os valores não foram encontrados
        String mensagem2 = "\nMatriz não encontrada!";
        return mensagem2;
    }
}
