import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private List<Book> checkedOutBooks = new ArrayList<>();
    private List<Magazines> checkedOutMagazines = new ArrayList<>();
    private List<AudioVideoMaterial> checkedOutAV = new ArrayList<>();
    private Library library;
    private Return returnClass;

    Checkout(Library library) {
        this.library = library;
    }
    public void checkOutBook(Book book, LibraryCard libraryCard){
        if(!book.isCheckedOut()){
            checkedOutBooks.add(book);
            returnClass.addBook(book);
            book.setCheckedOut(true);
            book.setDateCheckedOut(library.getDay());
            System.out.println("In Checkout class: Book: " + book.getTitle() + " checked out successfully.");
        }
        else{
            System.out.println("In Checkout class: Book: " + book.getTitle() + " is already checked out.");
        }
    }

    /* Cannot checkout/return magazines
    public static void checkOutMagazine(Magazines magazine, LibraryCard libraryCard){
        if(!magazine.isCheckedOut()){
            checkedOutMagazines.add(magazine);
            magazine.setCheckedOut(true);
            System.out.println("Book: " + magazine.getTitle() + " checked out successfully.");
        }
        else{
            System.out.println("Book: " + magazine.getTitle() + " is already checked out.");
        }
    }*/

    public void checkOutAV(AudioVideoMaterial avMaterial, LibraryCard libraryCard){
        if(!avMaterial.isCheckedOut()){
            checkedOutAV.add(avMaterial);
            returnClass.addAV(avMaterial);
            avMaterial.setCheckedOut(true);
            avMaterial.setDateCheckedOut(library.getDay());
            System.out.println("AV material: " + avMaterial.getTitle() + " checked out successfully.");
        }
        else{
            System.out.println("AV material: " + avMaterial.getTitle() + " is already checked out.");
        }
    }

    public boolean anyItemCheckedOut(){
        return checkedOutAV.isEmpty() || checkedOutBooks.isEmpty() || checkedOutMagazines.isEmpty();
    }

    // Method to remove book from arrayList, called by Return to maintain records
    public void removeBook(Book book) {
        checkedOutBooks.remove(book);
    }

    // Method to remove AV from arrayList, called by Return to maintain records
    public void removeAV(AudioVideoMaterial av) {
        checkedOutAV.remove(av);
    }

    public void renewBook(Book book, LibraryCard libraryCard){
        book.setCheckedOut(true);
        book.setDateCheckedOut(library.getDay());
        System.out.println("Book: '" + book.getTitle() + "' has been renewed successfully!");
    }
    public void renewAV(AudioVideoMaterial avMaterial, LibraryCard libraryCard){
        avMaterial.setCheckedOut(true);
        avMaterial.setDateCheckedOut(library.getDay());
        System.out.println("AV Material: '" + avMaterial.getTitle() + "' has been renewed successfully!");
    }

    public void setReturnClass(Return returnClass) {
        this.returnClass = returnClass;
    }
    public Return getReturnClass() {
        return returnClass;
    }
}
