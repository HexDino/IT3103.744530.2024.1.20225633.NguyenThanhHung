package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.HungNT_PlayerException;

public class HungNT_Track implements HungNT_Playable {
	private String title;
	private int length;

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}

	public HungNT_Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public void play() throws HungNT_PlayerException {
		if (this.getLength() < 0) {
			throw new HungNT_PlayerException("ERROR: DVD-length is non-positive!");
		} else {
			System.out.println("HungNT - Playing DVD: " + this.getTitle());
			System.out.println("HungNT - DVD length: " + this.getLength());
		}
	}

	public boolean equals(HungNT_Track tmp) {
		return (title == tmp.getTitle()) && (length == tmp.getLength());
	}
}