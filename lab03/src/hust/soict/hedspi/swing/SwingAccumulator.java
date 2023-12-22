package hust.soict.hedspi.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame{
	// Nguyen Duc Phu 20215116: Lab 05 GUI
	private JTextField tfInput;
	private JTextField tfOuput;
	private int sum = 0;
	
	public SwingAccumulator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,2));
		
		cp.add(new JLabel("Enter an Integer : "));
		
		tfInput = new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		cp.add(new JLabel("The Accumulator Sum is : "));
		
		tfOuput = new JTextField(10);
		tfOuput.setEditable(false);
		cp.add(tfOuput);
		setTitle("Phu 20215116: Swing Accumulator");
		setSize(350, 120);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new SwingAccumulator();
	}
	
	private class TFInputListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOuput.setText(sum + "");
		}
		
	}

}
