package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.HungNT_PlayerException;

public class HungNT_DigitalVideoDisc extends HungNT_Disc implements HungNT_Playable {

	public HungNT_DigitalVideoDisc(int id, String title, String category, float cost, String director, float length) {
		super(id, title, category, cost, director, length);
	}

	public HungNT_DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public void play() throws HungNT_PlayerException {
		if (this.getLength() < 0) {
			throw new HungNT_PlayerException("ERROR: DVD-length is non-positive!");
		} else {
			System.out.println("HungNT - Playing DVD: " + this.getTitle());
			System.out.println("HungNT - DVD length: " + this.getLength());
		}
	}
}