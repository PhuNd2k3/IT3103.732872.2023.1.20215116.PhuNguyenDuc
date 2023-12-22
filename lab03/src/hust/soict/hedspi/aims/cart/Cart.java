package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Phu 20215116: addMedia and removeMedia method
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Already has this media");
        } else {
            itemsOrdered.add(media);
            System.out.println("Media added successfully");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media remove successfully");
        } else
            System.out.println("Media not found");
    }

    // Phu 20215116: get total cost method
    public float totalCost() {
        float cost = 0;
        for (Media media : itemsOrdered) {
            cost += media.getCost();
        }
        return cost;
    }

    // Phu 20215116: search by id and by title method
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Nguyen Duc Phu 20215116: Media founded:");
                System.out.println(media.toString());
                return media;
            }
        }
        System.out.println("Nguyen Duc Phu 20215116: No match found with id: " + id);
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                System.out.println("Nguyen Duc Phu 20215116: Media founded:");
                System.out.println(media.toString());
                return media;
            }
        }
        System.out.println("Nguyen Duc Phu 20215116: No match found with title: " + title);
        return null;
    }

    public void printCart() {
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        printCart();
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        printCart();
    }

    public void removeAllMedia() {
        itemsOrdered.clear();
    }
}
