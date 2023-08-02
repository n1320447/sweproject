import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book extends Item {
    private String author;
    private int dateCheckedOut;
    private boolean bestseller;
    private double value;
    private LocalDate startDate;
    private LocalDate dueDate;

    public Book(String title, String author, int publicationYear, boolean bestseller, double value) {
        super(title, publicationYear,ItemType.BOOK);
        this.author = author;
        this.dateCheckedOut = -1;
        this.bestseller = bestseller;
        this.value = value;
        this.startDate = null;
        this.dueDate = null;
        
    }

    // Getter and setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and setter for dateCheckedOut
    public int getDateCheckedOut() {
        return dateCheckedOut;
    }

    public void setDateCheckedOut(int date) {
        dateCheckedOut = date;
    }

    // Getter and setter for bestseller
    public boolean getBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean newBestseller) {
        bestseller = newBestseller;
    }

    // Getter and setter for book value
    public double getValue() {
        return value;
    }

    public void setValue(double newVal) {
        value = newVal;
    }

    public void setStartDate(){
        startDate = LocalDate.now();
        System.out.println("startDate set to: " + startDate);
    }

    public void setDueDate(){
        if(super.getItemType() == ItemType.BOOK){
            dueDate = startDate.plusDays(21);
            System.out.println("DueDate set to: " + dueDate);
            
            
        }
        if(super.getItemType() == ItemType.AUDIO_VIDEO_MATERIAL){
            dueDate = startDate.plusDays(14);
        }
        if(bestseller == true){
            dueDate = dueDate.minusDays(7);
        }
    }


    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + getTitle() + '\'' + // Use the getter method for the title
               ", author='" + author + '\'' +
               ", publicationYear=" + getPublicationYear() + // Use the getter method for the publication year
               ", itemType=" + getItemType() +
               ", checkedOut=" + isCheckedOut() +
               '}';
    }
}
