package Lab01;
// Exercise 6.4

import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year, month;
        boolean stop = false;
        // Yeu cau nhap toi khi nam >=1 va thang tu 1-12
        do {
            System.out.print("PhuND 215116: Enter a year: ");
            year = scanner.nextInt();
            System.out.print("PhuND 215116: Enter a month: ");
            month = scanner.nextInt();

            if (year >= 1 && month >= 1 && month <= 12) {
                stop = true;
            } else {
                System.out.println("PhuND 215116: Invalid input. Try again!");
            }
        } while (!stop);

        // Su dung ham de lay so ngay trong thang
        int daysInMonth = getDaysInMonth(year, month);
        System.out.println("PhuND 215116: Number of days: " + daysInMonth);
        scanner.close();
    }

    public static int getDaysInMonth(int year, int month) {
        // Su dung mang trong do daysInMonth[i] la so ngay cua thang i
        // Thang 2 luu mac dinh 28 ngay
        // Tai i=0 khong su dung nen luu = 0
        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        // Kiem tra nam nhuan
        if (isLeapYear(year) && month == 2) {
            return 29; // Return 29 thay vi 28
        } else {
            return daysInMonth[month];
        }
    }

    public static boolean isLeapYear(int year) {
        // Nam nhuan la nam chia het cho 4 va khong chia het cho 100
        // Hoac chia het cho 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
