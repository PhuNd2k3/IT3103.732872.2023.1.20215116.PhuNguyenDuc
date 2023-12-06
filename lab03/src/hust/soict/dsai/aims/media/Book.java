package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	// Phu 20215116: Lab04
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors.addAll(authors);
	}

	// Phu 20215116: Getter and Setter methods: Create later if necessary

	// Phu 20215116: Method to add an author
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		} else
			System.out.println("Already has author " + authorName);

	}

	// Phu 20215116: Method to remove an author
	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.remove(authorName);
		} else
			System.out.println("Author " + authorName + " Not in the list");

	}

}
