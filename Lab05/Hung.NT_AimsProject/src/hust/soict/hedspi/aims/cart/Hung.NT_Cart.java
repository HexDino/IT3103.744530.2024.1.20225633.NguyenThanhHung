package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.HungNT_Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class HungNT_Cart {
	private ObservableList<HungNT_Media> itemsOrdered = FXCollections.observableArrayList();
	
	public ObservableList<HungNT_Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(HungNT_Media item) {
		if (itemsOrdered.contains(item)) {
			System.out.println("HungNT - " + item.getTitle() + "is already in the cart!");
		} else {
			itemsOrdered.add(item);
			System.out.println("HungNT - " + item.getTitle() + " is now in your cart!");
		}
	}

	public void removeMedia(HungNT_Media item) {
		if (itemsOrdered.contains(item)) {
			itemsOrdered.remove(item);
		} else {
			System.out.println(
					"HungNT - " + item.getClass().getSimpleName() + ' ' + item.getTitle() + " is not in the cart!");
		}
	}

	public float totalCost() {
		float sum = 0;
		for (HungNT_Media item : itemsOrdered) {
			sum += item.getCost();
		}
		return sum;
	}

	public void print() {
		StringBuilder output = new StringBuilder(
				"*************CART************************** \nHungNT - Ordered items: \n");
		if (itemsOrdered.isEmpty()) {
			output.append("HungNT - No time\n");
		} else {
			int i = 1;
			for (HungNT_Media item : itemsOrdered) {
				output.append("HungNT - " + i + ".[" + item.getTitle() + "] - [" + item.getCategory() + "] - "
						+ item.getCost() + " $\n");
				i++;
			}
		}
		output.append("HungNT - Total: ").append(totalCost()).append(" $\n");
		output.append("================================================\n");
		System.out.println(output);
	}

	public void searchById(int i) {
		if (i > itemsOrdered.size()) {
			System.out.println("HungNT - No match found!");
		} else {
			System.out.println("HungNT - Result: " + "[" + itemsOrdered.get(i - 1).getTitle() + "] - ["
					+ itemsOrdered.get(i - 1).getCategory() + "] -" + +itemsOrdered.get(i - 1).getCost() + " $\n");
		}
	}

	public void searchByTitle(String title) {
		for (HungNT_Media item : itemsOrdered) {
			if (item.getTitle().equals(title)) {
				System.out.println("HungNT - Result: " + "[" + item.getTitle() + "] - [" + item.getCategory() + "] -"
						+ item.getCost() + " $\n");
				return;
			}
		}
		System.out.println("HungNT - No match found");
	}

	public HungNT_Media findMedia(String title) {
		for (HungNT_Media item : itemsOrdered) {
			if (item.getTitle().equals(title)) {
				return item;
			}
		}
		return null;
	}

	public void emptyCart() {
		itemsOrdered.removeAll(itemsOrdered);
	}
	 public void sortByTitleCost() { Collections.sort(itemsOrdered, HungNT_Media.COMPARE_BY_TITLE_COST); }
	 public void sortByCostTitle() { Collections.sort(itemsOrdered, HungNT_Media.COMPARE_BY_COST_TITLE); }
}