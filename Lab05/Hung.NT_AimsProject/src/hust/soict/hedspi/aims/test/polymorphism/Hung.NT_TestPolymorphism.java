package hust.soict.hedspi.aims.test.polymorphism;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class HungNT_TestPolymorphism {
	public static void main(String[] args) {
		List<HungNT_Media> mediae = new ArrayList<HungNT_Media>();
		HungNT_DigitalVideoDisc dvd = new HungNT_DigitalVideoDisc(1, "Jurassic World", "Action", 17.75f, "Colin Trevorrow", 124);

		ArrayList<HungNT_Track> tracks = new ArrayList<HungNT_Track>();
		tracks.add(new HungNT_Track("Like I'm gonna lose you", 4));
		tracks.add(new HungNT_Track("Let me down slowly", 3));
		HungNT_CompactDisc cd = new HungNT_CompactDisc(2, "Ban nhac buon", "Nhac Au - My", 3.5f, "Various artists", tracks);

		List<String> authors = new ArrayList<String>();
		authors.add("Fujiko F. Fujio");
		HungNT_Book book = new HungNT_Book(3, "Doraemon", "Manga", 0.79f, authors);

		mediae.add(dvd);
		mediae.add(cd);
		mediae.add(book);

		for (HungNT_Media item : mediae) {
			System.out.println(item);
		}
	}
}