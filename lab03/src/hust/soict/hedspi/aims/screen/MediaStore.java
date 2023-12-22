package hust.soict.hedspi.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.concurrent.Flow;

// import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
// import javax.swing.JOptionPane;
import javax.swing.JPanel;

// import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {

	private Media media;

	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel(String.format("", media.getCost(), "$"));
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		container.add(new JButton("Add to cart"));

		if (media instanceof Playable) {
			container.add(new JButton("Play"));
		}

		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	// private class ButtonListener implements ActionListener {
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// String button = e.getActionCommand();
	// switch (button) {
	// case "Add to cart":
	// Aims.getCart().addMedia(media);
	// JOptionPane.showMessageDialog(null,
	// String.format("Added %s to cart.\nCurrent number of items in cart: %d",
	// media.toString(),
	// Aims.getCart().getItemsOrdered().size()));
	// break;
	// case "Play":
	// try {
	// ((Playable) media).play();
	// } catch (PlayerException e1) {
	// e1.printStackTrace();
	// }
	// break;
	// case "Details":
	// new DetailScreen(media);
	// break;
	// }
	//
	// }
	//
	// }

}
