package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    // Phu 20215116: Modified in lab 04
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
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