class Teste {
  String name;

  Teste(String name) {
    this.name = name;
  }
}

class Main {

  public static void main(String[] args) {
    Teste obj = new Teste("Nome");
    Class cls = obj.getClass();
    System.out.println(cls.getName());
  }
}