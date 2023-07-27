public class Book extends Item {
    private String author;

    public Book(String title, String author, int publicationYear) {
        super(title, publicationYear, ItemType.BOOK);
        this.author = author;
    }

    // Getter and setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
