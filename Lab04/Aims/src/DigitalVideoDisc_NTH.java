import hust.soict.hedspi.aims.media.Disc_NTH;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc_NTH extends Disc_NTH implements Playable {

    // Constructor
    public DigitalVideoDisc_NTH(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, length, director); // Gọi constructor của lớp Disc_NTH
    }

    // Phương thức play() của interface Playable
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }

    // Phương thức displayInfo() để hiển thị thông tin của DVD
    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}
