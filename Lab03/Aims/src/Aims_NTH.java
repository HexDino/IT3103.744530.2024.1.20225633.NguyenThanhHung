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

     // Tạo DVD
        DigitalVideoDisc_NTH dvd1 = new DigitalVideoDisc_NTH("The Matrix", "Sci-Fi", "Wachowskis", 120, 19.99f);
        DigitalVideoDisc_NTH dvd2 = new DigitalVideoDisc_NTH("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f);
        DigitalVideoDisc_NTH dvd3 = new DigitalVideoDisc_NTH("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 29.99f);
        DigitalVideoDisc_NTH dvd4 = new DigitalVideoDisc_NTH("Finding Nemo", "Animation", "Andrew Stanton", 100, 15.99f);

        // Sử dụng phương thức nạp chồng
        System.out.println("\n--- Thêm DVD bằng mảng ---");
        aims.cart.addDigitalVideoDisc1(new DigitalVideoDisc_NTH[]{dvd1, dvd2});

        System.out.println("\n--- Thêm DVD bằng varargs ---");
        aims.cart.addDigitalVideoDisc2(dvd3, dvd4);
        
        System.out.println("\n--- Thêm DVD bằng phương thức 2 tham số ---");
        aims.cart.addDigitalVideoDisc(dvd1, dvd3);
        
        
    }
}
