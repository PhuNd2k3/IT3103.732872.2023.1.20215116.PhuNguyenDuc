package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
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

	public boolean equals(Media media) {
		try {
			if (this.title.equals(media.getTitle()) && this.cost == media.getCost()) {
				return true;
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassCastException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public String toString() {
		return this.id + " - " + this.title + " - " + this.category + " - " + this.cost;
	}

}
