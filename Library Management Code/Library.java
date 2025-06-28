// Library.java
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void borrowBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.displayDetails();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String authorName) {
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().getName().equalsIgnoreCase(authorName)) {
                b.displayDetails();
                System.out.println();
                found = true;
            }
        }
        if (!found)
            System.out.println("No books found by this author.");
    }
}
