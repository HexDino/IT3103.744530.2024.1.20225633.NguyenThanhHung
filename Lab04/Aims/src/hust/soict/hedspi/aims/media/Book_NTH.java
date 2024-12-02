package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book_NTH extends Media_NTH {
    private ArrayList<String> authors;

    // Constructor
    public Book_NTH(int id, String title, String category, float cost) {
        super(id, title, category, cost); // Gọi constructor của lớp Media_NTH
        this.authors = new ArrayList<>();
    }

    // Getter và Setter cho authors
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        if (authors != null) {
            this.authors = authors;
        } else {
            System.out.println("Cannot set null to authors list.");
        }
    }

    // Phương thức addAuthor và removeAuthor
    public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be empty.");
        } else if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " added to the book.");
        } else {
            System.out.println("Author " + authorName + " is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be empty.");
        } else if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed from the book.");
        } else {
            System.out.println("Author " + authorName + " not found in the list.");
        }
    }

    // Override phương thức displayInfo
    @Override
    public void displayInfo() {
    	System.out.println("Book ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Cost: " + getCost());
        System.out.println("Authors: " + authors);
    }
}
