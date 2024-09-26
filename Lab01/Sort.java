import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner_NTH = new Scanner(System.in);
        
        System.out.println("Enter the number of elements in the array:");
        int n_NTH = scanner_NTH.nextInt();
        
        int[] array_NTH = new int[n_NTH];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n_NTH; i++) {
            array_NTH[i] = scanner_NTH.nextInt();
        }
        
        Arrays.sort(array_NTH);
        
        int sum_NTH = 0;
        for (int num_NTH : array_NTH) {
            sum_NTH += num_NTH;
        }
        double average_NTH = (double) sum_NTH / n_NTH;
        
        System.out.println("Sorted array: " + Arrays.toString(array_NTH));
        System.out.println("Sum: " + sum_NTH);
        System.out.println("Average: " + average_NTH);
        
        scanner_NTH.close();
    }
}
