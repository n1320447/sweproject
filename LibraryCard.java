import java.util.ArrayList;
import java.util.List;

public class LibraryCard {
    private User user;
    private List<Book> checkedOutBooks;
    private List<AudioVideoMaterial> checkedOutAV;
    private List<Magazines> checkedOutMagazines = new ArrayList<>();

    public LibraryCard(User user) {
        this.user = user;
        checkedOutBooks = new ArrayList<>();
        checkedOutAV = new ArrayList<>();
    }

    // Getters and setters for the user attribute (optional, if needed)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Add a method to check out a book for the user associated with this card
    public void checkOutBook(Book book) {
        checkedOutBooks.add(book);
    }

    // Add a method to return a book for the user associated with this card
    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
    }

    // Add a method to check out an audio/video material for the user associated with this card
    public void checkOutAV(AudioVideoMaterial avmaterial) {
        checkedOutAV.add(avmaterial);
    }

    // Add a method to return an audio/video material for the user associated with this card
    public void returnAV(AudioVideoMaterial avmaterial) {
        checkedOutAV.remove(avmaterial);
    }

    public void checkOutMagazine(Magazines magazine) {
        checkedOutMagazines.add(magazine);
    }

    public void returnMagazine(Magazines magazine) {
        checkedOutMagazines.remove(magazine);
    }


    // Add any other methods specific to the LibraryCard class
}
