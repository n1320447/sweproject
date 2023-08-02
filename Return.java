import java.util.ArrayList;
import java.util.List;
public class Return {

    private List<Book> checkedOutBooks = new ArrayList<>();
    private List<Magazines> checkedOutMagazines = new ArrayList<>();
    private List<AudioVideoMaterial> checkedOutAV = new ArrayList<>();
    private Library library;
    private Checkout checkout;

    Return(Library library) {
        this.library = library;
    }
    public void returnBook(Book book, LibraryCard libraryCard){
        System.out.println("outside returnbook if, checkedOutBooks contains:" + checkedOutBooks);
        double fines;
        if(checkedOutBooks.contains(book)){
            // Calculate potential fines to add to libraryCard
            fines = calcFinesBook(book, libraryCard);
            if (fines != 0)
                libraryCard.changeFines(fines);

            checkedOutBooks.remove(book);
            checkout.removeBook(book);
            book.setCheckedOut(false);
            book.setDateCheckedOut(-1);

            // Check if there is request out for book
            LibraryCard reloanedCard;
            reloanedCard = library.checkRequestsOnReturn((Item)book);
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

    public void returnAV(AudioVideoMaterial avMaterial, LibraryCard libraryCard) {
        System.out.println("outside returnAV if, checkedOutAV contains:" + checkedOutAV);
        double fines;
        if(checkedOutAV.contains(avMaterial)){
            // Calculate potential fines to add to libraryCard
            fines = calcFinesAV(avMaterial, libraryCard);
            if (fines != 0)
                libraryCard.changeFines(fines);

            checkedOutAV.remove(avMaterial);
            checkout.removeAV(avMaterial);
            avMaterial.setCheckedOut(false);
            avMaterial.setDateCheckedOut(-1);

            // Check if there is request out for book
            LibraryCard reloanedCard;
            reloanedCard = library.checkRequestsOnReturn((Item)avMaterial);
            if (reloanedCard == null) {
                System.out.println("AudioVisualMaterial: " + avMaterial.getTitle() + " has been returned successfully.");
            } else {
                // If there is a request out, recheck book out under the card that requested the book next
                reloanedCard.checkOutAV(avMaterial, library.getDay());
                System.out.println("AudioVisualMaterial: " + avMaterial.getTitle() + " has been returned successfully and has been "
                        + "rechecked out by another User because of an outstanding request.");
            }
        }
        else{
            System.out.println("Book: " + avMaterial.getTitle() + " is not checked out.");
        }

    }

    // Method to add book to checkedOutBooks, called by Checkout to maintain records
    public void addBook(Book book) {
        checkedOutBooks.add(book);
    }

    // Method to add AV to checkedOutAV, called by Checkout to maintain records
    public void addAV(AudioVideoMaterial av) {
        checkedOutAV.add(av);
    }

    private double calcFinesBook(Book book, LibraryCard libraryCard) {
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

    private double calcFinesAV(AudioVideoMaterial avMaterial, LibraryCard libraryCard) {
        double fine = 0;
        int daysLoaned = library.getDay() - avMaterial.getDateCheckedOut();
        int overdueDays = 0;

        // Calculate the flat amount due
        if (daysLoaned > 14) {
            fine = (double) (daysLoaned - 14) * 0.1;
        }

        // Check if flat fine is too high for book value
        if (avMaterial.getValue() < fine)
            fine = avMaterial.getValue();

        return fine;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public Checkout getCheckout() {
        return checkout;
    }
}
