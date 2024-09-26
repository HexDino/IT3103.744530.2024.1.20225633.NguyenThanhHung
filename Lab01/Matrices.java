import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {
        Scanner scanner_NTH = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of the matrices:");
        int rows_NTH = scanner_NTH.nextInt();
        int cols_NTH = scanner_NTH.nextInt();

        int[][] matrix1_NTH = new int[rows_NTH][cols_NTH];
        int[][] matrix2_NTH = new int[rows_NTH][cols_NTH];
        int[][] sumMatrix_NTH = new int[rows_NTH][cols_NTH];

        System.out.println("Enter the elements of the first matrix:");
        for (int i_NTH = 0; i_NTH < rows_NTH; i_NTH++) {
            for (int j_NTH = 0; j_NTH < cols_NTH; j_NTH++) {
                matrix1_NTH[i_NTH][j_NTH] = scanner_NTH.nextInt();
            }
        }

        System.out.println("Enter the elements of the second matrix:");
        for (int i_NTH = 0; i_NTH < rows_NTH; i_NTH++) {
            for (int j_NTH = 0; j_NTH < cols_NTH; j_NTH++) {
                matrix2_NTH[i_NTH][j_NTH] = scanner_NTH.nextInt();
            }
        }

        for (int i_NTH = 0; i_NTH < rows_NTH; i_NTH++) {
            for (int j_NTH = 0; j_NTH < cols_NTH; j_NTH++) {
                sumMatrix_NTH[i_NTH][j_NTH] = matrix1_NTH[i_NTH][j_NTH] + matrix2_NTH[i_NTH][j_NTH];
            }
        }

        System.out.println("Sum of the matrices:");
        for (int i_NTH = 0; i_NTH < rows_NTH; i_NTH++) {
            for (int j_NTH = 0; j_NTH < cols_NTH; j_NTH++) {
                System.out.print(sumMatrix_NTH[i_NTH][j_NTH] + " ");
            }
            System.out.println();
        }

        scanner_NTH.close();
    }
}
