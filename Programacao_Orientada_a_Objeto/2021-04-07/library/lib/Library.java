import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void list() {
        if (books.size() > 0) {
            books.forEach(book -> {
                System.out.printf(
                    "(CODE: %d) Livro: %s - %s, %dPag. R$ %.2f\n",
                    book.id,
                    book.name,
                    book.author,
                    book.numberPages,
                    book.price
                );
            });
        } else {
            System.out.println(
                "Não contem livros na biblioteca."
            );
        }
    }

    public int exist(int id) {
        for (int index = 0; index < books.size(); index++) {
            if (books.get(index).id == id) {
                return index;
            }
        }
        return -1;
    }

    public void add(Book newBook) {
        books.add(newBook);
    }

    public boolean remove(int id) {
        int index = exist(id);
        if(index != -1) {
            books.remove(index);
            return true;
        } else {
            System.out.println("Livro não existe.");
        }
        return false;
    }
}