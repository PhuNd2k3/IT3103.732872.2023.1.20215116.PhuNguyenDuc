package Lab01;
// Exercise 6.6

import java.util.Scanner;

public class AddTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lan luot nhap so hang va cot cua ma tran
        System.out.print("PhuNd 215116: Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("PhuNd 215116: Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Khai bao mang hai chieu
        int[][] matrixA = new int[rows][columns];
        int[][] matrixB = new int[rows][columns];
        int[][] resultMatrix = new int[rows][columns];

        // Nhap lan luot cac phan tu cho 2 ma tran
        System.out.println("PhuNd 215116: Enter elements of Matrix A:");
        inputMatrix(matrixA, scanner);

        System.out.println("PhuNd 215116: Enter elements of Matrix B:");
        inputMatrix(matrixB, scanner);

        // Cong lan luot cac phan tu cho 2 ma tran
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // Hien thi ket qua
        System.out.println("PhuNd 215116: Matrix A:");
        displayMatrix(matrixA);
        System.out.println("PhuNd 215116: Matrix B:");
        displayMatrix(matrixB);
        System.out.println("PhuNd 215116: Sum of Matrices A and B:");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    // Method de nhan gia tri cho ma tran
    public static void inputMatrix(int[][] matrix, Scanner scanner) {
        // Enter lan luot theo hang va theo cot
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element at row " + (i + 1) + " column " + (j + 1) + ": ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Method de hien thi toan bo ma tran
    public static void displayMatrix(int[][] matrix) {
        // Hien thi lan luot theo hang va theo cot
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
