package hust.soict.hedspi.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame{
	// Nguyen Duc Phu Lab05 GUI
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;
	
	public NumberGrid(){
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JPanel panelButtons = new JPanel(new GridLayout(4,3));
		addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Phu 20215116: Number Grid");
		setSize(200,200);
		setVisible(true);
	}

	void addButtons(JPanel panelButtons) {
		 ButtonListener btnListener = new ButtonListener();
		 for (int i = 1 ; i <= 9 ; i++) {
			 btnNumbers[i] = new JButton("" + i);
			 panelButtons.add(btnNumbers[i]);
			 btnNumbers[i].addActionListener(btnListener);
		 }
		 
		 btnDelete = new JButton("DEL");
		 panelButtons.add(btnDelete);
		 btnDelete.addActionListener(btnListener);
		 
		 btnNumbers[0] = new JButton("0");
		 panelButtons.add(btnNumbers[0]);
		 btnNumbers[0].addActionListener(btnListener);
		 
		 btnReset = new JButton("C");
		 panelButtons.add(btnReset);
		 btnReset.addActionListener(btnListener);
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String button = e.getActionCommand();
			if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + button);
			}
			else if (button.equals("DEL")) {
				int number = Integer.parseInt(tfDisplay.getText());
				number = number / 10;
				tfDisplay.setText(Integer.toString(number));
			}
			else {
				tfDisplay.setText("");
			}
		}
		
	}
	public static void main(String[] args) {
		new NumberGrid();
	}
}
