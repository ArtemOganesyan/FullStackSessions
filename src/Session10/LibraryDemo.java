package Session10;

import java.util.List;

public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Test Book");
        library.displayBooks();

        List<String> lib = library.getBooks();
        lib.add("New book");
        lib.add("");
        library.displayBooks();
    }
}
