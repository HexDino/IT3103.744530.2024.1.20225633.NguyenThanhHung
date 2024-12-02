import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Tạo các đối tượng Media
    	DigitalVideoDisc_NTH dvd = new DigitalVideoDisc_NTH(1, "Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        Book_NTH book = new Book_NTH(2, "The Great Gatsby", "Literature", 9.99f);
        CompactDisc_NTH cd = new CompactDisc_NTH(3, "Best of Pop", "Pop", 12.99f, 60, "John Doe", "Various Artists");

        // Thêm track vào CD
        cd.addTrack(new Track_NTH("Track 1", 3));
        cd.addTrack(new Track_NTH("Track 2", 4));

        // Tạo một danh sách Media
        List<Media_NTH> mediaList = new ArrayList<>();
        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        // Duyệt qua danh sách và in thông tin media
        for (Media_NTH media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
