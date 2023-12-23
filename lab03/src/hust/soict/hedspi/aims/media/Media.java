package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public Media() {

	}

	public Media(String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public boolean isMatch(String title) {
		String[] keywords = title.split("\\s+");
		for (String word : keywords) {
			if (this.title.toLowerCase().contains(word.toLowerCase()))
				return true;
		}
		return false;
	}
	
	public boolean equals(Media media) {
		// Nguyen Duc Phu 215116 Modify in Lab05
		try {
			if (this.title.equals(media.getTitle()) && this.cost == media.getCost()) {
				return true;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String toString() {
		return this.id + " - " + this.title + " - " + this.category + " - " + this.cost;
	}

}
