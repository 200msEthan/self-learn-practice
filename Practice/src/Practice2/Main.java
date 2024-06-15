package Practice2;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Title 1", "Author A"));
        library.addBook(new Book("Title 2", "Author B"));
        library.addBook(new Book("Title 3", "Author C"));

        library.registerUser(new User("John"));
        library.registerUser(new User("Laura"));

        library.borrowBook(1, "Title 1");

        library.libraryStatus();

        library.borrowBook(2, "Title 3");
        library.returnBook(1, "Title 1");
        library.libraryStatus();

    }
}