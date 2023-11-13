package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 999;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int qtyInStore = 0; // Phu 20215116: To keep track of how many DigitalVideoDiscs are in the cart

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_NUMBERS_IN_STORE) { // Phu: Not already full
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("Nguyen Duc Phu 20215116: The disc has been added");
        } else { // Phu: Full
            System.out.println("Nguyen Duc Phu 20215116: Store is full!");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                // Nguyen Duc Phu 20215116: Put the element behind
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                qtyInStore--;
                System.out.println("Nguyen Duc Phu 20215116: The disc has been remove");
                return;
            }
        }
        System.out.println("Nguyen Duc Phu 20215116: Can't find this disc");
    }

}
