import java.util.ArrayList;
import java.util.List;

public class User extends Account {
    private String firstName;
    private String lastName;
    private List<Book> checkedOutBooks;
    private List<Magazines> checkedOutMagazines;
     private List<AudioVideoMaterial> checkedOutAV;
    private LibraryCard libraryCard;
    private Library library;
    private boolean isChild;
    private String address;
    private int libraryCardNum;
    private String phoneNum;

    public User(String username, String password, String email, String firstName, String lastName, int age,Library library, String address, String phoneNum) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.libraryCard = new LibraryCard(this, library);
        if (age > 12)
            isChild = false;
        else
            isChild = true;
        this.library = library;
        this.libraryCardNum = libraryCard.hashCode();

        // checkedOutBooks = new ArrayList<>();
        // checkedOutAV = new ArrayList<>();
        
    }

    // Getters and setters for the attributes specific to User
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

    public List<Magazines> getCheckedOutMagazines(){ return checkedOutMagazines;}
    public List<AudioVideoMaterial> getCheckedOutAV(){ return checkedOutAV;}

    public LibraryCard getLibraryCard(){
        return libraryCard;
    }

    public boolean getIsChild() {
        return isChild;
    }

    public int getLibCardNum(){
        return libraryCardNum;
    }

    public String getAddress(){
        return address;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    // public void setCheckedOutBooks(List<Book> checkedOutBooks) {
    //     this.checkedOutBooks = checkedOutBooks;
    // }

        // Add a method to check out a book for this user
        // public void checkOutBook(Book book) {
        //     checkedOutBooks.add(book);
        // }
    
        // Add a method to return a book for this user
        // public void returnBook(Book book) {
        //     checkedOutBooks.remove(book);
        // }

        // public List<AudioVideoMaterial> getCheckedOutAV() {
        //     return checkedOutAV;
        // }
    
        // public void setCheckedOutAV(List<AudioVideoMaterial> checkedOutAV) {
        //     this.checkedOutAV = checkedOutAV;
        // }
    
            // Add a method to check out a av material for this user
            // public void checkOutAV(AudioVideoMaterial avmaterial) {
            //     checkedOutAV.add(avmaterial);
            // }
        
            // Add a method to return av material for this user
            // public void returnAV(AudioVideoMaterial avmaterial) {
            //     checkedOutAV.remove(avmaterial);
            // }
    
            @Override
            public String toString() {
                return "User{" +
                       "firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", username='" + getUsername() + '\'' +
                       ", email='" + getEmail() + '\'' +
                       ", address ='" + getAddress() + '\'' +
                       ", library Card Number='" + getLibCardNum() + '\'' +
                       '}';
            }
    // Add any other methods specific to User
}