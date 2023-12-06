package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

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

}
