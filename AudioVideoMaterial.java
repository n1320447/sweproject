import java.time.LocalDate;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AudioVideoMaterial extends Item {
    private String director;
    private int dateCheckedOut;
    private double value;
    private LocalDate startDate;
    private LocalDate dueDate;

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
        // if(bestseller == true){
        //     dueDate = startDate.minusDays(7);
        // }
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
               ", author='" + director + '\'' +
               ", publicationYear=" + getPublicationYear() + // Use the getter method for the publication year
               ", itemType=" + getItemType() +
               ", checkedOut=" + isCheckedOut() +
               '}';
    }
    // ... (rest of the code specific to audio/video materials)
}