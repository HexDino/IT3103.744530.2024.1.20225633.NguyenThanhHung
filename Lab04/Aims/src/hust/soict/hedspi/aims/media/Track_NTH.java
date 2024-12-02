package hust.soict.hedspi.aims.media;

import java.util.Objects;

public class Track_NTH implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track_NTH(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title và length
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Phương thức play() triển khai từ interface Playable
    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength() + " minutes");
    }
    
    // Ghi đè phương thức equals() để so sánh Track_NTH
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track_NTH track = (Track_NTH) obj;
        return title.equals(track.title);  // So sánh tiêu đề, hoặc các thuộc tính khác của Track
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length); // Tạo hashCode dựa trên title và length
    }

    @Override
    public String toString() {
        return "Track: " + title + " | Length: " + length + " minutes";
    }
}
