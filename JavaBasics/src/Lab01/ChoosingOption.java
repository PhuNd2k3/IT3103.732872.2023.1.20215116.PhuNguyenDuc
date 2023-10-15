package Lab01;

// Exercise 6.1
import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"PhuNd 215116 ask you: Do you want to change the first class ticket?");
		JOptionPane.showMessageDialog(null,
				"PhuNd 215116 return to you: You've choosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		System.exit(0);
	}
}
