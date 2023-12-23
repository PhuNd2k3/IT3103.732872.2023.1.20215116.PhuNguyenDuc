package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.CartScreen;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.media.Book;

public class Aims {
	private static Store store;
	private static Cart cart;
	private static StoreScreen storeScreen;
	private static CartScreen cartScreen;

	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
		store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f, 128, "Guy Ritchie"));
		store.addMedia(new DigitalVideoDisc("Title1", "Jennie", 16.5f, 5, "SM"));
		store.addMedia(new DigitalVideoDisc("Title2", "Akase", 6.5f, 5, "YOASOBI"));
		store.addMedia(new Book("Doraemon", "Takahsi", 13.0f));
		store.addMedia(new Book("Book", "Hi", 12.0f));
        openStoreScreen();
	}
	

	public static Store getStore() {
		return store;
	}

	public static Cart getCart() {
		return cart;
	}

	public static StoreScreen getStoreScreen() {
		return storeScreen;
	}

	public static CartScreen getCartScreen() {
		return cartScreen;
	}
	
	public static void openStoreScreen() {
        try {
            storeScreen = new StoreScreen(store);
        } catch (Exception e) {
            System.err.println("Error opening store screen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void closeStoreScreen() {
        try {
            if (storeScreen != null) {
                storeScreen.setVisible(false);
                storeScreen = null;
            }
        } catch (Exception e) {
            System.err.println("Error closing store screen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void openCartScreen() {
        try {
            cartScreen = new CartScreen(cart);
        } catch (Exception e) {
            System.err.println("Error opening cart screen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void closeCartScreen() {
        try {
            if (cartScreen != null) {
                cartScreen.setVisible(false);
                cartScreen = null;
            }
        } catch (Exception e) {
            System.err.println("Error closing cart screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
