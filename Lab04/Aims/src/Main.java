import hust.soict.hedspi.aims.media.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aims_NTH aims = new Aims_NTH();

        // Create sample media objects
        DigitalVideoDisc_NTH dvd1 = new DigitalVideoDisc_NTH(1, "Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc_NTH dvd2 = new DigitalVideoDisc_NTH(2, "The Dark Knight", "Action", "Christopher Nolan", 152, 24.99f);
        DigitalVideoDisc_NTH dvd3 = new DigitalVideoDisc_NTH(3, "Interstellar", "Sci-Fi", "Christopher Nolan", 169, 29.99f);
        Book_NTH book1 = new Book_NTH(4, "The Great Gatsby", "Literature", 9.99f);
        Book_NTH book2 = new Book_NTH(5, "1984", "Dystopia", 12.99f);
        Book_NTH book3 = new Book_NTH(6, "To Kill a Mockingbird", "Fiction", 14.99f);
        CompactDisc_NTH cd1 = new CompactDisc_NTH(7, "Best of Pop", "Pop", 12.99f, 60, "John Doe", "Various Artists");
        CompactDisc_NTH cd2 = new CompactDisc_NTH(8, "Rock Classics", "Rock", 15.99f, 75, "James Smith", "The Rockers");

        // Add sample media to the store
        aims.mg_addMediaToStore(dvd1);
        aims.mg_addMediaToStore(dvd2);
        aims.mg_addMediaToStore(dvd3);
        aims.mg_addMediaToStore(book1);
        aims.mg_addMediaToStore(book2);
        aims.mg_addMediaToStore(book3);
        aims.mg_addMediaToStore(cd1);
        aims.mg_addMediaToStore(cd2);

        // Main program loop
        while (true) {
            Aims_NTH.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    // View store
                    aims.showMediaInStock();

                    // Store menu loop
                    storeMenuLoop(scanner, aims);
                    break;

                case 2:
                    // Update store
                    updateStore(scanner, aims);
                    break;

                case 3:
                    // See current cart
                    aims.seeCurrentCart();
                    break;

                case 0:
                    // Exit program
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void storeMenuLoop(Scanner scanner, Aims_NTH aims) {
        while (true) {
            Aims_NTH.storeMenu();
            int storeChoice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (storeChoice) {
                case 1:
                    // View media details
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    aims.searchByTitle(title);

                    // Media details menu loop
                    mediaDetailsMenuLoop(scanner, aims, title);
                    break;
                case 2:
                    // Add media to cart
                    System.out.print("Enter the title of the media to add to the cart: ");
                    String titleToAdd = scanner.nextLine();
                    
                    aims.addMediaToCart(titleToAdd);
                    break;
                case 3:
                    // Play media
                    System.out.print("Enter the title of the media to play: ");
                    String titleToPlay = scanner.nextLine();
                    aims.playMedia(titleToPlay);
                    break;
                case 4:
                    // See current cart
                    aims.mg_showPendingCart();
                    aims.seeCurrentCart();
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void mediaDetailsMenuLoop(Scanner scanner, Aims_NTH aims, String title) {
        while (true) {
            Aims_NTH.mediaDetailsMenu();
            int mediaChoice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (mediaChoice) {
                case 1:
                    // Add to cart
                    aims.addMediaToCart(title);
                    break;
                case 2:
                    // Play media
                    aims.playMedia(title);
                    break;
                case 0:
                    return; // Back to store menu
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void updateStore(Scanner scanner, Aims_NTH aims) {
        System.out.println("Enter the operation: 1 to add, 2 to remove");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        if (updateChoice == 1) {
            System.out.print("Enter media type (DVD, Book, CD): ");
            String mediaType = scanner.nextLine();

            System.out.print("Enter title: ");
            String titleToAdd = scanner.nextLine();

            if (mediaType.equalsIgnoreCase("DVD")) {
                DigitalVideoDisc_NTH newDVD = new DigitalVideoDisc_NTH(11, titleToAdd, "Unknown", "Unknown", 120, 19.99f);
                aims.mg_addMediaToStore(newDVD);
            } else if (mediaType.equalsIgnoreCase("Book")) {
                Book_NTH newBook = new Book_NTH(12, titleToAdd, "Unknown", 12.99f);
                aims.mg_addMediaToStore(newBook);
            } else if (mediaType.equalsIgnoreCase("CD")) {
                CompactDisc_NTH newCD = new CompactDisc_NTH(13, titleToAdd, "Unknown", 15.99f, 60, "Unknown", "Unknown");
                aims.mg_addMediaToStore(newCD);
            }
        } else if (updateChoice == 2) {
            System.out.print("Enter the title of the media to remove: ");
            String titleToRemove = scanner.nextLine();
            Media_NTH mediaToRemove = null;
            for (Media_NTH media : aims.getMediaInStore()) {
                if (media.getTitle().equalsIgnoreCase(titleToRemove)) {
                    mediaToRemove = media;
                    break;
                }
            }
            if (mediaToRemove != null) {
                aims.mg_removeMediaFromStore(mediaToRemove);
            } else {
                System.out.println("Media not found.");
            }
        }
    }
}
