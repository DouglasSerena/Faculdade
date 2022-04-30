import Source.*;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("> Programa sendo inciado...\n");

    Queue queue = new Queue(10);

    queue.add("DOUGLAS");
    queue.add("SERENA");
    queue.add("-------");
    queue.add("+++++++");
    Console.log(queue.locate("dOuGlAs") + "\n");
    queue.add("???????");
    queue.remove();
    Console.log(queue.toString() + "\n");
    queue.destroy();
    Console.log(queue.toString() + "\n");
    queue.add("1");
    Console.log(queue.toString() + "\n");
    queue.setSize(2);
    queue.add("2");
    queue.add("3");
    queue.add("4");
    Console.log(queue.toString() + "\n");

    System.out.println("\n> Programa encerrado.");
  }
}