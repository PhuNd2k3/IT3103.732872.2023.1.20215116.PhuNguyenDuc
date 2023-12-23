package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import hust.soict.hedspi.aims.exception.PlayerException;


public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc() {
		super();
	}

	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String artist, float cost) {
		this(title, category, cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist, String director, float cost) {
		this(title, category, artist, cost);
		this.director = director;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track already exists.");
		} else {
			tracks.add(track);
			System.out.println("Added track " + track.getTitle() + " to CD.");
		}
	}

	public void removeTrack(Track track) {
		if (tracks.remove(track)) {
			System.out.println("Removed track " + track.getTitle() + " from CD.");
		} else {
			System.out.println("Track doesn't exists.");
		}
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public int getLength() {
		int length = 0;
		for (Track t : tracks) {
			length += t.getLength();
		}
		this.length = length;
		return length;
	}

	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("---CD---\nTitle: %s\nCategory: %s\nArtist: %s\nLength: %dm.\nCost: %.2f $\n", title,
				category, artist, getLength(), cost).replaceAll(" null | 0 ", " Unknown "));
		for (int i = 0; i < tracks.size(); i++)
			sb.append("\nTrack no. " + (i + 1) + "\n" + tracks.get(i).getDetails());
		return sb.toString();
	}

	@Override
	public void play() throws PlayerException {
		if (getLength() > 0) {
			StringBuilder sb = new StringBuilder();

			sb.append("Playing CD: " + this.getTitle() + (this.getArtist().equals("") ? "" : " by " + this.getArtist())
						+ "\n");
			sb.append("CD total length: " + this.getLength() + "\n");
			JOptionPane.showMessageDialog(null, sb.toString(), "Play CD", JOptionPane.INFORMATION_MESSAGE);
			for (Track t : tracks) {
				try {
					t.play(); 
				} catch (PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length must be a positive number!");
		}
			
	}

	@Override
	public String toString() {
		return String.format("CD - %s - %s - %s - %dm. : %.2f $", title, category, artist, getLength(), cost)
				.replaceAll(" null | 0 ", " Unknown ");
	}

}