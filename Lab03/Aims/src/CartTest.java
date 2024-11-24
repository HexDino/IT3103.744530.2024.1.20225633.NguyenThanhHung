public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng
        Cart_NTH cart = new Cart_NTH();

        // Tạo các đối tượng DVD
        DigitalVideoDisc_NTH dvd1 = new DigitalVideoDisc_NTH("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc_NTH dvd2 = new DigitalVideoDisc_NTH("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc_NTH dvd3 = new DigitalVideoDisc_NTH("Aladin", "Animation", 18.99f);

        // Thêm DVD vào giỏ hàng
        cart.addDigitalVideoDisc_NTH(dvd1);
        cart.addDigitalVideoDisc_NTH(dvd2);
        cart.addDigitalVideoDisc_NTH(dvd3);

        // In giỏ hàng
        System.out.println("\n--- Printing Cart ---");
        cart.print();

        // Tìm kiếm theo ID
        System.out.println("\n--- Searching by ID ---");
        cart.searchById(1); // Tìm kiếm ID 1
        cart.searchById(5); // Tìm kiếm ID không tồn tại

        // Tìm kiếm theo tiêu đề
        System.out.println("\n--- Searching by Title ---");
        cart.searchByTitle("Star Wars"); // Tiêu đề tồn tại
        cart.searchByTitle("Avatar");    // Tiêu đề không tồn tại
    }
}
