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
}
