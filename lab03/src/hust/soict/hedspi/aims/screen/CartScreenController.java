package hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.screen.addToStoreScreen.AddBookToStoreScreen;
import hust.soict.hedspi.aims.screen.addToStoreScreen.AddCDToStoreScreen;
import hust.soict.hedspi.aims.screen.addToStoreScreen.AddDVDToStoreScreen;
import hust.soict.hedspi.aims.store.Aims;
import javafx.beans.value.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private Button btnDetails;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;

	@FXML
	private TextField tfFilter;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, String> colMediaCost;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private Button btnPlaceOrder;

	@FXML
	private Label lblCost;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;

	}

	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));
		tblMedia.setItems(cart.getItemsOrdered());

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		btnDetails.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				if (newValue != null) {
					updateButtonBar(newValue);
				}
			}

		});

		tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}

		});

		updateCost();
	}

	void updateCost() {
		lblCost.setText(String.format("%.2f $", cart.totalCost()));
	}

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
		btnDetails.setVisible(true);

	}

	void showFilteredMedia(String input) {
		if (input == "") {
			tblMedia.setItems(cart.getItemsOrdered());
			return;
		}

		FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());
		if (radioBtnFilterId.isSelected())
			filteredList.setPredicate((it) -> it.getId() == Integer.parseInt(input));
		else
			filteredList.setPredicate((it) -> it.isMatch(input));

		tblMedia.setItems(filteredList);
	}

	@FXML
	void btnSortPressed(ActionEvent event) {
		tblMedia.getSortOrder().clear();

		colMediaCost.setSortType(SortType.DESCENDING);

		if (event.getSource().toString().split("\'")[1].equals("Sort by Title")) {
			tblMedia.getSortOrder().add(colMediaTitle);
			tblMedia.getSortOrder().add(colMediaCost);
		} else {
			tblMedia.getSortOrder().add(colMediaCost);
			tblMedia.getSortOrder().add(colMediaTitle);
		}

		tblMedia.sort();
	}

	@FXML
	void btnDetailsPressed(ActionEvent event) {
		new DetailScreen(tblMedia.getSelectionModel().getSelectedItem());
	}

	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		try {
			((Playable) media).play();
		} catch (PlayerException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		updateCost();
	}

	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		if (cart.getItemsOrdered().isEmpty())
			JOptionPane.showMessageDialog(null, "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
		else {
			new PlaceOrderScreen();
			updateCost();
		}
	}

	@FXML
	void menuAddBook(ActionEvent event) {
		new AddBookToStoreScreen();
	}

	@FXML
	void menuAddCd(ActionEvent event) {
		new AddCDToStoreScreen();
	}

	@FXML
	void menuAddDvd(ActionEvent event) {
		new AddDVDToStoreScreen();
	}

	@FXML
	void menuViewStore(ActionEvent event) {
		Aims.closeCartScreen();
		Aims.openStoreScreen();
	}
}