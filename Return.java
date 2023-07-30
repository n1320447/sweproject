import java.util.ArrayList;
import java.util.List;
public class Return {

    private static List<Book> checkedOutBooks = new ArrayList<>();
    private static List<Magazines> checkedOutMagazines = new ArrayList<>();
    private static List<AudioVideoMaterial> checkedOutAV = new ArrayList<>();
    private static Library library;

    public static void returnBook(Book book, LibraryCard libraryCard){
        System.out.println("outside returnbook if, checkedOutBooks contains:" + checkedOutBooks);
        double fines;
        if(checkedOutBooks.contains(book)){
            // Calculate potential fines to add to libraryCard
            fines = calcFines(book, libraryCard);
            if (fines != 0)
                libraryCard.changeFines(fines);

            checkedOutBooks.remove(book);
            Checkout.removeBook(book);
            book.setCheckedOut(false);
            book.setDateCheckedOut(-1);

            // Check if there is request out for book
            LibraryCard reloanedCard;
            reloanedCard = library.checkRequests((Item)book);
            if (reloanedCard == null) {
                System.out.println("Book: " + book.getTitle() + " has been returned successfully.");
            } else {
                // If there is a request out, recheck book out under the card that requested the book next
                reloanedCard.checkOutBook(book, library.getDay());
                System.out.println("Book: " + book.getTitle() + " has been returned successfully and has been "
                        + "rechecked out by another User because of an outstanding request.");
            }
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
            Checkout.removeAV(avMaterial);
            avMaterial.setCheckedOut(false);
            System.out.println("AV Material: " + avMaterial.getTitle() + " has been returned successfully.");
        }
        else{
            System.out.println("AV Material: " + avMaterial.getTitle() + " is not checked out.");
        }
    }

    // Method to add book to checkedOutBooks, called by Checkout to maintain records
    public static void addBook(Book book) {
        checkedOutBooks.add(book);
    }

    // Method to add AV to checkedOutAV, called by Checkout to maintain records
    public static void addAV(AudioVideoMaterial av) {
        checkedOutAV.add(av);
    }

    // Method to tell class the Library that it belongs to. Not sure how else to implement this if class is static
    public static void setLibrary(Library newLibrary) {
        library = newLibrary;
    }


    private static double calcFines(Book book, LibraryCard libraryCard) {
        double fine = 0;
        int daysLoaned = library.getDay() - book.getDateCheckedOut();
        int overdueDays = 0;

        // Calculate the flat amount due
        if (book.getBestseller() && daysLoaned > 14) {
            fine = (double) (daysLoaned - 14) * 0.1;
        } else if (daysLoaned > 21) {
            fine = (double) (daysLoaned - 21) * 0.1;
        }

        // Check if flat fine is too high for book value
        if (book.getValue() < fine)
            fine = book.getValue();

        return fine;
    }
}
