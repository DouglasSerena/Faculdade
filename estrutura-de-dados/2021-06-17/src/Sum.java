
public class Sum {
    public static void main(String[] args) throws Exception {
        int[] listNumber = new int[] { 10, 5, 17, 2, 4, 2000, 53, 12, 13, 12 };

        int result = sum(listNumber);
        System.out.println(result);
    }

    static int sum(int[] listNumber) {
        return sum(listNumber, 0, 0);
    }

    static int sum(int[] listNumber, int value, int index) {
        if (index < listNumber.length) {
            value += listNumber[index];
            index++;
            return sum(listNumber, value, index);
        }
        return value;
    }
}
