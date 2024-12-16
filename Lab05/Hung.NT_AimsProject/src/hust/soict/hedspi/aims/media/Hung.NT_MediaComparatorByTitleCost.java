package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class HungNT_MediaComparatorByTitleCost implements Comparator<HungNT_Media> {
	@Override
	public int compare(HungNT_Media o1, HungNT_Media o2) {
		if (o1.getTitle().compareTo(o2.getTitle()) != 0) {
			return o1.getTitle().compareTo(o2.getTitle());
		} else {
			if (o1.getCost() > o2.getCost())
				return 1;
			else
				return -1;
		}
	}
}