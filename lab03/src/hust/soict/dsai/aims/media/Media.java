package hust.soict.dsai.aims.media;

public abstract class Media extends Object {
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media(int id, String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	// Phu 20215116: Getter and Setter methods
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

	@Override
	public boolean equals(Object o) {

		// Nguyen Duc Phu 20215116: Override equals method
		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		/*
		 * Nguyen Duc Phu 20215116: Check if o is an instance of DigitalVideoDisc or not
		 * "null instanceof [type]" also returns false
		 */
		if (!(o instanceof Media)) {
			return false;
		}

		// Nguyen Duc Phu 20215116: typecast o to Complex so that we can compare data
		// members
		Media media = (Media) o;

		// Nguyen Duc Phu 20215116: Compare the data members and return accordingly
		return cost == media.cost
				&& title.equals(media.title)
				&& category.equals(media.category);
	}

	// Nguyen Duc Phu 20215116: Overide toString method in session 6
	@Override
	public String toString() {
		return "Media - " + title + " - " + (category == null ? "Missing category" : category) + " - " + "Cost: "
				+ cost;
	}

	// Nguyen Duc Phu 20215116: Method for check matching title
	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}
}
