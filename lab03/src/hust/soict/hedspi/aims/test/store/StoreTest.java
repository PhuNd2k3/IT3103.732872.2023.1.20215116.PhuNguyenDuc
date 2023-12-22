package hust.soict.hedspi.aims.test.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {

    public static void main(String[] args) {

        // Phu 20215116: Create a new Store
        Store store = new Store();

        // Phu 20215116: Create a new DVD object and add it to the Store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        store.addDVD(dvd2);

        // Phu 20215116: Test remove method
        store.removeDVD(dvd1); // Phu 20215116: can remove

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.removeDVD(dvd3); // Phu 20215116: can't remove
    }
}
