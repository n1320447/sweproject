public class Item {
    private String title;
    private String author;
    private String editor;
    private int publicationYear;
    private boolean checkedOut;
    private boolean renewed;
    private int dateCheckedOut;
    private ItemType itemType;

    public enum ItemType {
        BOOK,
        AUDIO_VIDEO_MATERIAL,
        MAGAZINE
    }

    public Item(String title, int publicationYear, ItemType itemType) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.itemType = itemType;
        this.checkedOut = false; // By default, the item is not checked out.
    }

    // Getters and setters for the attributes

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor(){
        return editor;
    }

    public void setEditor(){
        this.editor = editor;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    // Getter and setter for dateCheckedOut
    public int getDateCheckedOut() {
        return dateCheckedOut;
    }

    public void setDateCheckedOut(int date) {
        dateCheckedOut = date;
    }

    public void setRenewedBefore(boolean renewedBefore){this.renewed = renewedBefore;}
    public boolean getRenewedBefore(){return this.renewed;}

    // Add any other common methods here

    // Method to display item details (can be overridden by subclasses)
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Item Type: " + itemType);
        System.out.println("Status: " + (checkedOut ? "Checked Out" : "Available"));
    }
}
