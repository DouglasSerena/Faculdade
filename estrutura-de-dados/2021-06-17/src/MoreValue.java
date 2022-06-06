public class MoreValue {
    public static void main(String[] args) throws Exception {
        int[] listNumber = new int[] { 10, 5, 17, 2, 4, 2000, 53, 12, 13, 12 };

        int result = search(listNumber);
        System.out.println(result);
    }

    static int search(int[] listNumber) {
        return search(listNumber, 0, 0);
    }

    static int search(int[] listNumber, int more, int index) {
        if (index < listNumber.length) {
            if (listNumber[index] > more) {
                more = listNumber[index];
            }
            index++;
            return search(listNumber, more, index);
        }
        return more;
    }
}
