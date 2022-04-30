package src;

public class Vector {
    public static int count;
    int[] vector;

    public Vector(int size) {
        this.vector = new int[size];
    }

    public void show() {
        for (int index = 0; index < this.vector.length - 1; index++) {
            System.out.println(this.vector[index]);
        }
    }

    public void showFull() {
        if (count > 0) {
            for (int index = 0; index < count; index++) {
                System.out.println(this.vector[index]);
            }
        } else {
            System.out.println("vetor vazio");
        }
    }

    public void addEnd(int value) {
        if (isFull()) {
            System.out.println("vetor cheio");
        } else {
            this.vector[count] = value;
            count++;
        }
    }

    public void addStart(int value) {
        if (isFull()) {
            System.out.println("Vetor cheio");
        } else {
            for (int index = count; index >= 0; index--) {
                this.vector[index + 1] = this.vector[index];
            }
            this.vector[0] = value;
            count++;
        }
    }

    public void removeEnd() {
        if (isEmpty()) {
            System.out.println("Vetor vazio, não é possivel remover ");
        } else {
            this.vector[count - 1] = 0;
            count--;
        }
    }

    public void removeStart() {
        if (isEmpty()) {
            System.out.println("Vetor vazio, não é possivel remover ");
        } else {
            for (int index = 0; index < count; index++) {
                this.vector[index] = this.vector[index + 1];
            }
            this.vector[count - 1] = 0;
            count--;
        }
    }

    private boolean isFull() {
        return count >= this.vector.length;
    }

    private boolean isEmpty() {
        return count == 0;
    }
}
