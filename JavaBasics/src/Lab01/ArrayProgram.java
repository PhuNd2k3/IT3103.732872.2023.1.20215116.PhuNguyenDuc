package Lab01;
// Exercise 6.5

import java.util.Arrays;
import java.util.Scanner;

public class ArrayProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhan kich co ma tran tu nguoi dung
        System.out.print("PhuNd 215116: Enter the size of the array: ");
        int size = scanner.nextInt();

        // Khai bao mang
        int[] array = new int[size];

        // Nhap lan luot tung phan tu cua mang
        for (int i = 0; i < size; i++) {
            System.out.print("PhuNd 215116: Enter number " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Sap xep bang cach su dung Arrays.sort
        Arrays.sort(array);

        // Tinh toan tong va trung binh cua cac phan tu
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        double average = (double) sum / size;

        // In ra cac thong tin
        System.out.println("PhuNd 215116:\nSorted Array: " + Arrays.toString(array));
        // Su dung toString de in mang
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        // close scanner
        scanner.close();
    }
}
