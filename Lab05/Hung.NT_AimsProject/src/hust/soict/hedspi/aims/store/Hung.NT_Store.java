package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.*;
import java.util.LinkedList;

public class HungNT_Store {
	private LinkedList<HungNT_Media> itemsInStore = new LinkedList<HungNT_Media>();

	public LinkedList<HungNT_Media> getItemsInStore() {
		return itemsInStore;
	}

	private boolean checkMedia(HungNT_Media disc) {
		for (HungNT_Media digitalVideoDisc : itemsInStore) {
			if (digitalVideoDisc.equals(disc)) {
				return true;
			}
		}
		return false;
	}

	public HungNT_Media findMedia(String title) {
		for (HungNT_Media item : itemsInStore) {
			if (item.getTitle().equals(title)) {
				return item;
			}
		}
		return null;
	}

	public void removeMedia(HungNT_Media disc) {
		if (checkMedia(disc)) {
			itemsInStore.remove(disc);
			System.out.println("HungNT - " + disc.getTitle() + " has been deleted from the store!");
		} else {
			System.out.println("HungNT - No " + disc.getTitle() + " in the store!");
		}
	}

	public void addMedia(HungNT_Media disc) {
		if (!checkMedia(disc)) {
			itemsInStore.add(disc);
			System.out.println("HungNT - " + disc.getTitle() + " has been added to the store!");
		} else {
			System.out.println("HungNT - " + disc.getTitle() + " 'already exists in the store!");
		}

	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(
				"****************STORE***************\nHungNT - Items in the store: \n");
		if (itemsInStore.isEmpty())
			string.append("HungNT - No DVD in the store!\n");
		else {
			for (HungNT_Media dvd : itemsInStore) {
				string.append(dvd.getTitle() + " - " + dvd.getCost() + " $\n");
			}
		}
		string.append("***************************************");
		return string.toString();
	}
}