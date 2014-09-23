package ca.csf.Travail_Pratique_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameController {
	Tower[] tower = { new Tower(new ArrayStack(3)),
			new Tower(new ArrayStack(3)), new Tower(new ArrayStack(3)) };
	private Disk currentRectangle;

	@FXML
	private Button Enl1;
	@FXML
	private Button Enl2;
	@FXML
	private Button Enl3;
	@FXML
	private Button Dep1;
	@FXML
	private Button Dep2;
	@FXML
	private Button Dep3;

	@FXML
	private VBox tour1Vbox;
	@FXML
	private VBox tour2Vbox;
	@FXML
	private VBox tour3Vbox;
	@FXML
	private VBox currentRec;

	private void StartNewGame(){
		
	}
	
	@FXML
	public void VerificationTours() {

	}

	public void EnleverTour(ActionEvent actionEvent) {
		// --- Disable buttons

		Enl1.setDisable(true);
		Enl2.setDisable(true);
		Enl3.setDisable(true);

		if (actionEvent.getSource() == Enl1) {
			currentRectangle = tower[0].removeDisk();
		} else if (actionEvent.getSource() == Enl2) {
			currentRectangle = tower[1].removeDisk();
		} else {
			currentRectangle = tower[2].removeDisk();
		}

		// --- Disable buttons Si le disque au top de la tour doit être plus
		// grande
		if (currentRectangle.getSize() > tower[0].getDiskOnTop().getSize()) {
			Dep1.setDisable(true);
		} else {
			Dep1.setDisable(false);
		}
		if (currentRectangle.getSize() > tower[1].getDiskOnTop().getSize()) {
			Dep2.setDisable(true);
		} else {
			Dep2.setDisable(false);
		}
		if (currentRectangle.getSize() > tower[2].getDiskOnTop().getSize()) {
			Dep3.setDisable(true);
		} else {
			Dep3.setDisable(false);
		}
		// --- End Disable Buttons

		RefreshDisks();
	}

	public void DeposerTour(ActionEvent actionEvent) {

		if (actionEvent.getSource() == Enl1) {
			tower[0].addDisk(currentRectangle);
		} else if (actionEvent.getSource() == Enl2) {
			tower[1].addDisk(currentRectangle);
		} else {
			tower[2].addDisk(currentRectangle);
		}

		currentRectangle = null;
		
		if (tower[0].getSize() != 0) {
			Enl1.setDisable(false);
		}
		if (tower[1].getSize() != 0) {
			Enl2.setDisable(false);
		}
		if (tower[2].getSize() != 0) {
			Enl3.setDisable(false);
		}
		Dep1.setDisable(true);
		Dep2.setDisable(true);
		Dep3.setDisable(true);


		RefreshDisks();
	}

	@FXML
	public void RefreshDisks() {

		tour1Vbox.getChildren().clear();
		tour2Vbox.getChildren().clear();
		tour3Vbox.getChildren().clear();

		if (currentRectangle != null) {
			Rectangle rectangleCurrent = new Rectangle(
					currentRectangle.getSize(), 50);
			rectangleCurrent = ColorOfRectangle(rectangleCurrent);
			currentRec.getChildren().add(rectangleCurrent);
		} else {
			currentRec.getChildren().clear();
		}

		for (int i = 0; i < 3; i++) {
			if (tower[i].getSize() > -1) {
				for (int x = tower[i].getSize(); x > 0; x--) {
					Rectangle rectangle = new Rectangle(tower[x].getDiskAt(x).getSize(), 50);
					rectangle = ColorOfRectangle(rectangle);

					if (i == 0) {
						tour1Vbox.getChildren().add(rectangle);
					} else if (i == 1) {
						tour2Vbox.getChildren().add(rectangle);
					} else {
						tour3Vbox.getChildren().add(rectangle);
					}
				}
			}
		}
	}

	public Rectangle ColorOfRectangle(Rectangle rectangle) {
		String[] color = { "BLUE", "GREEN", "YELLOW", "ORANGE", "RED", "PURPLE" };

		int width = 50;

		int NbOfTheColor = 0;

		while (NbOfTheColor > 5) {
			if (rectangle.getWidth() == width) {

				rectangle.setFill(Color.valueOf(color[NbOfTheColor]));
				break;
			}
			width = width + 10;
			NbOfTheColor++;
		}

		return rectangle;
	}
}