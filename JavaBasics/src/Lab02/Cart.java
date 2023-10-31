package Lab02;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0; // Phu 20215116: To keep track of how many DigitalVideoDiscs are in the cart

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) { // Phu: Not already full
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Nguyen Duc Phu 20215116: The disc has been added");
        } else { // Phu: Full
            System.out.println("Nguyen Duc Phu 20215116: The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                // Nguyen Duc Phu 20215116: Put the element behind
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println("Nguyen Duc Phu 20215116: The disc has been remove");
                return;
            }
        }
        System.out.println("Nguyen Duc Phu 20215116: Can't find this disc");
    }

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
}
