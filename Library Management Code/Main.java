// Main.java
public class Main {
    public static void main(String[] args) {
        Author a1 = new Author("J.K. Rowling", 7);
        Author a2 = new Author("George Orwell", 5);

        Book b1 = new Book("Harry Potter", a1, 1997);
        Book b2 = new Book("1984", a2, 1949);

        Library library = new Library();

        // Operations
        library.addBook(b1); // 1. Add book
        library.addBook(b2); // 2. Add another

        library.borrowBook("Harry Potter"); // 3. Borrow book

        library.searchByTitle("Harry Potter"); // 4. Search by title

        library.returnBook("Harry Potter"); // 5. Return book

        library.searchByAuthor("George Orwell"); // 6. Search by author
    }
}
