// AddDigitalVideoDiscToStoreScreen.java
package hust.soict.hedspi.aims.screen.addToStoreScreen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import hust.soict.hedspi.aims.exception.DuplicateMediaException;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Aims;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {

	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfDirector;
	private JTextField tfLength;
	private JTextField tfCost;

	public AddDVDToStoreScreen() {
		super("DVD");

		JPanel center = createCenter();
		tfTitle = addInputField("Title: *", center);
		tfCategory = addInputField("Category:", center);
		tfDirector = addInputField("Director:", center);
		tfLength = addInputField("Length:", center);
		tfCost = addInputField("Cost: *", center);
		center.add(Box.createRigidArea(new Dimension(10, 40)));

		add(center, BorderLayout.CENTER);
		add(createSouth(new ButtonListener()), BorderLayout.SOUTH);

		setVisible(true);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "OK": {
				if (tfTitle.getText().equals("") || tfCost.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Something is missing!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				DigitalVideoDisc dvd = new DigitalVideoDisc(
						tfTitle.getText(), 
						tfCategory.getText(),
						Float.parseFloat(tfCost.getText()),
						tfLength.getText().equals("") ? 0 : Integer.parseInt(tfLength.getText()),
						tfDirector.getText());
				Aims.getStore().addMedia(dvd);
				Aims.getStoreScreen().loadItemsToStore();

				setVisible(false);
				JOptionPane.showMessageDialog(null, "New DVD added to store!");
			}
				break;
			case "Cancel":
				setVisible(false);
				break;
			}
		}

	}
}