public class TestDigitalVideoDisc {
    public static void main(String[] args) {
        // Tạo các đối tượng DVD
        DigitalVideoDisc_NTH dvd1 = new DigitalVideoDisc_NTH("The Matrix", "Sci-Fi", "Wachowskis", 120, 19.99f);
        DigitalVideoDisc_NTH dvd2 = new DigitalVideoDisc_NTH("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f);
        DigitalVideoDisc_NTH dvd3 = new DigitalVideoDisc_NTH("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 29.99f);

        // Hiển thị thông tin từng DVD
        System.out.println("\n--- DVD Information ---");
        dvd1.displayInfo();
        dvd2.displayInfo();
        dvd3.displayInfo();

        // Hiển thị tổng số DVD đã được tạo
        System.out.println("\nTotal DVDs created: " + DigitalVideoDisc_NTH.getNbDigitalVideoDiscs());
    }
}
