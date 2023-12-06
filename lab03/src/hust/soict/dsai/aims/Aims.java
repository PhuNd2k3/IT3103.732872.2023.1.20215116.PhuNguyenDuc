package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Cart cart = new Cart();
	private static Store myStore = new Store();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			Store.showMenu();
			int choose = scanner.nextInt();
			switch (choose) {
				case 1:
					ViewStore();
					break;
				case 2:
					System.out.println("Now you can add or remove a media in store");
					break;
				case 3:
					cart.printCart();
					break;
				case 0:
					return;
			}
		}
	}

	public static void ViewStore() {
		Store.storeMenu();
		String title;
		int choose1 = scanner.nextInt();
		switch (choose1) {
			case 1:
				title = scanner.nextLine();
				System.out.println("Media : " + myStore.searchTitle(title).toString());

				break;
			case 2:
				title = scanner.nextLine();
				cart.addMedia(myStore.searchTitle(title));
				System.out.println("Add media to cart successfully");
				break;
			case 3:
				title = scanner.nextLine();
				Media media = myStore.searchTitle(title);
				PlayMedia(media);
				break;
			case 4:
				cart.printCart();
				break;
			case 0:
				return;
		}
	}

	public static void MediaDetailMenu(Media media) {
		Store.mediaDetailsMenu();
		int choose2 = scanner.nextInt();
		switch (choose2) {
			case 1:
				cart.addMedia(media);
				System.out.println("Add media to cart successfully");
				break;
			case 2:
				PlayMedia(media);
				break;
			case 0:
				return;
		}

	}

	public static void PlayMedia(Media media) {
		if (media instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) media;
			dvd.play();
		} else if (media instanceof CompactDisc) {
			((CompactDisc) media).play();
		} else
			System.out.println("Media cann't play");
	}

}
