package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class HungNT_MediaComparatorByCostTitle implements Comparator<HungNT_Media> {
	@Override
    public int compare(HungNT_Media o1, HungNT_Media o2) {
        if(o1.getCost() != o2.getCost()) {
            int i = (int) (o1.getCost() - o2.getCost());
            return i;
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}