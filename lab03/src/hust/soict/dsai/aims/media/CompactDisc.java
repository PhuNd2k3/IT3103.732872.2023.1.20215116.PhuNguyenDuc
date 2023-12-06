package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

	// Phu 20215116 lab04
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();

	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
	}

	// Phu 20215116: Getter method for artist
	public String getArtist() {
		return artist;
	}

	// Phu 20215116: add and remove track method
	public void addTrack(Track track) {
		int index = tracks.indexOf(track); // If there is no track, index will be -1
		if (index != -1) {
			System.out.println("Already has track " + track.getTitle());
		} else
			tracks.add(track);
	}

	public void removeTrack(Track track) {
		int index = tracks.indexOf(track);
		if (index != -1) {
			tracks.remove(track);
		} else
			System.out.println("Track " + track.getTitle() + " not found");
	}

	// Phu 20215116: getLength()
	public int getLength() {
		int compactDiscLength = 0;
		for (Track track : tracks) {
			compactDiscLength += track.getLength();
		}
		return compactDiscLength;
	}

	@Override
	public void play() {
		System.out.println("Playing compact disc of artist: " + this.artist);
		System.out.println("Compact disc length: " + this.getLength());
		for (Track track : tracks) {
			track.play();
		}
	}

}