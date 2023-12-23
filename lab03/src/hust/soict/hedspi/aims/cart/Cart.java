package hust.soict.hedspi.aims.cart;

import java.util.Collections;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;

	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public void addMedia(Media media) {
		
		
		itemsOrdered.add(media);
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.remove(media)) {
			System.out.println("Removed " + media.toString() + " from cart.");
		} else {
			System.out.println("Couldn't find this item.");
		}
	}

	public float totalCost() {
        float cost = 0;
        try {
            for (Media m : itemsOrdered) {
                cost += m.getCost();
            }
        } catch (Exception e) {
            System.err.println("Error calculating total cost: " + e.getMessage());
            e.printStackTrace();
        }
        return cost;
    }

	public void searchById(int id) {
        System.out.println("Search results for ID: " + id);
        try {
            for (Media m : itemsOrdered) {
                if (m.getId() == id) {
                    System.out.println(m.toString());
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("Error searching by ID: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("No items found.");
    }

	public void searchByTitle(String title) {
		boolean found = false;
		System.out.println("Search results for keywords: " + title);
		for (Media m : itemsOrdered) {
			if (m.isMatch(title)) {
				System.out.println(m.toString());
				found = true;
			}
		}
		if (!found)
			System.out.println("No items found.");
	}

	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public Media fetchMedia(String title) {
        try {
            for (Media m : itemsOrdered) {
                if (m.isMatch(title))
                    return m;
            }
        } catch (Exception e) {
            System.err.println("Error fetching media: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
	public void placeOrder() {
		itemsOrdered.clear();
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
