import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the triangle: ");
        int n_NTH = scanner.nextInt();
        
        for (int i = 1; i <= n_NTH; i++) {
            for (int j = 0; j < n_NTH - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}