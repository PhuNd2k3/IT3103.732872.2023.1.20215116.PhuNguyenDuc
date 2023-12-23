// AddItemToStoreScreen.java
package hust.soict.hedspi.aims.screen.addToStoreScreen;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
	public AddItemToStoreScreen(String itemType) {
		super("Add new " + itemType);
		Container cp = getContentPane();
		setBounds(450, 150, 300, 400);
		setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

		JLabel prompt = new JLabel("Please enter new " + itemType + "\'s information");
		prompt.setAlignmentX(CENTER_ALIGNMENT);
		north.add(Box.createRigidArea(new Dimension(10, 30)));
		north.add(prompt);
		north.add(Box.createRigidArea(new Dimension(10, 30)));

		add(north, BorderLayout.NORTH);
	}

	public JTextField addInputField(String fieldName, JPanel panel) {
		JPanel p = new JPanel(new FlowLayout());

		JLabel label = new JLabel(fieldName);
		label.setPreferredSize(new Dimension(60, 20));
		p.add(label);

		JTextField textField = new JTextField(15);
		p.add(textField);

		panel.add(p);

		return textField;
	}

	public JPanel createCenter() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		return panel;
	}

	public JPanel createSouth(ActionListener listener) {
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));

		JLabel note = new JLabel("(*: required fields)");
		note.setFont(new Font(note.getFont().getName(), Font.ITALIC | Font.BOLD, 12));
		note.setAlignmentX(CENTER_ALIGNMENT);
		outerPanel.add(note);

		JPanel innerPanel = new JPanel(new FlowLayout());
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(listener);
		innerPanel.add(btnOk);
		this.getRootPane().setDefaultButton(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(listener);
		innerPanel.add(btnCancel);

		outerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		outerPanel.add(innerPanel);
		outerPanel.add(Box.createRigidArea(new Dimension(10, 20)));

		return outerPanel;
	}

}
