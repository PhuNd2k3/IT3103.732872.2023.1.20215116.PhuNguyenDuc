package hust.soict.hedspi.javafx.paintpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private RadioButton eraser;

	@FXML
	private Pane drawingAreaPane;

	@FXML
	private RadioButton pen;

	@FXML
	private ToggleGroup tools;

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		RadioButton radioButton = (RadioButton) tools.getSelectedToggle();
		String selectedText = radioButton.getText();
		Circle newCircle = new Circle(event.getX(), event.getY(), 4);
		// System.out.println(selectedText);
		if (selectedText.equals("Pen")) {
			newCircle.setFill(Color.BLACK);
		} else {
			newCircle.setFill(Color.WHITE);
		}
		drawingAreaPane.getChildren().add(newCircle);
	}

	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}

}
