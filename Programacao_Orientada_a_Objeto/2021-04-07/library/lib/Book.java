class Book {
    private static int ID;
    int id;

    String name;
    String author;
    int numberPages;
    double price;

    Book(String name, String author, int numberPages, double price) {
        this.id = ++ID;
        this.name = name;
        this.author = author;
        this.numberPages = numberPages;
        this.price = price;
    }
}