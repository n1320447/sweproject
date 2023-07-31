public class ReferenceBooks extends Item {
    private String author;

    public ReferenceBooks(String title, String author, int publicationYear) {
        super(title, publicationYear, ItemType.REFERENCE_BOOK);
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
    public boolean canBeCheckedOut() {
        return false;
    }

    @Override
    public String toString() {
        return "ReferenceBook{" +
               "title='" + getTitle() + '\'' +
               ", author='" + author + '\'' +
               ", publicationYear=" + getPublicationYear() +
               ", itemType=" + getItemType() +
               ", checkedOut=" + isCheckedOut() +
               '}';
    }
    // ... (rest of the code specific to reference books)
}
