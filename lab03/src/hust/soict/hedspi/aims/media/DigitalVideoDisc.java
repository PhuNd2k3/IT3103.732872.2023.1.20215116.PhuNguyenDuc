package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    // Phu 20215116: Modified in lab 04
    public DigitalVideoDisc() {

    }

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    public boolean equals(DigitalVideoDisc disc1) {
        if (disc1 == null || this == null)
            return false;
        if (!disc1.getTitle().equals(super.getTitle()))
            return false;
        return true;
    }

    public boolean isMatch(String title) {
        if (super.getTitle().equals(title)) {
            return true;
        }
        return false;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + super.toString();
    }
}