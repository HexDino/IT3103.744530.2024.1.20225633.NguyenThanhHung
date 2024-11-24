package hust.soict.VN.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        try {
            String filename = "test.txt"; // Đường dẫn đến file lớn
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            // Sử dụng StringBuffer để nối chuỗi
            long startTime = System.currentTimeMillis();
            StringBuffer outputStringBuffer = new StringBuffer();
            for (byte b : inputBytes) {
                outputStringBuffer.append((char) b);
            }
            String outputString = outputStringBuffer.toString();
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken with StringBuffer: " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
