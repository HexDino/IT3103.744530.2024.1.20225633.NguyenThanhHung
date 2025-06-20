package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class HungNT_Book extends HungNT_Media {
	private List<String> authors = new ArrayList<String>();

	public HungNT_Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}

	public HungNT_Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("HungNT - " + authorName + "is already in the list !");
		} else {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("HungNT - " + authorName + "is not in the list !");
		}
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder("HungNT - Book: " + " [id=" + getId() + ", title='" + getTitle() + '\''
				+ ", category='" + getCategory() + '\'' + ", authors: ");
		for (String a : authors) {
			print.append(a);
			print.append(" ");
		}
		print.append(", cost: ");
		print.append(getCost());
		print.append("$]");
		return print.toString();
	}
}