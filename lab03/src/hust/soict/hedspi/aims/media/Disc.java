package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;

	public Disc() {
		super();
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Disc(String title, String category, String director, float cost) {
		this(title, category, cost);
		this.director = director;
	}

	public Disc(String title, String category, String director, int length, float cost) {
		this(title, category, director, cost);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title, String category, float cost, int length, String director) {
		// TODO Auto-generated constructor stub
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}

	public String tostring() {
		return super.toString() + " - " + this.length + " - " + this.director;
	}

}