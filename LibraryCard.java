import java.util.ArrayList;
import java.util.List;

public class LibraryCard {
    private User user;
    private List<Book> checkedOutBooks;
    private List<AudioVideoMaterial> checkedOutAV;
    private double fines;
    private Library library;
    private List<Magazines> checkedOutMagazines = new ArrayList<>();

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

    public List<Book> getCheckedOutBooks(){
        return checkedOutBooks;
    }

    public List<AudioVideoMaterial> getCheckedOutAV(){
        return checkedOutAV;
    }

    // Add a method to check out a book for the user associated with this card

    //public void checkOutBook(Book book) {
        //checkedOutBooks.add(book);
        // user.getCheckedOutBooks().add(book);
        //book.setCheckedOut(true);
        //System.out.println("Book '" + book.getTitle() + "' checked out successfully!");
    //}

    // Add a method to return a book for the user associated with this card
    //public void returnBook(Book book) {
        //checkedOutBooks.remove(book);
    //}

    // Add a method to check out an audio/video material for the user associated with this card
    //public void checkOutAV(AudioVideoMaterial avmaterial) {
        //checkedOutAV.add(avmaterial);
    //}
    public void checkOutBook(Book book, int date) {
        if (!user.getIsChild() || (user.getIsChild() && checkedOutBooks.size() <= 5)) {
            checkedOutBooks.add(book);
            Checkout.checkOutBook(book, this);

            System.out.println("In LibraryCard class: Book '" + book.getTitle() + "' checked out successfully!");
        } else {
            System.out.println("In LibraryCard class: Unable to check book out: maximum items check out reached");
        }
    }

    public void renewBook(Book book, int date){
        if(!book.isCheckedOut()){
            System.out.println("Book: '" + book.getTitle() + "' is unable to be renewed, as it is not checked out.");
        }
        else if(book.getRenewedBefore() == true) {
            System.out.println("Book: '" + book.getTitle() + "' is unable to be renewed, as it has already once been renewed.");
        }
        else if(library.itemRequestList.get(0).item.getTitle() == book.getTitle()){
            System.out.println("Book: '" + book.getTitle() + "' is unable to be renewed, as there is currently a checkout request for it.");
        }
        else{
            book.setRenewedBefore(true);
            Checkout.renewBook(book, this);
        }
    }

    // Add a method to return a book for the user associated with this card
    //public void returnBook(Book book) {
        //checkedOutBooks.remove(book);
        //library.checkRequests(book);
        //fines += library.turnBookIn(book);
    //}

    // Add a method to check out an audio/video material for the user associated with this card
    public void checkOutAV(AudioVideoMaterial avmaterial, int date) {
        if(!user.getIsChild() || (user.getIsChild() && checkedOutAV.size() <= 5)){
            checkedOutAV.add(avmaterial);
            Checkout.checkOutAV(avmaterial, this);

            System.out.println("In LibraryCard class: AV material " + avmaterial.getTitle() + " checked out successfully!");
        } else {
            System.out.println("In LibraryCard class: Unable to check AV material out: maximum items check out reached.");
        }
        // checkedOutAV.add(avmaterial);
        // avmaterial.setCheckedOut(true);

        // avmaterial.setDateCheckedOut(date);
    }

    public void renewAV(AudioVideoMaterial avMaterial, int date){
        if(!avMaterial.isCheckedOut()){
            System.out.println("AV material: '" + avMaterial.getTitle() + "' is unable to be renewed, as it is not checked out.");
        }
        else if(avMaterial.getRenewedBefore() == true) {
            System.out.println("AV material: '" + avMaterial.getTitle() + "' is unable to be renewed, as it has already once been renewed.");
        }
        else if(library.itemRequestList.get(1).item.getTitle() == avMaterial.getTitle()){
            System.out.println("AV material: '" + avMaterial.getTitle() + "' is unable to be renewed, as there is currently a checkout request for it.");
        }
        else{
            avMaterial.setRenewedBefore(true);
            Checkout.renewAV(avMaterial, this);
        }
    }

    // Add a method to return an audio/video material for the user associated with this card
    //public void returnAV(AudioVideoMaterial avmaterial) {
        //checkedOutAV.remove(avmaterial);
    //}

    //public void checkOutMagazine(Magazines magazine) {
        //checkedOutMagazines.add(magazine);
    //}

    //public void returnMagazine(Magazines magazine) {
        //checkedOutMagazines.remove(magazine);
    //}

    public void checkOutBook(Book book){
        Checkout.checkOutBook(book, this);
    }

    /*
    public void checkOutMagazine(Magazines magazine){
        Checkout.checkOutMagazine(magazine, this);
    }*/

    public void checkOutAV(AudioVideoMaterial avMaterial){
        Checkout.checkOutAV(avMaterial, this);
    }

    public void returnBook(Book book){
        Return.returnBook(book, this);
        checkedOutBooks.remove(book);
    }

    /*
    public void returnMagazine(Magazines magazine){
        Return.returnMagazine(magazine, this);
    }*/

    public void returnAV(AudioVideoMaterial avMaterial){
        Return.returnAV(avMaterial, this);
        checkedOutAV.remove(avMaterial);
    }

    public void displayCheckedout(){
        for (int i = 0; i < checkedOutAV.size(); i++){
            System.out.println(checkedOutAV.get(i).getTitle());
        }
        for (int i = 0; i < checkedOutBooks.size(); i++){
            System.out.println(checkedOutBooks.get(i).getTitle());
        }
        for (int i = 0; i < checkedOutMagazines.size(); i++){
            System.out.println(checkedOutMagazines.get(i).getTitle());
        }
        if(checkedOutAV.size() == 0 && checkedOutBooks.size() == 0){
            System.out.println("No books or AV material checked out.");
        }

    }

    // Method is called to either add or subtract fines on this LibraryCard
    public void changeFines(double amount) {
        fines += amount;
    }

    public double getFines(){
        return fines;
    }

    // Add any other methods specific to the LibraryCard class
}
