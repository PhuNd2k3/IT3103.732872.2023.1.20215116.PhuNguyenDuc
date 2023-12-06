package hust.soict.dsai.aims.media;

public class Track implements Playable {
    // Phu 20215116
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Phu 20215116: Getter methods for title and length
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {

        // Nguyen Duc Phu 20215116: Override equals method
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /*
         * Nguyen Duc Phu 20215116: Check if o is an instance of Track or not
         * "null instanceof [type]" also returns false
         */
        if (!(o instanceof Track)) {
            return false;
        }
        Track track = (Track) o;

        // Nguyen Duc Phu 20215116: Compare the data members and return accordingly
        return title.equals(track.title) && length == track.length;
    }

    @Override
    public String toString() {
        return "Track - " + title + " - " + "Length: " + length;
    }
}
