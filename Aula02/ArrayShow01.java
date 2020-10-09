package Aula6;

public class ArrayShow01 {
    public static void main(String[] args) {
        int[] datas = { 3, 4, 1, 6 };
        String together = "";
        for (int i = 0; i < datas.length; i++) {
            if (datas.length == (i + 1)) {
                together = together + datas[i];
            } else {
                together = together + datas[i] + " ,";
            }
        } 
        System.out.print(together);
    }
}