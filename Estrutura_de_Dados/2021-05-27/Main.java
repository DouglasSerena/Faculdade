import List.List;

class Main {
    public static void main(String[] args) {
        List<Dog> list = new List<>(true);
        int index = 0;
        Dog result;

        Dog dog = new Dog("Marquinos");

        list.add(new Dog("Tobias"));
        list.add(new Dog("Carro"));
        list.add(new Dog("Avião"));
        System.out.println(list);

        index = list.indexOf(dog);

        result = list.add(-1, dog);
        System.out.println("Adicionado: " + result);
        result = list.add(4, dog);
        System.out.println("Adicionado: " + result);
        result = list.add(2, dog);
        System.out.println("Adicionado: " + result);

        System.out.println("Indice: " + index);
        index = list.indexOf(dog);
        System.out.println("Indice: " + index);

        result = list.remove(dog);
        System.out.println("Removido: " + result);

        result = list.remove(0);
        System.out.println("Removido: " + result);
        result = list.remove(-1);
        System.out.println("Removido: " + result);

        result = list.get(2);
        System.out.println("Pego: " + result);

        result = list.get(0);
        System.out.println("Pego: " + result);

        System.out.println("Tamanho: " + list.size());

        System.out.println("Vazio: " + list.isEmpty());
        list.list();
        list.clear();
        System.out.println("Vazio: " + list.isEmpty());
        System.out.println(list);
    }
}