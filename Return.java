import java.util.ArrayList;
import java.util.List;
public class Return {

    private static List<Book> checkedOutBooks = new ArrayList<>();
    private static List<Magazines> checkedOutMagazines = new ArrayList<>();
    private static List<AudioVideoMaterial> checkedOutAV = new ArrayList<>();
    public static void returnBook(Book book, LibraryCard libraryCard){
        System.out.println("outside returnbook if, checkedOutBooks contains:" + checkedOutBooks);
        if(checkedOutBooks.contains(book)){
            checkedOutBooks.remove(book);
            book.setCheckedOut(false);
            System.out.println("Book: " + book.getTitle() + " has been returned successfully.");
        }
        else{
            System.out.println("Book: " + book.getTitle() + " is not checked out.");
        }
    }

    public static void returnMagazine(Magazines magazine, LibraryCard libraryCard){
        if(checkedOutMagazines.contains(magazine)){
            checkedOutMagazines.remove(magazine);
            magazine.setCheckedOut(false);
            System.out.println("Magazine: " + magazine.getTitle() + " has been returned successfully.");
        }
        else{
            System.out.println("Magazine: " + magazine.getTitle() + " is not checked out.");
        }
    }

    public static void returnAV(AudioVideoMaterial avMaterial, LibraryCard libraryCard){
        if(checkedOutAV.contains(avMaterial)){
            checkedOutAV.remove(avMaterial);
            avMaterial.setCheckedOut(false);
            System.out.println("AV Material: " + avMaterial.getTitle() + " has been returned successfully.");
        }
        else{
            System.out.println("AV Material: " + avMaterial.getTitle() + " is not checked out.");
        }
    }
}
