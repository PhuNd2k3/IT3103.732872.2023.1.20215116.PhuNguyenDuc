package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		super(title, category, cost);
	}
	public void addAuthor(String authorName) {
		int index = authors.indexOf(authorName);
		if (index != -1) {
			System.out.println("Author " + authorName + " has been added");
		}
		else {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		int index = authors.indexOf(authorName);
		if (index != -1) {
			authors.remove(index);
		}
		else System.out.println("Author " + authorName + " has not been in the list author");
	}
	public void printAuthor() {
		for (String author : authors) {
			System.out.print(author + "\t");
			System.out.println();
		}
	}
	
}
