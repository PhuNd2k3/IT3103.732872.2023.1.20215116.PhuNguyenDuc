package Lab01;

import javax.swing.JOptionPane;

public class CaculateTwoDoubleNumbers {

    public static void main(String[] args) {

        // Sử dụng InputDialog để nhập 2 số
        String strNum1 = JOptionPane.showInputDialog("PhuND 20215116: Please enter the first number:");

        String strNum2 = JOptionPane.showInputDialog("PhuND 20215116: Please enter the second number:");

        // Chuyển đổi sang double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Tính tổng, hiệu, tích còn thương xét riêng
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        double quotient = 0;

        // Thêm các kết quả vào resultMessage
        String resultMessage = "Sum: " + sum + "\n"
                + "Difference: " + difference + "\n"
                + "Product: " + product + "\n";

        // Kiểm tra nếu số thứ hai không bằng 0 trước khi tính thương
        if (num2 != 0) {
            quotient = num1 / num2;

            resultMessage += "Quotient: " + quotient;
        } else {
            resultMessage += "Quotient: Error because number 2 is 0";
        }

        // Hiển thị các kết quả
        JOptionPane.showMessageDialog(null, resultMessage, "PhuND 20215116: This is your result",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
