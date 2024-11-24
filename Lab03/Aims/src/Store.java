import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc_NTH> itemsInStore; // Danh sách DVD trong kho

    // Constructor
    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Thêm DVD vào kho
    public void addDVD(DigitalVideoDisc_NTH dvd) {
        itemsInStore.add(dvd);
        System.out.println("Added DVD to the store: " + dvd.getTitle());
    }

    // Xóa DVD khỏi kho
    public void removeDVD(DigitalVideoDisc_NTH dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("Removed DVD from the store: " + dvd.getTitle());
        } else {
            System.out.println("DVD not found in the store: " + dvd.getTitle());
        }
    }

    // Hiển thị danh sách DVD trong kho
    public void displayStore() {
        System.out.println("\n--- Store Inventory ---");
        for (DigitalVideoDisc_NTH dvd : itemsInStore) {
            System.out.println(dvd.toString());
        }
        System.out.println("--------------------------");
    }
}
