package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.HungNT_PlayerException;

public class HungNT_CompactDisc extends HungNT_Disc implements HungNT_Playable {
	private String artist;
	private ArrayList<HungNT_Track> tracks;

	public HungNT_CompactDisc(int id, String title, String category, float cost, String artist,
			ArrayList<HungNT_Track> tracks) {
		super(id, title, category, cost);
		this.tracks = tracks;
		this.artist = artist;
		this.setLength(getLength());
	}

	public HungNT_CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(HungNT_Track song) {
		if (tracks.contains(song)) {
			System.out.println("HungNT - " + song.getTitle() + "is already in the CD");
		} else {
			tracks.add(song);
		}
	}

	public void removeTrack(HungNT_Track song) {
		if (tracks.contains(song)) {
			tracks.remove(song);
		} else {
			System.out.println("HungNT - " + song.getTitle() + "is not in the CD");
		}
	}

	public ArrayList<HungNT_Track> getTracks() {
		return tracks;
	}

	@Override
	public float getLength() {
		float sum = 0;
		for (HungNT_Track song : tracks) {
			sum += song.getLength();
		}
		return sum;
	}

	public void play() throws HungNT_PlayerException {
		if (this.getLength() < 0) {
			throw new HungNT_PlayerException("ERROR: DVD-length is non-positive!");
		} else {
			System.out.println("\nHungNT - Title: " + getTitle() + '\n' + "Artist: " + getArtist() + "\n");
			for (HungNT_Track song : tracks) {
				song.play();
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(
				"HungNT - CD: " + " [id = " + getId() + ", artist: " + artist + ", title = '" + getTitle() + '\''
						+ ", category = '" + getCategory() + '\'' + ", length : " + getLength() + " min" + ", cost= "
						+ getCost() + "$]" + '\n' + "Tracks: \n" + "===================" + '\n');
		for (HungNT_Track track : tracks) {
			print.append(track.getTitle());
			print.append('\t');
			print.append(track.getLength());
			print.append(" min");
			print.append('\n');
		}
		return print.toString();
	}
}