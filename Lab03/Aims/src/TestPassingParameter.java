public class TestPassingParameter {
    public static void main(String[] args) {
    	DigitalVideoDisc_NTH jungleDVD = new DigitalVideoDisc_NTH("Jungle");
        DigitalVideoDisc_NTH cinderellaDVD = new DigitalVideoDisc_NTH("Cinderella");

        System.out.println("Before swapping:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        // Sử dụng mảng để hoán đổi
        DigitalVideoDisc_NTH[] dvds = {jungleDVD, cinderellaDVD};
        swap(dvds);

        System.out.println("\nAfter swapping:");
        System.out.println("jungleDVD title: " + dvds[0].getTitle());
        System.out.println("cinderellaDVD title: " + dvds[1].getTitle());

        // Thay đổi tiêu đề bằng phương thức changeTitle
        changeTitle(dvds[0], dvds[1].getTitle());
        System.out.println("\nAfter changing title:");
        System.out.println("jungleDVD title: " + dvds[0].getTitle());
    }

    public static void swap(DigitalVideoDisc_NTH[] dvds) {
        if (dvds.length == 2) {
            DigitalVideoDisc_NTH temp = dvds[0];
            dvds[0] = dvds[1];
            dvds[1] = temp;
        }
    }


    public static void changeTitle(DigitalVideoDisc_NTH dvd, String title) {
        dvd.setTitle(title);
    }
}
