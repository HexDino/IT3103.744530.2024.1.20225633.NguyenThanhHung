package hust.soict.hedspi.aims.media;

import java.util.Objects;
import java.util.Comparator;

public abstract class Media_NTH {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor
    public Media_NTH(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Phương thức abstract để mỗi loại media sẽ có phương thức hiển thị riêng
    public abstract void displayInfo();
    
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);  // So sánh tên media với tiêu đề
    }

    // Ghi đè phương thức equals() để so sánh các đối tượng Media_NTH
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Media_NTH media = (Media_NTH) obj;
        return Objects.equals(title, media.title); // So sánh theo title
    }

    @Override
    public int hashCode() {
        return Objects.hash(title); // Tạo hashCode dựa trên title
    }

    // Phương thức toString() để in thông tin cơ bản
    @Override
    public String toString() {
        return "Title: " + title + " | Category: " + category + " | Cost: $" + cost;
    }
    
    public static final Comparator<Media_NTH> COMPARE_BY_TITLE_COST = new CompareByTitleCost();
    public static final Comparator<Media_NTH> COMPARE_BY_COST_TITLE = new CompareByCostTitle();
}
