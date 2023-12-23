package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;


public class Store {
	private static final int STORE_LIMIT = 10;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(0, media);
        System.out.println("Added " + media.toString() + " successfully.");
        }

    public void removeMedia(Media media) {
        try {
            if (itemsInStore.remove(media)) {
                System.out.println("Removed " + media.toString() + " from store.");
            } else {
                System.out.println("Couldn't find this item.");
            }
        } catch (Exception e) {
            System.err.println("Error removing media from store: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Media fetchMedia(String title) {
        try {
            for (Media m : itemsInStore) {
                if (m.isMatch(title))
                    return m;
            }
        } catch (Exception e) {
            System.err.println("Error fetching media from store: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
