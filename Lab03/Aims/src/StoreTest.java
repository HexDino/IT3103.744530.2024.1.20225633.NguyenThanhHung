public class StoreTest {
    public static void main(String[] args) {
        // Tạo kho hàng
        Store store = new Store();

        // Tạo các DVD mẫu
        DigitalVideoDisc_NTH dvd1 = new DigitalVideoDisc_NTH("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc_NTH dvd2 = new DigitalVideoDisc_NTH("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc_NTH dvd3 = new DigitalVideoDisc_NTH("Aladin", "Animation", 18.99f);

        // Thêm DVD vào kho
        System.out.println("\n--- Adding DVDs to the store ---");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Hiển thị danh sách DVD trong kho
        store.displayStore();

        // Xóa DVD khỏi kho
        System.out.println("\n--- Removing a DVD from the store ---");
        store.removeDVD(dvd2); // Xóa DVD "Star Wars"

        // Hiển thị danh sách DVD sau khi xóa
        store.displayStore();

        // Thử xóa DVD không có trong kho
        System.out.println("\n--- Trying to remove a non-existent DVD ---");
        store.removeDVD(dvd2); // Thử xóa lại DVD "Star Wars"
    }
}
