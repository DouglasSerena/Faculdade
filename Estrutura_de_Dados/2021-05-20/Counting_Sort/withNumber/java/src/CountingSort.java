package src;

public class CountingSort {
  public static int[] order(int[] array) {
    int size = array.length;
    int moreValue = 0;

    for (int index = 0; index < size; index++) {
      if (array[index] > moreValue) {
        moreValue = array[index];
      }
    }

    if(size > moreValue) {
      moreValue = size;
    }

    int[] output = new int[size];
    int[] count = new int[moreValue + 1];

    // Entrada array: [1, 4, 1, 2, 7, 5, 2]
    // Saida count:   [0, 2, 2, 0, 1, 1, 0, 1]
    for (int index = 0; index < size; index++) {
      count[array[index]] += 1;
    }

    // Entrada count: [0, 2, 2, 0, 1, 1, 0, 1]
    // Saida count:   [0, 2, 4, 4, 5, 6, 6, 7]
    for (int index = 1; index <= moreValue; ++index) {
      count[index] += count[index - 1];
    }

    // Entrada array:  [1, 4, 1, 2, 7, 5, 2]
    // Entrada count:  [0, 2, 4, 4, 5, 6, 6, 7]
    // Saida count:    [0, 0, 2, 4, 4, 5, 6, 6]
    // Entrada output: [0, 0, 0, 0, 0, 0, 0]
    // Saida output:   [1, 1, 2, 2, 4, 5, 7]
    for (int index = size - 1;index >= 0;index--) {
      output[count[array[index]] - 1] = array[index];
      count[array[index]] -= 1;
    }

    return output;
  }
}

  /**
   * // Array inicial
   * [1, 4, 1, 2, 7, 5, 2]
   * // Maior valor 7 Então o array vai ser com 7 posições
   * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
   * // Adiciona mais um em cada índice referente ao array inicial
   *  0  1  2  3  4  5  6  7
   * [0, 2, 2, 0, 1, 1, 0, 1]
   * // Soma capara índice com o seu anteiro
   * [0,  2,    2,    0,    1,    1,    0,    1]
   *   \  |     |     |     |     |     |     |
   *    0+2=2 2+2=4 4+0=4 4+1=5 5+1=6 6+0=6 6+1=7
   *   /    |/    |/    |/    |/    |/    |/    |
   * [0,    2,    4,    4,    5,    6,    6,    7]
   * // Agora vai pegar o valor do array inicial e verificar no índice
   * // do array que esta contado, o valor que esta dentro do índice do
   * // array que esta contato menos 1 vai ser usado como índice do array
   * // de saida, aposta atribuir o valor decrementa um na posição que foi usada
   * // do array que esta contando 
   * // Resto do array de contador
   * [0, 2, 4, 4, 5, 6, 6, 7]
   * [0, 0, 2, 4, 4, 5, 6, 6]
   * // Array de saida
   * [1, 1, 2, 2, 4, 5, 7]
   */