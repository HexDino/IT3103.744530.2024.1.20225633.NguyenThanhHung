package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.HungNT_Cart;
import hust.soict.hedspi.aims.exception.HungNT_PlayerException;
import hust.soict.hedspi.aims.store.HungNT_Store;
import hust.soict.hedspi.aims.media.*;
import java.util.*;

public class HungNT_Aims {
	public static void main(String[] args) throws HungNT_PlayerException {
		HungNT_DigitalVideoDisc dvd = new HungNT_DigitalVideoDisc(1, "Jurassic World", "Action", 17.75f,
				"Colin Trevorrow", 124);

		ArrayList<HungNT_Track> tracks = new ArrayList<HungNT_Track>();
		tracks.add(new HungNT_Track("Like I'm gonna lose you", 4));
		tracks.add(new HungNT_Track("Let me down slowly", 3));
		HungNT_CompactDisc cd = new HungNT_CompactDisc(2, "Ban nhac buon", "Nhac Au - My", 3.5f, "Various artists",
				tracks);

		List<String> authors = new ArrayList<String>();
		authors.add("Fujiko F. Fujio");
		HungNT_Book book = new HungNT_Book(3, "Doraemon", "Manga", 0.79f, authors);

		HungNT_Store store = new HungNT_Store();
		store.addMedia(cd);
		store.addMedia(dvd);
		store.addMedia(book);

		HungNT_Cart cart = new HungNT_Cart();
		Scanner scanner = new Scanner(System.in);
		showMenu(scanner, store, cart);
	}

	public static void showMenu(Scanner scanner, HungNT_Store store, HungNT_Cart cart) throws HungNT_PlayerException {
		while (true) {
			System.out.println("HungNT - AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("HungNT - Please choose a number: 0-1-2-3");
			int option = scanner.nextInt();
			switch (option) {
			case 0 -> {
				scanner.close();
				System.out.println("Thanks for using our app");
				System.exit(0);
			}
			case 1 -> storeMenu(scanner, store, cart);
			case 2 -> updateStoreMenu(scanner, store);
			case 3 -> {
				cart.print();
				cartMenu(scanner, cart);
				}
			}
		}
	}

	public static void updateStoreMenu(Scanner scanner, HungNT_Store store) {
		System.out.println("""
				==========================
				1. Add Media
				2. Delete Media
				3. Update Media in Store
				0. Back
				==========================
				Please choose a number: 0-1-2-3	""");
		int option = scanner.nextInt();
		switch (option) {
		case 1 -> {
			System.out.println("""
					1.DigitalVideoDisc
					2.CompactDisc
					3.Book
					-------
					-> Your type:""");
			int option2 = scanner.nextInt();
			System.out.print("HungNT - Enter id: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("HungNT - Enter title: ");
			String title = scanner.nextLine();
			System.out.print("HungNT - Enter category: ");
			String category = scanner.nextLine();
			System.out.print("HungNT - Enter cost: ");
			float cost = scanner.nextFloat();
			scanner.nextLine();
			switch (option2) {
			case 1 -> {
				System.out.print("HungNT - Enter director's name: ");
				String director = scanner.nextLine();
				System.out.print("HungNT - Enter dvd's length: ");
				int length = scanner.nextInt();
				scanner.nextLine();
				store.addMedia(new HungNT_DigitalVideoDisc(id, title, category, cost, director, length));
			}
			case 3 -> {
				System.out.print("HungNT - Enter author's name (Enter nothing to skip): ");
				StringBuilder author = new StringBuilder(scanner.nextLine());
				ArrayList<String> authors = new ArrayList<String>();
				while (!author.isEmpty()) {
					authors.add(author.toString());
					System.out.print("HungNT - Enter author's name (Enter nothing to skip): ");

				}
				store.addMedia(new HungNT_Book(id, title, category, cost, authors));
			}
			case 2 -> {
				System.out.print("HungNT - Enter artist's name: ");
				StringBuffer artist = new StringBuffer(scanner.nextLine());
				System.out.print("HungNT - Enter number of track: ");
				int nbTrack = scanner.nextInt();
				scanner.nextLine();
				ArrayList<HungNT_Track> tracks = new ArrayList<HungNT_Track>();
				StringBuilder name = new StringBuilder();
				for (int i = 0; i < nbTrack; i++) {
					System.out.print("HungNT - Enter Track[" + i + "]'s name: ");
					name.replace(0, name.length(), scanner.nextLine());
					System.out.print("HungNT - Enter Track[" + i + "]'s length: ");
					int length = scanner.nextInt();
					tracks.add(new HungNT_Track(name.toString(), length));
					scanner.nextLine();

				}
				store.addMedia(new HungNT_CompactDisc(id, title, category, cost, artist.toString(), tracks));
			}
			}
		}
		case 2 -> {
			System.out.println("HungNT - Enter item's title: ");
			scanner.nextLine();
			String title = scanner.nextLine();
			Iterator<HungNT_Media> iter = store.getItemsInStore().iterator();
			while (iter.hasNext()) {
				HungNT_Media item = iter.next();
				if (item.getTitle().equals(title)) {
					iter.remove();
					System.out.println("HungNT - " + item.getClass().getSimpleName() + " " + item.getTitle()
							+ "'ve been deleted from the store !");
				}
			}

		}
		case 3 -> {
			System.out.println("HungNT - Enter item's id: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("HungNT - Enter title: ");
			String title = scanner.nextLine();
			System.out.print("HungNT - Enter category: ");
			String category = scanner.nextLine();
			System.out.print("HungNT - Enter cost: ");
			float cost = scanner.nextFloat();
			store.getItemsInStore().get(id).setCost(cost);
			store.getItemsInStore().get(id).setTitle(title);
			store.getItemsInStore().get(id).setCategory(category);
			System.out.println(store);
		}
		}
	}

	public static void mediaDetailsMenu(Scanner scanner, HungNT_Store store, HungNT_Cart cart) throws HungNT_PlayerException {
		System.out.print("HungNT - Enter media's title: ");
		String title = scanner.nextLine();
		HungNT_Media item = store.findMedia(title);
		if (item == null) {
			System.out.println("HungNT - No media!");
			return;
		}
		System.out.println(item);
		while (true) {
			System.out.println("HungNT - Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("HungNT - Please choose a number: 0-1-2");

			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1 -> {
				cart.addMedia(item);
			}
			case 2 -> {
				if (item.getClass().getSimpleName().equals("Book")) {
					System.out.println("HungNT - This media is unplayable");
				} else {
					if (item instanceof HungNT_DigitalVideoDisc dvd) {
						dvd.play();
					}
					if (item instanceof HungNT_CompactDisc cd) {
						cd.play();
					}
				}
			}
			case 0 -> {
				return;
			}
			}
		}
	}

	public static void storeMenu(Scanner scanner, HungNT_Store store, HungNT_Cart cart) throws HungNT_PlayerException {
		System.out.println(store);
		while (true) {
			System.out.println("HungNT - Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("HungNT - Please choose a number: 0-1-2-3-4");

			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1 -> mediaDetailsMenu(scanner, store, cart);
			case 0 -> {
				return;
			}
			case 2 -> {
				System.out.print("HungNT - Enter media's title: ");
				String title = scanner.nextLine();
				HungNT_Media item = store.findMedia(title);
				if (item == null) {
					System.out.println("HungNT - No media!");
				} else {
					cart.addMedia(item);
				}
			}
			case 3 -> {
				System.out.print("HungNT - Enter media's title: ");
				String title = scanner.nextLine();
				HungNT_Media item = store.findMedia(title);
				if (item == null) {
					System.out.println("HungNT - No media !");
				} else {
					if (item.getClass().getSimpleName().equals("Book")) {
						System.out.println("HungNT - This media is unplayable");
					} else {
						if (item instanceof HungNT_DigitalVideoDisc dvd) {
							dvd.play();
						}
						if (item instanceof HungNT_CompactDisc cd) {
							cd.play();
						}
					}
				}
			}
			case 4 -> {
				cart.print();
				cartMenu(scanner, cart);
			}
			}
		}
	}

	public static void cartMenu(Scanner scanner, HungNT_Cart cart) throws HungNT_PlayerException {
		while (true) {
			System.out.println("HungNT - Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("HungNT - Please choose a number: 0-1-2-3-4-5");

			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 0 -> {
				return;
			}
			case 1 -> {
				System.out.println("""
						1. Filter by title
						2. Filter by id
						----------------
						HungNT - Please choose a number: 1-2	""");
				int option2 = scanner.nextInt();
				scanner.nextLine();
				if (option2 == 1) {
					String title = scanner.nextLine();
					cart.searchByTitle(title);
				} else {
					int id = scanner.nextInt();
					cart.searchById(id);
				}
			}
			case 2 -> {
				System.out.println("""
						1. Sort by title cost
						2. Sort by cost title
						----------------
						HungNT - Please choose a number: 1-2	""");
				int option2 = scanner.nextInt();
				scanner.nextLine();
				if (option2 == 1) {
					cart.sortByTitleCost();
					cart.print();
				} else {
					cart.sortByCostTitle();
					cart.print();
				}
			}
			case 3 -> {
				System.out.print("HungNT - Enter media's title: ");
				String title = scanner.nextLine();
				HungNT_Media item = cart.findMedia(title);
				if (item == null) {
					System.out.println("HungNT - No media!");
				} else {
					cart.removeMedia(item);
				}
			}
			case 4 -> {
				System.out.print("HungNT - Enter media's title: ");
				String title = scanner.nextLine();
				HungNT_Media item = cart.findMedia(title);
				if (item == null) {
					System.out.println("HungNT - No media!");
				} else {
					if (item.getClass().getSimpleName().equals("Book")) {
						System.out.println("HungNT - This media is unplayable");
					} else {
						if (item instanceof HungNT_DigitalVideoDisc dvd) {
							dvd.play();
						}
						if (item instanceof HungNT_CompactDisc cd) {
							cd.play();
						}
					}
				}
			}
			case 5 -> {
				System.out.println("HungNT- Your cart have been paid\nThanks for using our service");
				cart.emptyCart();
			}
			}
		}
	}
}