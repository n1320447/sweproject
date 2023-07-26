public class AudioVideoMaterial extends Item {
    private String director;

    public AudioVideoMaterial(String title, String director, int publicationYear) {
        super(title, publicationYear, ItemType.AUDIO_VIDEO_MATERIAL);
        this.director = director;
    }

    // Getter and setter for director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // ... (rest of the code specific to audio/video materials)
}