import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Cart_NTH {
    private ArrayList<Media_NTH> itemsOrdered; // Giỏ hàng giờ chứa Media_NTH thay vì chỉ DVD
    private final int MAX_NUMBERS_ORDERED = 20;
    private String orderState = "Pending";
    private String deliDest;
    private float deliFee;
    private float vat;

    public Cart_NTH() {
        itemsOrdered = new ArrayList<>();
    }

    // Getter và setter cho các thuộc tính
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

    // Thêm media vào giỏ hàng
    public void addMedia(Media_NTH media) {
        if (!itemsOrdered.contains(media)) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                System.out.println("\nThe media \"" + media.getTitle() + "\" has been added to the cart.");
            } else {
                System.out.println("\nThe cart is full. Cannot add more media.");
            }
        } else {
            System.out.println("\nThe media \"" + media.getTitle() + "\" is already in the cart.");
        }
    }

    // Xóa media khỏi giỏ hàng
    public void removeMedia(Media_NTH media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("\nThe media \"" + media.getTitle() + "\" has been removed from the cart.");
        } else {
            System.out.println("\nThe media is not found in the cart.");
        }
    }
    public void removeMediaByTitle(String titleToRemove) {
        Media_NTH mediaToRemove = null;

        // Tìm kiếm media trong giỏ hàng theo tên
        for (Media_NTH media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(titleToRemove)) {
                mediaToRemove = media;
                break;  // Ngừng tìm kiếm khi đã tìm thấy
            }
        }

        // Nếu tìm thấy, gọi phương thức removeMedia với đối tượng media
        if (mediaToRemove != null) {
            removeMedia(mediaToRemove);  // Gọi phương thức removeMedia đã có
        } else {
            System.out.println("No media found with title: \"" + titleToRemove + "\"");
        }
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media_NTH media : itemsOrdered) {
            total += media.getCost();
        }
        total += deliFee + total * (vat / 100); // Thêm phí giao hàng và VAT
        return total;
    }

    // Hiển thị giỏ hàng
    public void showCart() {
        System.out.println("\n--- Cart Contents ---");
        for (Media_NTH media : itemsOrdered) {
            media.displayInfo(); // Gọi phương thức displayInfo của mỗi media
        }
        System.out.println("\n---------------------------------------------");
        System.out.println("Total cost: $" + totalCost());
        System.out.println("Total items in cart: " + itemsOrdered.size());
    }

 // Sort the cart by title, then by cost
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media_NTH.COMPARE_BY_TITLE_COST);
        System.out.println("\nThe cart has been sorted by title and then by cost.");
    }

    // Sort the cart by cost, then by title
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media_NTH.COMPARE_BY_COST_TITLE);
        System.out.println("\nThe cart has been sorted by cost and then by title.");
    }

    // Tặng ngẫu nhiên một media
    public Media_NTH randomMedia() {
        if (!itemsOrdered.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(itemsOrdered.size());
            System.out.println("\nYou received a free media: \"" + itemsOrdered.get(index).getTitle() + "\"");
            return itemsOrdered.get(index);
        }
        return null;
    }

    // Đặt hàng
    public void placeOrder() {
        if (!itemsOrdered.isEmpty()) {
            System.out.println("\nOrder placed successfully with destination: " + deliDest);
            itemsOrdered.clear(); // Giả sử đơn hàng hoàn thành và làm trống giỏ hàng
        } else {
            System.out.println("\nNo items in the cart to place an order.");
        }
    }

    // Phê duyệt đơn hàng
    public void approveOrder() {
        if (orderState.equalsIgnoreCase("Pending")) {
            orderState = "Approved";
            System.out.println("\nOrder has been approved.");
        } else {
            System.out.println("\nOrder is not in a state that can be approved.");
        }
    }

    // Từ chối đơn hàng
    public void rejectOrder() {
        if (orderState.equalsIgnoreCase("Pending")) {
            orderState = "Rejected";
            System.out.println("\nOrder has been rejected.");
        } else {
            System.out.println("\nOrder is not in a state that can be rejected.");
        }
    }

    // Tìm kiếm media theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media_NTH media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found media with ID " + id + ":");
                media.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID " + id);
        }
    }

    // Tìm kiếm media theo tên
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media_NTH media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found media with title \"" + title + "\":");
                media.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title \"" + title + "\"");
        }
    }

    // Lọc media theo ID
    public void filterById(int id) {
        System.out.println("\n--- Filter Results by ID: " + id + " ---");
        boolean found = false;
        for (Media_NTH media : itemsOrdered) {
            if (media.getId() == id) {
                media.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with ID " + id);
        }
    }

    // Lọc media theo Tiêu đề
    public void filterByTitle(String title) {
        System.out.println("\n--- Filter Results by Title: " + title + " ---");
        boolean found = false;
        for (Media_NTH media : itemsOrdered) {
            if (media.isMatch(title)) {
                media.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title \"" + title + "\"");
        }
    }

    // Phát media trong giỏ hàng
    public void playMedia(String title) {
        boolean found = false;
        for (Media_NTH media : itemsOrdered) {
            if (media.isMatch(title)) {
                if (media instanceof Playable) {
                    ((Playable) media).play(); // Gọi phương thức play() của media
                    found = true;
                } else {
                    System.out.println("This media cannot be played.");
                    found = true;
                }
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with title \"" + title + "\"");
        }
    }
    
    
}
