import List.List;

class Main {
    public static void main(String[] args) {
        List<Dog> listDog = new List<>(true);
        List<Cat> listCat = new List<>(true);

        // ADICIONAR GATOS
        Cat cat_1 = new Cat("1:Urubu");
        Cat cat_2 = new Cat("2:Gata");
        Cat cat_0 = new Cat("0:Roberto");
        Cat cat_3 = new Cat("3:Alfredo");

        listCat.add(cat_1);
        listCat.add(cat_2);
        listCat.add(0, cat_0);
        listCat.add(cat_3);

        // ADICIONAR CACHORROS
        Dog dog_0 = new Dog("0:Tobias");
        Dog dog_2 = new Dog("2:Carlos");
        Dog dog_1 = new Dog("1:Zoio");
        Dog dog_3 = new Dog("3:Sansão");

        listDog.add(dog_0);
        listDog.add(dog_2);
        listDog.add(1, dog_1);
        listDog.add(dog_3);

        System.out.println("[METHOD] list");
        listCat.list();
        listDog.list();

        // SEPARADOR
        System.out.println("\n[METHOD] remove");

        // BUSCAR POR ÍNDICE
        System.out.println("Gato removido Alfredo: " + listCat.get(3));
        System.out.println("Dog removido Carlos: " + listDog.get(2) + "\n");
        // REMOVER
        listCat.remove(listCat.indexOf(cat_3));
        listDog.remove(2);

        System.out.println(listCat);
        System.out.println(listDog);

        // SEPARADOR
        System.out.println("\n[METHOD] indexOf");

        // BUSCAR ÍNDICE
        System.out.println("Gato Urubu: " + listCat.indexOf(cat_1));
        System.out.println("Cachorro Alfredo: " + listDog.indexOf(dog_2));

        // SEPARADOR
        System.out.println("\n[METHOD] get");

        // BUSCAR POR ÍNDICE
        System.out.println("Gato Urubu: " + listCat.get(1));
        System.out.println("Dog null: " + listDog.get(3));

        // SEPARADOR
        System.out.println("\n[METHOD] size");

        // BUSCAR POR ÍNDICE
        System.out.println("Gato: " + listCat.size());
        System.out.println("Dog: " + listDog.size());

        // SEPARADOR
        System.out.println("\n[METHOD] isEmpty / clear");

        // LIMPAR LISTA
        listDog.clear();

        // BUSCAR POR ÍNDICE
        System.out.println("Gato: " + listCat.isEmpty());
        System.out.println("Dog: " + listDog.isEmpty());

        // System.out.println("Tamanho: " + list.size());

        // result = list.remove(0);
        // System.out.println("Removido: " + result);

        // System.out.println("Tamanho: " + list.size());

        // Dog dog = new Dog("Marquinos");

        // result = list.add(3, new Dog("Tobias"));
        // System.out.println("Adicionado: " + result);

        // result = list.add(new Dog("Carro"));
        // System.out.println("Adicionado: " + result);

        // result = list.add(new Dog("Avião"));
        // System.out.println("Adicionado: " + result);

        // System.out.println(list);

        // index = list.indexOf(dog);

        // result = list.add(-1, dog);
        // System.out.println("Adicionado: " + result);
        // result = list.add(4, dog);
        // System.out.println("Adicionado: " + result);
        // result = list.add(2, dog);
        // System.out.println("Adicionado: " + result);

        // System.out.println("Indice: " + index);
        // index = list.indexOf(dog);
        // System.out.println("Indice: " + index);

        // result = list.remove(dog);
        // System.out.println("Removido: " + result);

        // result = list.remove(0);
        // System.out.println("Removido: " + result);
        // result = list.remove(-1);
        // System.out.println("Removido: " + result);

        // result = list.get(2);
        // System.out.println("Pego: " + result);

        // result = list.get(0);
        // System.out.println("Pego: " + result);

        // System.out.println("Tamanho: " + list.size());

        // System.out.println("Vazio: " + list.isEmpty());
        // list.list();
        // list.clear();
        // System.out.println("Vazio: " + list.isEmpty());
        // System.out.println(list);
    }
}