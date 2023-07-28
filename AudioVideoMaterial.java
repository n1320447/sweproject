public class AudioVideoMaterial extends Item {
    private String director;
    private int dateCheckedOut;

    public AudioVideoMaterial(String title, String director, int publicationYear) {
        super(title, publicationYear, ItemType.AUDIO_VIDEO_MATERIAL);
        this.director = director;
        this.dateCheckedOut = -1;
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


    // ... (rest of the code specific to audio/video materials)
}