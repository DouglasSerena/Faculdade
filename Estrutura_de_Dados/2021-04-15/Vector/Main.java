import src.Vector;

class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(10);
        vector.addEnd(4);
        vector.addEnd(3);
        vector.addStart(2);
        vector.addStart(1);
        vector.removeEnd();
        vector.removeStart();

        System.out.println("------------");
        vector.show();
        System.out.println("------------");
        vector.showFull();
    }
}