// Author.java
public class Author {
    private String name;
    private int numberOfBooksWritten;

    public Author(String name, int numberOfBooksWritten) {
        this.name = name;
        this.numberOfBooksWritten = numberOfBooksWritten;
    }

    public String getName() {
        return name;
    }

    public void displayBio() {
        System.out.println("Author: " + name);
        System.out.println("Books Written: " + numberOfBooksWritten);
    }
}
