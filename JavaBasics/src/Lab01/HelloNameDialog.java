package Lab01;

//Example 3: HelloNameDialog.java
import javax.swing.JOptionPane;

public class HelloNameDialog {

    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Nguyen Duc Phu -20215116 Please enter your name:");
        JOptionPane.showMessageDialog(null, "Toi la Phu. Hi " + result + "!");
    }
}