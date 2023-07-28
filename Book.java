public class Book extends Item {
    private String author;
    private int dateCheckedOut;
    private boolean bestseller;
    private double value;

    public Book(String title, String author, int publicationYear, boolean bestseller, double value) {
        super(title, publicationYear,ItemType.BOOK);
        this.author = author;
        this.dateCheckedOut = -1;
        this.bestseller = bestseller;
        this.value = value;
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
    // ... (rest of the code specific to books)
}
