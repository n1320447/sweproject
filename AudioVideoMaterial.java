public class AudioVideoMaterial extends Item {
    private String director;
    private int dateCheckedOut;
    private double value;

    public AudioVideoMaterial(String title, String director, int publicationYear, double value) {
        super(title, publicationYear, ItemType.AUDIO_VIDEO_MATERIAL);
        this.director = director;
        this.dateCheckedOut = -1;
        this.value = value;
    }

    // Getter and setter for director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Getter and setter for dateCheckedOut
    public int getDateCheckedOut() {
        return dateCheckedOut;
    }

    public void setDateCheckedOut(int date) {
        dateCheckedOut = date;
    }

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
               ", author='" + director + '\'' +
               ", publicationYear=" + getPublicationYear() + // Use the getter method for the publication year
               ", itemType=" + getItemType() +
               ", checkedOut=" + isCheckedOut() +
               '}';
    }
    // ... (rest of the code specific to audio/video materials)
}