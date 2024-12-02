package hust.soict.hedspi.aims.media;

public abstract class Disc_NTH extends Media_NTH {
    private int length;
    private String director;

    // Constructor
    public Disc_NTH(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    // Getter và Setter
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Phương thức displayInfo() để hiển thị thông tin cơ bản
    @Override
    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Cost: $" + getCost());
        System.out.println("Length: " + length + " minutes");
        System.out.println("Director: " + director);
    }
}
