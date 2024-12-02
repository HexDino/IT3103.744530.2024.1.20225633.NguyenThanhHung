package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class CompareByCostTitle implements Comparator<Media_NTH> {

    @Override
    public int compare(Media_NTH media1, Media_NTH media2) {
        // Compare by cost first in descending order
        int costComparison = Float.compare(media2.getCost(), media1.getCost()); // Reverse order for cost (descending)
        
        // If costs are the same, compare by title in ascending order
        if (costComparison == 0) {
            return media1.getTitle().compareTo(media2.getTitle());
        }
        
        return costComparison;
    }
}
