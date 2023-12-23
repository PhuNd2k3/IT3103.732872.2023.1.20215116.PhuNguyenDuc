package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private ArrayList<String> authors = new ArrayList<String>();

	public Book() {
		super();
	}

	public Book(String title) {
		super(title);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		authors.remove(authorName);
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}
	
	public void printAuthor() {
		for (String author : authors) {
			System.out.print(author + "\t");
			System.out.println();
		}
	}
	
}
