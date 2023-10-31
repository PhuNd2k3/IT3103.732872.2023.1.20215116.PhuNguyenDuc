package Lab02;

public class Aims {
	public static void main(String[] args) {

		// Phu 20215116: Create a new cart
		Cart anOrder = new Cart();

		// Phu 20215116: Create a new DVD object and add it to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);

		// Phu 20215116: Print total cost
		System.out.println("Phu 20215116: Total cost is: ");
		System.out.println(anOrder.totalCost());
	}
}
