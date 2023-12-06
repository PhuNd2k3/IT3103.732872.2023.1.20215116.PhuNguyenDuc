package hust.soict.dsai.aims.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

    public static void main(String[] args) {

        // Nguyen Duc Phu 20215116: Create, a new cart

        Cart cart = new Cart();

        // Nguyen Duc Phu 20215116: Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Nguyen Duc Phu 20215116: Test the print method
        cart.print();

        // Nguyen Duc Phu 20215116: To-do: Test the search methods here
        cart.searchById(1);
        cart.searchById(4);

        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Random title");
    }
}