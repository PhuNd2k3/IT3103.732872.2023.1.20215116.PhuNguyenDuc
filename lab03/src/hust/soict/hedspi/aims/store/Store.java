package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Phu 20215116: addMedia and removeMedia method
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Already has this media");
        } else {
            itemsInStore.add(media);
            System.out.println("Media added successfully");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media remove successfully");
        } else
            System.out.println("Media not found");
    }

    public static void showMenu() {
        System.out.println("AIMS");
        System.out.println("---------------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options");
        System.out.println("------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("---------------------------------");
        System.out.println("Please choose a number : 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options");
        System.out.println("----------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("---------------------------------");
        System.out.println("Please choose a number : 0-1-2");
    }

    public Media searchTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
