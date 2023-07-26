import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private List<Book> checkedOutBooks;

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        checkedOutBooks = new ArrayList<>();
        System.out.println("Account created for " + firstName + " " + lastName);
    }

    // Getters and setters for the instance variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    // Add a method to check out a book for this user
    public void checkOutBook(Book book) {
        checkedOutBooks.add(book);
    }

    // Add a method to return a book for this user
    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
    }
}
