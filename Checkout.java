import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private static List<Book> checkedOutBooks = new ArrayList<>();
    private static List<Magazines> checkedOutMagazines = new ArrayList<>();
    private static List<AudioVideoMaterial> checkedOutAV = new ArrayList<>();
    public static void checkOutBook(Book book, LibraryCard libraryCard){
        if(!book.isCheckedOut()){
            checkedOutBooks.add(book);
            book.setCheckedOut(true);
            System.out.println("Book: " + book.getTitle() + " checked out successfully.");
        }
        else{
            System.out.println("Book: " + book.getTitle() + " is already checked out.");
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
}
