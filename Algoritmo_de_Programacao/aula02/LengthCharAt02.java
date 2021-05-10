package Aula6;

public class LengthCharAt02 {
    public static void main(String[] args) {
        String like = "I like Java";
        System.out.println("Length: " + like.length());
        for (int i = 0; i < like.length(); i++) {
            System.out.print("\"" + like.charAt(i) + "\" - ");
        }
    }
}