class DataRandom {
  private static int[] sum = new int[4];

  public static void main(String[] args) {
    int index = 0;
    while (index < 3) {
      sum[index] = numberRandom(6, 1);
      sum[3] += sum[index];
      index++;
    }
    System.out.println("Total dos valores dos dados => " + sum[3]);
    index = 0;
    while (index < 3) {
      System.out.println("Valor da " + index + "º jogada " + sum[index]);
      index++;
    }
  }

  private static int numberRandom(int max, int min) {
    return (int) Math.round(Math.random() * (max - min) + min);
  }
}