// Example 5: ShowTwoNumbers.java
package Lab01;

import javax.swing.JOptionPane;

public class ShowTwoNumbers {

        public static void main(String[] args) {
                String strNuml, strNum2;
                String strNotification = "You've just entered: ";
                strNuml = JOptionPane.showInputDialog(null, "Nguyen Duc Phu 20215116 - Please input the first number: ",
                                "Nguyen Duc Phu 20215116 - Input the first number",
                                JOptionPane.INFORMATION_MESSAGE);
                strNotification += strNuml + " and ";

                strNum2 = JOptionPane.showInputDialog(null,
                                "Nguyen Duc Phu 20215116 - Please input the second number: ",
                                "Nguyen Duc Phu 20215116 - Input the second number",
                                JOptionPane.INFORMATION_MESSAGE);

                strNotification += strNum2;

                JOptionPane.showMessageDialog(null, strNotification, "Nguyen Duc Phu 20215116 - Show two numbers",
                                JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }
}
