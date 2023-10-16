package Lab01;

import javax.swing.JOptionPane;

public class SolveEquation {
    public static void main(String[] args) {
        // Yêu cầu người dùng nhập loại phương trình cần giải
        String equationType = JOptionPane.showInputDialog(
                "Choose type of equation:\n"
                + "1. Linear equation (ax + b = 0)\n"
                + "2. Linear system with two variables\n"
                + "3. Second-degree equation  (ax^2 + bx + c = 0)");

        switch (equationType) {
            case "1":
                solveLinearEquation();
                break;
            case "2":
                solveLinearSystem();
                break;
            case "3":
                solveQuadraticEquation();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Not an option");
                break;
        }
    }

    public static void solveLinearEquation() {
        // Nhập các tham số
        String aStr = JOptionPane.showInputDialog("PhuNd 215116: Enter a:");
        String bStr = JOptionPane.showInputDialog("PhuNd 215116: Enter b:");

        // Chuyển đổi sang kiểu double
        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        // Giải phương trình theo 2 trường hợp
        // Nếu a khác 0 thì pt có nghiệm
        // Nếu a bằng 0 thì báo lỗi
        if (a != 0) {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Solution x = " + x, "PhuND 20215116 tell you",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error because a = 0", "PhuND 20215116 tell you",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void solveLinearSystem() {
        // Nhập các tham số
        String a11Str = JOptionPane.showInputDialog("PhuNd 215116: Enter a_11:");
        String a12Str = JOptionPane.showInputDialog("PhuNd 215116: Enter a_12:");
        String b1Str = JOptionPane.showInputDialog("PhuNd 215116: Enter b_1:");
        String a21Str = JOptionPane.showInputDialog("PhuNd 215116: Enter a_21:");
        String a22Str = JOptionPane.showInputDialog("PhuNd 215116: Enter a_22:");
        String b2Str = JOptionPane.showInputDialog("PhuNd 215116: Enter b_2:");

        // Chuyển đổi sang kiểu double
        double a11 = Double.parseDouble(a11Str);
        double a12 = Double.parseDouble(a12Str);
        double b1 = Double.parseDouble(b1Str);
        double a21 = Double.parseDouble(a21Str);
        double a22 = Double.parseDouble(a22Str);
        double b2 = Double.parseDouble(b2Str);

        // Tính các định thức
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        // Nếu D khác 0 hệ pt luôn có nghiệm
        // Nếu D bằng 0 tùy thuộc vào D1 D2 xem hệ vô nghiệm hay vô số nghiệm
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Solution:\nx_1 = " + x1 + "\nx_2 = " + x2, "PhuND 20215116 tell you",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions!", "PhuND 20215116 tell you",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No solution!", "PhuND 20215116 tell you",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void solveQuadraticEquation() {
        // Nhập các tham số
        String aStr = JOptionPane.showInputDialog("PhuND 215116: Enter a:");
        String bStr = JOptionPane.showInputDialog("PhuND 215116: Enter b:");
        String cStr = JOptionPane.showInputDialog("PhuND 215116: Enter c:");

        // Chuyển đổi sang kiểu double
        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        double c = Double.parseDouble(cStr);

        // Tính giá trị delta
        double delta = b * b - 4 * a * c;

        // Nếu a khác 0 thì giải theo công thức nghiệm bậc 2
        // TH1: delta dương pt có 2 no phân biệt
        // TH2: delta = 0 pt có nghiệm kép
        // TH3: Pt không có nghiệm thực
        // Nếu a bằng 0 thì báo lỗi
        if (a != 0) {
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Solution:\nx1 = " + x1 + "\nx2 = " + x2, "PhuND 20215116 tell you",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Solution:\nx = " + x, "PhuND 20215116 tell you",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No real solution found", "PhuND 20215116 tell you",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error because a = 0", "PhuND 20215116 tell you",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
