package hust.soict.hedspi.aims.screen;

import java.util.*;
import javax.swing.*;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Aims;

import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.text.SimpleDateFormat;

public class PlaceOrderScreen {

	public PlaceOrderScreen() {
		showDeliveryInfoScreen();
	}

	void showDeliveryInfoScreen() {
		JFrame frame = new JFrame("Delivery Information");

		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		frame.add(Box.createRigidArea(new Dimension(10, 20)));
		JLabel lblPrompt = new JLabel("Please enter your delivery information");
		lblPrompt.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		frame.add(lblPrompt);
		frame.add(Box.createRigidArea(new Dimension(10, 20)));

		addInputField(frame, "Name:");
		addInputField(frame, "Email:");
		addInputField(frame, "Phone:");
		addInputField(frame, "Address:");
		addInputField(frame, "Note:");
		frame.add(Box.createVerticalGlue());

		addButtons(frame, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "OK":
					frame.setVisible(false);
					showInvoiceScreen();
					break;
				case "Cancel":
					frame.setVisible(false);
					break;
				}
			}
		});

		frame.setBounds(450, 200, 320, 350);
		frame.setVisible(true);
	}

	void showInvoiceScreen() {
		JFrame frame = new JFrame("Invoice");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		frame.add(Box.createRigidArea(new Dimension(10, 15)));
		JLabel lblInvoice = new JLabel("INVOICE");
		lblInvoice.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		frame.add(lblInvoice);
		frame.add(Box.createRigidArea(new Dimension(10, 15)));

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel lblList = new JLabel("Ordered items list:");
		lblList.setFont(new Font(lblList.getFont().getName(), Font.BOLD, 12));
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(lblList);
		frame.add(panel);

		for (Media m : Aims.getCart().getItemsOrdered()) {
			JPanel panelItem = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel lblItem = new JLabel(String.format("- %s : %.2f $", m.getTitle(), m.getCost()));
			lblItem.setFont(new Font(lblItem.getFont().getName(), Font.PLAIN, 12));
			panelItem.add(Box.createRigidArea(new Dimension(20, 10)));
			panelItem.add(lblItem);
			frame.add(panelItem);
		}

		float cost = Aims.getCart().totalCost();
		float vat = cost * 0.1f;
		float deliveryFee = new Random().nextFloat(1, 5);
		float totalCost = cost + vat + deliveryFee;

		addInfoLine(frame, "Cost of items:", String.format("%.2f $", cost));
		addInfoLine(frame, "VAT:", String.format("%.2f $", vat));
		addInfoLine(frame, "Delivery fee:", String.format("%.2f $", deliveryFee));
		addInfoLine(frame, "Total cost:", String.format("%.2f $", totalCost));

		frame.add(Box.createVerticalGlue());
		addButtons(frame, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "OK":
					frame.setVisible(false);
					showPaymentScreen(totalCost);
					break;
				case "Cancel":
					frame.setVisible(false);
					break;
				}

			}
		});

		frame.setBounds(450, 150, 320, 450);
		frame.setVisible(true);
	}

	void showPaymentScreen(float totalCost) {
		JFrame frame = new JFrame("Payment Information");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		frame.add(Box.createRigidArea(new Dimension(10, 15)));
		JLabel lblPrompt = new JLabel("Enter your credit card information:");
		lblPrompt.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		frame.add(lblPrompt);
		frame.add(Box.createRigidArea(new Dimension(10, 15)));

		int labelWidth = 85;

		JPanel panel = new JPanel(new FlowLayout());
		JLabel lblCardHolder = new JLabel("Card holder:");
		lblCardHolder.setPreferredSize(new Dimension(labelWidth, 20));
		panel.add(lblCardHolder);
		JTextField tfCardHolder = new JTextField(15);
		panel.add(tfCardHolder);
		frame.add(panel);

		addInputField(frame, "Card number:", labelWidth);
		addInputField(frame, "Exp. date:", labelWidth);
		addInputField(frame, "CVV code:", labelWidth);

		frame.add(Box.createVerticalGlue());
		addButtons(frame, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "OK":
					frame.setVisible(false);
					showTransactionInfoScreen(tfCardHolder.getText(), totalCost);
					break;
				case "Cancel":
					frame.setVisible(false);
					break;
				}
			}
		});

		frame.setBounds(450, 200, 320, 350);
		frame.setVisible(true);
	}

	void showTransactionInfoScreen(String cardHolder, float totalCost) {
		JFrame frame = new JFrame("Transaction Information");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		frame.add(Box.createRigidArea(new Dimension(10, 20)));
		JLabel label = new JLabel("Please confirm your transaction information");
		label.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		frame.add(label);
		frame.add(Box.createRigidArea(new Dimension(10, 20)));

		addInfoLine(frame, "Transaction ID:", generateTransactionId(10));
		addInfoLine(frame, "Card holder:", cardHolder);
		addInfoLine(frame, "Transaction Amount", String.format("%.2f $", totalCost));
		addInfoLine(frame, "Transaction Date:", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

		frame.add(Box.createRigidArea(new Dimension(10, 40)));
		addButtons(frame, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "OK":
					frame.setVisible(false);
					Aims.getCart().placeOrder();
					JOptionPane.showMessageDialog(null, "Your order is now pending!");
					break;
				case "Cancel":
					frame.setVisible(false);
				}
			}
		});

		frame.setBounds(450, 200, 320, 350);
		frame.setVisible(true);
	}

	String generateTransactionId(int length) {
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();

		for (int i = 0; i < length; i++)
			sb.append((char) new int[] { rd.nextInt(48, 58), rd.nextInt(65, 91), rd.nextInt(97, 123) }[rd.nextInt(3)]);

		return sb.toString();
	}

	void addInputField(JFrame frame, String label, int labelWidth) {
		JPanel panel = new JPanel(new FlowLayout());

		JLabel lblLabel = new JLabel(label);
		lblLabel.setPreferredSize(new Dimension(labelWidth, 20));
		panel.add(lblLabel);

		JTextField tfInput = new JTextField(15);
		panel.add(tfInput);

		frame.add(panel);
	}

	void addInputField(JFrame frame, String label) {
		addInputField(frame, label, 60);
	}

	void addInfoLine(JFrame frame, String label, String info) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(Box.createRigidArea(new Dimension(10, 10)));

		JLabel lblLabel = new JLabel(label);
		lblLabel.setFont(new Font(lblLabel.getFont().getName(), Font.BOLD, 12));
		panel.add(lblLabel);

		JLabel lblInfo = new JLabel((info == null || info.equals("")) ? "Unknown" : info);
		lblInfo.setFont(new Font(lblInfo.getFont().getName(), Font.PLAIN, 12));
		panel.add(lblInfo);

		frame.add(panel);
	}

	void addButtons(JFrame frame, ActionListener listener) {
		JPanel panel = new JPanel(new FlowLayout());

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(listener);
		panel.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(listener);
		panel.add(btnCancel);

		frame.getRootPane().setDefaultButton(btnOk);
		btnOk.requestFocus();

		frame.add(panel);
	}
}