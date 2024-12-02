import hust.soict.hedspi.aims.media.*;
import java.util.*;

public class Aims_NTH {
    private final int MAX_MEDIA = 100; // Media store limit
    private ArrayList<Media_NTH> mediaInStore;
    private ArrayList<Cart_NTH> pendingOrders;
    private Cart_NTH cart;

    public Aims_NTH() {
        mediaInStore = new ArrayList<>();
        pendingOrders = new ArrayList<>();
        cart = new Cart_NTH();
    }

    // Show all media in store
    public void showMediaInStock() {
        System.out.println("\n--- Media in Stock ---");
        for (Media_NTH media : mediaInStore) {
            System.out.print("[" + media.getTitle() + " | " + media.getCategory() + " | $" + media.getCost() + "]  ");
        }
        System.out.println("\n---------------------------------------------");
    }

    // Add media to the store
    public void mg_addMediaToStore(Media_NTH media) {
        if (mediaInStore.size() < MAX_MEDIA) {
            mediaInStore.add(media);
            System.out.println("\nMedia added to the store: " + media.getTitle());
        } else {
            System.out.println("\nStore capacity reached. Cannot add more media.");
        }
    }

    // Remove media from the store
    public void mg_removeMediaFromStore(Media_NTH media) {
        if (mediaInStore.remove(media)) {
            System.out.println("\nMedia removed from the store: " + media.getTitle());
        } else {
            System.out.println("\nMedia not found in the store.");
        }
    }

    // Display cart contents
    public void mg_showPendingCart() {
        cart.showCart();
    }

    // Search media by title
    public void searchByTitle(String title) {
        System.out.println("\n--- Search Results for Title: \"" + title + "\" ---");
        for (Media_NTH media : mediaInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                media.displayInfo();
                System.out.println("------------------------");
            }
        }
    }

    // Search media by category
    public void searchByCategory(String category) {
        System.out.println("\n--- Search Results for Category: \"" + category + "\" ---");
        for (Media_NTH media : mediaInStore) {
            if (media.getCategory().equalsIgnoreCase(category)) {
                System.out.print("[" + media.getTitle() + " | " + media.getCategory() + " | $" + media.getCost() + "]  ");
            }
        }
        System.out.println("\n---------------------------------------------");
    }

    // Search media by price
    public void searchByPrice(float price) {
        System.out.println("\n--- Search Results for Media under: $" + price + " ---");
        for (Media_NTH media : mediaInStore) {
            if (media.getCost() <= price) {
                System.out.print("[" + media.getTitle() + " | $" + media.getCost() + "]  ");
            }
        }
        System.out.println("\n---------------------------------------------");
    }

    // Display list of pending orders
    public void viewListOfPendingOrders() {
        System.out.println("\n--- List of Pending Orders ---");
        int index = 1;
        for (Cart_NTH order : pendingOrders) {
            System.out.println("Order " + index + ": State - " + order.getOrderState() + ", Destination - " + order.getDeliDest());
            index++;
        }
        System.out.println("---------------------------------------------");
    }

    // View order details
    public void viewOrderDetail(int orderIndex) {
        if (orderIndex > 0 && orderIndex <= pendingOrders.size()) {
            System.out.println("\n--- Order Detail ---");
            pendingOrders.get(orderIndex - 1).showCart();
        } else {
            System.out.println("\nInvalid order index.");
        }
    }

    // Show main menu
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    // Show store menu
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    // Show media details menu
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    // Show cart menu
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // Add media to cart
    public void addMediaToCart(String title) {
        Media_NTH media = null;
        for (Media_NTH m : mediaInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                media = m;
                break;
            }
        }

        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to the cart.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }
    public void removeMediaFromCart(String title) {
        cart.removeMediaByTitle(title); // Gọi phương thức removeMediaByTitle từ Cart_NTH
    }


    // Play media
    public void playMedia(String title) {
        Media_NTH media = null;
        for (Media_NTH m : mediaInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                media = m;
                break;
            }
        }

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media cannot be played or not found.");
        }
    }

    // Filter and sort operations in the cart
    public void seeCurrentCart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    // Filter media in the cart
                    System.out.println("Choose filter option: 1. By ID 2. By Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();  // Clear the buffer
                    if (filterChoice == 1) {
                        System.out.print("Enter the ID to filter by: ");
                        int id = scanner.nextInt();
                        cart.filterById(id);
                    } else if (filterChoice == 2) {
                        System.out.print("Enter the title to filter by: ");
                        String title = scanner.nextLine();
                        cart.filterByTitle(title);
                    }
                    break;
                case 2:
                    // Sort media in the cart
                    System.out.println("Choose sorting option: 1. By Title 2. By Cost");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();  // Clear the buffer
                    if (sortChoice == 1) {
                        cart.sortByTitleCost();
                    } else if (sortChoice == 2) {
                        cart.sortByCostTitle();
                    }
                    break;
                case 3:
                    // Remove media from the cart
                    System.out.print("Enter the title of the media to remove: ");
                    String titleToRemove = scanner.nextLine();
                    cart.removeMediaByTitle(titleToRemove);
                    break;
                case 4:
                    // Play media in the cart
                    System.out.print("Enter the title of the media to play: ");
                    String titleToPlay = scanner.nextLine();
                    cart.playMedia(titleToPlay);
                    break;
                case 5:
                    // Place order
                    cart.placeOrder();
                    System.out.println("Order placed and cart is now empty.");
                    break;
                case 0:
                    return;  // Go back to the main menu
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public ArrayList<Media_NTH> getMediaInStore() {
        return mediaInStore;
    }
}
