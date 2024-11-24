import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalVideoDisc_NTH {
    private String title;              
    private String category;           
    private String director;           
    private int length;                
    private float cost;                
    private String addDate;            
    private int id;                    
    private static int nbDigitalVideoDiscs = 0; 

    
    public DigitalVideoDisc_NTH(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs; 
        setAddDate();
    }

    
    public DigitalVideoDisc_NTH(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; 
        setAddDate();
    }

    public DigitalVideoDisc_NTH(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; 
        setAddDate();
    }

    
    public DigitalVideoDisc_NTH(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; 
        setAddDate();
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getAddDate() {
        return addDate;
    }

    public int getId() {
        return id; 
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    private void setAddDate() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    addDate = formatter.format(new Date());
    }

    public void displayInfo() {
        System.out.println("\nID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Director: " + director);
        System.out.println("Length: " + length + " minutes");
        System.out.println("Cost: $" + cost);
        System.out.println("Added Date: " + addDate);
    }
    
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }
    
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
}
