package Lab01;

// Exercise 6.3
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        // Su dung scanner de nhap chieu cao
        Scanner scanner = new Scanner(System.in);

        int n;
        // Kiem tra chieu cao phai la so duong
        // Yeu cau nhap lai neu khong phai
        do {
            System.out.print("PhuND 215116: Enter height: ");
            n = scanner.nextInt();
            if(n<=0) System.out.println("PhuND 215116: Must be positive");
        } while (n <= 0);
        // So lan chay cua for tuong ung voi n
        for (int i = 1; i <= n; i++) {
            // In khoang trong
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // In dau sao
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            // Khong can in khoang trong sau dau *
            System.out.println(); // Xuong dong tiep theo
        }
        scanner.close();
    }
}
