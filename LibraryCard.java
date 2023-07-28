import java.util.ArrayList;
import java.util.List;

public class LibraryCard {
    private User user;
    private List<Book> checkedOutBooks;
    private List<AudioVideoMaterial> checkedOutAV;
    private double fines;
    private Library library;

    public LibraryCard(User user, Library library) {
        this.user = user;
        checkedOutBooks = new ArrayList<>();
        checkedOutAV = new ArrayList<>();
        fines = 0;
        this.library = library;
    }

    // Getters and setters for the user attribute (optional, if needed)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Add a method to check out a book for the user associated with this card
    public void checkOutBook(Book book, int date) {
        checkedOutBooks.add(book);
        // user.getCheckedOutBooks().add(book);
        book.setCheckedOut(true);

        book.setDateCheckedOut(date);

        System.out.println("Book '" + book.getTitle() + "' checked out successfully!");
    }

    // Add a method to return a book for the user associated with this card
    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
        //library.checkRequests(book);
        fines += library.turnBookIn(book);
    }

    // Add a method to check out an audio/video material for the user associated with this card
    public void checkOutAV(AudioVideoMaterial avmaterial, int date) {
        checkedOutAV.add(avmaterial);
        avmaterial.setCheckedOut(true);

        avmaterial.setDateCheckedOut(date);
    }

    // Add a method to return an audio/video material for the user associated with this card
    public void returnAV(AudioVideoMaterial avmaterial) {
        checkedOutAV.remove(avmaterial);
    }

    // Add any other methods specific to the LibraryCard class
}
