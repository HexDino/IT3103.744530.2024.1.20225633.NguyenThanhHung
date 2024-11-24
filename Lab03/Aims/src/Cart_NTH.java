import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Cart_NTH {
    private ArrayList<DigitalVideoDisc_NTH> itemsOrdered;
    private final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private String orderState = "Pending";
    private String deliDest;
    private float deliFee;
    private float vat;

    public Cart_NTH() {
        itemsOrdered = new ArrayList<>();
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getDeliDest() {
        return deliDest;
    }

    public void setDeliDest(String deliDest) {
        this.deliDest = deliDest;
    }

    public float getDeliFee() {
        return deliFee;
    }

    public void setDeliFee(float deliFee) {
        this.deliFee = deliFee;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    // Thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc_NTH(DigitalVideoDisc_NTH disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(disc);
            qtyOrdered++;
            System.out.println("\nThe disc \"" + disc.getTitle() + "\" has been added to the cart.");
        } else {
            System.out.println("\nThe cart is full. Cannot add more discs.");
        }
    }

    // Xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc_NTH(DigitalVideoDisc_NTH disc) {
        if (itemsOrdered.remove(disc)) {
            qtyOrdered--;
            System.out.println("\nThe disc \"" + disc.getTitle() + "\" has been removed from the cart.");
        } else {
            System.out.println("\nThe disc is not found in the cart.");
        }
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost_NTH() {
        float total = 0;
        for (DigitalVideoDisc_NTH disc : itemsOrdered) {
            total += disc.getCost();
        }
        total += deliFee + total * (vat / 100); // Thêm phí giao hàng và VAT
        return total;
    }

    // Hiển thị giỏ hàng
    public void showCart_NTH() {
        System.out.println("\n--- Cart Contents ---");
        for (DigitalVideoDisc_NTH disc : itemsOrdered) {
            System.out.print("[" + disc.getTitle() + " | " + disc.getCategory() + " | $" + disc.getCost() + "]  ");
        }
        System.out.println("\n---------------------------------------------");
        System.out.println("Total cost: $" + totalCost_NTH());
        System.out.println("Total items in cart: " + qtyOrdered);
    }

    // Sắp xếp DVD theo tiêu đề
    public void sortCartByTitle_NTH() {
        itemsOrdered.sort(Comparator.comparing(DigitalVideoDisc_NTH::getTitle)
                .thenComparing(DigitalVideoDisc_NTH::getCost));
        System.out.println("\nThe cart has been sorted by title.");
    }

    // Sắp xếp DVD theo giá
    public void sortCartByCost_NTH() {
        itemsOrdered.sort(Comparator.comparing(DigitalVideoDisc_NTH::getCost)
                .thenComparing(DigitalVideoDisc_NTH::getTitle));
        System.out.println("\nThe cart has been sorted by cost.");
    }

    // Tặng ngẫu nhiên một DVD
    public DigitalVideoDisc_NTH randomDVD_NTH() {
        if (!itemsOrdered.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(itemsOrdered.size());
            System.out.println("\nYou received a free DVD: \"" + itemsOrdered.get(index).getTitle() + "\"");
            return itemsOrdered.get(index);
        }
        return null;
    }

    // Đặt hàng
    public void placeOrder_NTH() {
        if (!itemsOrdered.isEmpty()) {
            System.out.println("\nOrder placed successfully with destination: " + deliDest);
            itemsOrdered.clear(); // Giả sử đơn hàng hoàn thành và làm trống giỏ hàng
            qtyOrdered = 0;
        } else {
            System.out.println("\nNo items in the cart to place an order.");
        }
    }
    // Phê duyệt đơn hàng
    public void approveOrder_NTH() {
        if (orderState.equalsIgnoreCase("Pending")) {
            orderState = "Approved";
            System.out.println("\nOrder has been approved.");
        } else {
            System.out.println("\nOrder is not in a state that can be approved.");
        }
    }

    // Từ chối đơn hàng
    public void rejectOrder_NTH() {
        if (orderState.equalsIgnoreCase("Pending")) {
            orderState = "Rejected";
            System.out.println("\nOrder has been rejected.");
        } else {
            System.out.println("\nOrder is not in a state that can be rejected.");
        }
    }
    //Phương thức nhận tham số là mảng DVD
    public void addDigitalVideoDisc1(DigitalVideoDisc_NTH[] dvdList) {
        for (DigitalVideoDisc_NTH disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(disc);
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the cart.");
            } else {
                System.out.println("The cart is full. Cannot add more discs.");
                break;
            }
        }
    }
    //Phương thức nhận tham số là danh sách số lượng tùy ý (varargs)
    public void addDigitalVideoDisc2(DigitalVideoDisc_NTH... discs) {
        for (DigitalVideoDisc_NTH disc : discs) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(disc);
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the cart.");
            } else {
                System.out.println("The cart is full. Cannot add more discs.");
                break;
            }
        }
    }
    //Nạp chồng phương thức với số lượng tham số khác nhau
    public void addDigitalVideoDisc(DigitalVideoDisc_NTH dvd1, DigitalVideoDisc_NTH dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(dvd1);
            qtyOrdered++;
            System.out.println("The disc \"" + dvd1.getTitle() + "\" has been added to the cart.");
        } else {
            System.out.println("The cart is full. Cannot add \"" + dvd1.getTitle() + "\".");
        }

        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(dvd2);
            qtyOrdered++;
            System.out.println("The disc \"" + dvd2.getTitle() + "\" has been added to the cart.");
        } else {
            System.out.println("The cart is full. Cannot add \"" + dvd2.getTitle() + "\".");
        }
    }
    
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        int index = 1;
        for (DigitalVideoDisc_NTH disc : itemsOrdered) {
            System.out.println(index++ + ". " + disc.toString());
            totalCost += disc.getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
    
    public void searchById(int id) {
        boolean found = false;
        for (DigitalVideoDisc_NTH disc : itemsOrdered) {
            if (disc.getId() == id) {
                System.out.println("Found DVD with ID " + id + ":");
                System.out.println(disc.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID " + id);
        }
    }
    
    public void searchByTitle(String title) {
        boolean found = false;
        for (DigitalVideoDisc_NTH disc : itemsOrdered) {
            if (disc.isMatch(title)) {
                System.out.println("Found DVD with title \"" + title + "\":");
                System.out.println(disc.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title \"" + title + "\"");
        }
    }



}
