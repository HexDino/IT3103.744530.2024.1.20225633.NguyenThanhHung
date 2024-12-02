import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;

public class Store_NTH {
    private ArrayList<Media_NTH> itemsInStore; // Giờ chứa Media_NTH thay vì chỉ DVD
    private final int MAX_MEDIA = 100;

    public Store_NTH() {
        itemsInStore = new ArrayList<>();
    }

    // Thêm media vào kho
    public void addMedia(Media_NTH media) {
        if (itemsInStore.size() < MAX_MEDIA) {
            itemsInStore.add(media);
            System.out.println("\nThe media \"" + media.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("\nStore capacity reached. Cannot add more media.");
        }
    }

    // Xóa media khỏi kho
    public void removeMedia(Media_NTH media) {
        if (itemsInStore.remove(media)) {
            System.out.println("\nThe media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("\nThe media is not found in the store.");
        }
    }

    // Hiển thị tất cả media trong kho
    public void showItemsInStore() {
        System.out.println("\n--- Media in Store ---");
        for (Media_NTH media : itemsInStore) {
            System.out.print("[" + media.getTitle() + " | " + media.getCategory() + " | $" + media.getCost() + "]  ");
        }
        System.out.println("\n---------------------------------------------");
    }

    // Tìm kiếm media theo tiêu đề
    public void searchByTitle(String title) {
        System.out.println("\n--- Search Results for Title: \"" + title + "\" ---");
        for (Media_NTH media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                media.displayInfo();
                System.out.println("------------------------");
            }
        }
    }

    // Tìm kiếm media theo thể loại
    public void searchByCategory(String category) {
        System.out.println("\n--- Search Results for Category: \"" + category + "\" ---");
        for (Media_NTH media : itemsInStore) {
            if (media.getCategory().equalsIgnoreCase(category)) {
                System.out.print("[" + media.getTitle() + " | " + media.getCategory() + " | $" + media.getCost() + "]  ");
            }
        }
        System.out.println("\n---------------------------------------------");
    }

    // Tìm kiếm media theo giá
    public void searchByPrice(float price) {
        System.out.println("\n--- Search Results for Media under: $" + price + " ---");
        for (Media_NTH media : itemsInStore) {
            if (media.getCost() <= price) {
                System.out.print("[" + media.getTitle() + " | $" + media.getCost() + "]  ");
            }
        }
        System.out.println("\n---------------------------------------------");
    }
}
