package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class CompareByTitleCost implements Comparator<Media_NTH> {

    @Override
    public int compare(Media_NTH media1, Media_NTH media2) {
        // Compare by title first
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());
        
        // If titles are the same, compare by cost in descending order
        if (titleComparison == 0) {
            return Float.compare(media2.getCost(), media1.getCost()); // Reverse order for cost (descending)
        }
        
        return titleComparison;
    }
}
