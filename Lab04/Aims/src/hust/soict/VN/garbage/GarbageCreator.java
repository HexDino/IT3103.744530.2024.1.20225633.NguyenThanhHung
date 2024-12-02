package hust.soict.VN.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        try {
            String filename = "test.txt"; // Đường dẫn đến file lớn
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            // Sử dụng String với toán tử "+"
            long startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken with String (+): " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
