package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc_NTH extends Disc_NTH implements Playable {
    private String artist;
    private ArrayList<Track_NTH> tracks;

    // Constructor
    public CompactDisc_NTH(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director); // Gọi constructor của lớp Disc_NTH
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Phương thức thêm Track
    public void addTrack(Track_NTH track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added to the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the list.");
        }
    }

    // Phương thức xóa Track
    public void removeTrack(Track_NTH track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed from the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" not found in the list.");
        }
    }

    // Phương thức tính tổng length của CD
    public int getLength() {
        int totalLength = 0;
        for (Track_NTH track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength; // Trả về tổng độ dài của tất cả các bài hát
    }

    // Phương thức play()
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Total Length: " + getLength() + " minutes");

        // Phát từng track trong danh sách
        for (Track_NTH track : tracks) {
            track.play(); // Gọi phương thức play() của Track
        }
    }

    // Phương thức displayInfo()
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Artist: " + artist);
        System.out.println("Total Length: " + getLength() + " minutes");
        System.out.println("Tracks: ");
        for (Track_NTH track : tracks) {
            System.out.println(" - " + track.getTitle() + " (" + track.getLength() + " minutes)");
        }
    }
}
