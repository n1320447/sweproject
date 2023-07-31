public class Magazines extends Item {
    private String editor;

    public Magazines(String title, String editor, int publicationYear) {
        super(title, publicationYear, ItemType.MAGAZINE); // remove itemType.
        this.editor = editor;
    }

    // Getter and setter for editor
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) { // Change method name from setAuthor to setEditor
        this.editor = editor;
    }

    @Override
    public boolean canBeCheckedOut() {
        return false;
    }

    @Override
    public String toString() {
        return "Magazine{" +
               "title='" + getTitle() + '\'' + // Use the getter method for the title
               ", editor='" + editor + '\'' +
               ", publicationYear=" + getPublicationYear() + // Use the getter method for the publication year
               ", itemType=" + getItemType() +
               ", checkedOut=" + isCheckedOut() +
               '}';
    }
    // ... (rest of the code specific to magazines)
}
