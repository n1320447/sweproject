import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private static List<Book> checkedOutBooks = new ArrayList<>();
    private static List<Magazines> checkedOutMagazines = new ArrayList<>();
    private static List<AudioVideoMaterial> checkedOutAV = new ArrayList<>();
    private static Library library;
    public static void checkOutBook(Book book, LibraryCard libraryCard){
        if(!book.isCheckedOut()){
            checkedOutBooks.add(book);
            Return.addBook(book);
            book.setCheckedOut(true);
            book.setDateCheckedOut(library.getDay());
            System.out.println("In Checkout class: Book: " + book.getTitle() + " checked out successfully.");
        }
        else{
            System.out.println("In Checkout class: Book: " + book.getTitle() + " is already checked out.");
        }
    }

    public static void checkOutMagazine(Magazines magazine, LibraryCard libraryCard){
        if(!magazine.isCheckedOut()){
            checkedOutMagazines.add(magazine);
            magazine.setCheckedOut(true);
            System.out.println("Book: " + magazine.getTitle() + " checked out successfully.");
        }
        else{
            System.out.println("Book: " + magazine.getTitle() + " is already checked out.");
        }
    }

    public static void checkOutAV(AudioVideoMaterial avMaterial, LibraryCard libraryCard){
        if(!avMaterial.isCheckedOut()){
            checkedOutAV.add(avMaterial);
            Return.addAV(avMaterial);
            avMaterial.setCheckedOut(true);
            System.out.println("AV material: " + avMaterial.getTitle() + " checked out successfully.");
        }
        else{
            System.out.println("AV material: " + avMaterial.getTitle() + " is already checked out.");
        }
    }

    public static boolean anyItemCheckedOut(){
        return checkedOutAV.isEmpty() || checkedOutBooks.isEmpty() || checkedOutMagazines.isEmpty();
    }

    // Method to remove book from arrayList, called by Return to maintain records
    public static void removeBook(Book book) {
        checkedOutBooks.remove(book);
    }

    // Method to remove AV from arrayList, called by Return to maintain records
    public static void removeAV(AudioVideoMaterial av) {
        checkedOutAV.remove(av);
    }

    public static void setLibrary(Library newLibrary) {
        library = newLibrary;
    }
}
