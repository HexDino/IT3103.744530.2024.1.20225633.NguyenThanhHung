import java.util.ArrayList;

public class Aims_NTH {
    private final int MAX_DVDS = 100;
    private ArrayList<DigitalVideoDisc_NTH> dvdInStore;
    private ArrayList<Cart_NTH> pendingOrders;
    private Cart_NTH cart;

    public Aims_NTH() {
        dvdInStore = new ArrayList<>();
        pendingOrders = new ArrayList<>();
        cart = new Cart_NTH();
    }

    public void showDVDInStock_NTH() {
        System.out.println("\n--- DVDs in Stock ---");
        for (DigitalVideoDisc_NTH dvd : dvdInStore) {
            System.out.print("[" + dvd.getTitle() + " | " + dvd.getCategory() + " | $" + dvd.getCost() + "]  ");
        }
        System.out.println("\n---------------------------------------------");
    }

    public void mg_addDVDtoStore_NTH(DigitalVideoDisc_NTH dvd) {
        if (dvdInStore.size() < MAX_DVDS) {
            dvdInStore.add(dvd);
            System.out.println("\nDVD added to the store: " + dvd.getTitle());
        } else {
            System.out.println("\nStore capacity reached. Cannot add more DVDs.");
        }
    }

    public void mg_removeDVDfromStore_NTH(DigitalVideoDisc_NTH dvd) {
        if (dvdInStore.remove(dvd)) {
            System.out.println("\nDVD removed from the store: " + dvd.getTitle());
        } else {
            System.out.println("\nDVD not found in the store.");
        }
    }

    public void mg_showPendingCart_NTH() {
        cart.showCart_NTH();
    }

    public void searchByTitle_NTH(String title) {
        System.out.println("\n--- Search Results for Title: \"" + title + "\" ---");
        for (DigitalVideoDisc_NTH dvd : dvdInStore) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                dvd.displayInfo();
                System.out.println("------------------------");
            }
        }
    }

    public void searchByCategory_NTH(String category) {
        System.out.println("\n--- Search Results for Category: \"" + category + "\" ---");
        for (DigitalVideoDisc_NTH dvd : dvdInStore) {
            if (dvd.getCategory().equalsIgnoreCase(category)) {
                System.out.print("[" + dvd.getTitle() + " | " + dvd.getCategory() + " | $" + dvd.getCost() + "]  ");
            }
        }
        System.out.println("\n---------------------------------------------");
    }

    public void searchByPrice_NTH(float price) {
        System.out.println("\n--- Search Results for DVDs under: $" + price + " ---");
        for (DigitalVideoDisc_NTH dvd : dvdInStore) {
            if (dvd.getCost() <= price) {
                System.out.print("[" + dvd.getTitle() + " | $" + dvd.getCost() + "]  ");
            }
        }
        System.out.println("\n---------------------------------------------");
    }
    
    public void viewListOfPendingOrders_NTH() {
        System.out.println("\n--- List of Pending Orders ---");
        int index = 1;
        for (Cart_NTH order : pendingOrders) {
            System.out.println("Order " + index + ": State - " + order.getOrderState() + ", Destination - " + order.getDeliDest());
            index++;
        }
        System.out.println("---------------------------------------------");
    }

    public void viewOrderDetail_NTH(int orderIndex) {
        if (orderIndex > 0 && orderIndex <= pendingOrders.size()) {
            System.out.println("\n--- Order Detail ---");
            pendingOrders.get(orderIndex - 1).showCart_NTH();
        } else {
            System.out.println("\nInvalid order index.");
        }
    }

    public static void main(String[] args) {
        Aims_NTH aims = new Aims_NTH();

        // Thêm một số DVD vào kho
        System.out.println("\n--- Adding DVDs to Store ---");
        DigitalVideoDisc_NTH dvd1 = new DigitalVideoDisc_NTH("The Matrix", "Sci-Fi", "Wachowskis", 120, 19.99f);
        DigitalVideoDisc_NTH dvd2 = new DigitalVideoDisc_NTH("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f);
        DigitalVideoDisc_NTH dvd3 = new DigitalVideoDisc_NTH("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 29.99f);
        DigitalVideoDisc_NTH dvd4 = new DigitalVideoDisc_NTH("Finding Nemo", "Animation", "Andrew Stanton", 100, 15.99f);

        aims.mg_addDVDtoStore_NTH(dvd1);
        aims.mg_addDVDtoStore_NTH(dvd2);
        aims.mg_addDVDtoStore_NTH(dvd3);
        aims.mg_addDVDtoStore_NTH(dvd4);

        // Hiển thị DVDs trong kho
        aims.showDVDInStock_NTH();

        // Tìm kiếm DVD theo tiêu đề
        aims.searchByTitle_NTH("Inception");

        // Tìm kiếm DVD theo thể loại
        aims.searchByCategory_NTH("Sci-Fi");

        // Tìm kiếm DVD theo giá
        aims.searchByPrice_NTH(20.00f);

        // Thêm DVD vào giỏ hàng
        System.out.println("\n--- Adding DVDs to Cart ---");
        aims.cart.addDigitalVideoDisc_NTH(dvd1);
        aims.cart.addDigitalVideoDisc_NTH(dvd2);

        // Hiển thị giỏ hàng
        System.out.println("\n--- Showing Cart ---");
        aims.mg_showPendingCart_NTH();

        // Sắp xếp giỏ hàng theo giá và hiển thị lại
        System.out.println("\n--- Sorting Cart by Cost ---");
        aims.cart.sortCartByCost_NTH();
        aims.mg_showPendingCart_NTH();

        // Sắp xếp giỏ hàng theo tiêu đề và hiển thị lại
        System.out.println("\n--- Sorting Cart by Title ---");
        aims.cart.sortCartByTitle_NTH();
        aims.mg_showPendingCart_NTH();

        // Tặng ngẫu nhiên một DVD miễn phí
        System.out.println("\n--- Giving a Random Free DVD ---");
        aims.cart.randomDVD_NTH();

        // Đặt hàng và hiển thị trạng thái
        System.out.println("\n--- Placing Order ---");
        aims.cart.setDeliDest("123 Main St, City, Country");
        aims.cart.setDeliFee(5.99f);
        aims.cart.setVat(10.0f);
        aims.cart.placeOrder_NTH();

        // Hiển thị lại giỏ hàng sau khi đặt hàng
        System.out.println("\n--- Showing Cart After Order ---");
        aims.mg_showPendingCart_NTH();

        // Xóa DVD khỏi kho
        System.out.println("\n--- Removing DVDs from Store ---");
        aims.mg_removeDVDfromStore_NTH(dvd1);
        aims.showDVDInStock_NTH();
        
        // Xem danh sách các đơn hàng đang chờ xử lý
        aims.viewListOfPendingOrders_NTH();

        // Xem chi tiết đơn hàng đầu tiên
        aims.viewOrderDetail_NTH(1);

        // Phê duyệt đơn hàng
        aims.cart.approveOrder_NTH();
        aims.viewOrderDetail_NTH(1);
    }
}
