package ca.csf.Travail_Pratique_1;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class GameController {
	Tower[] tower = { new Tower(new ArrayStack(3)),
			new Tower(new ArrayStack(3)), new Tower(new ArrayStack(3)) };
	private Disk currentRectangle;

	private int nbDisk;

	@FXML
	private BorderPane parent;

	@FXML
	private Button enl1;
	@FXML
	private Button enl2;
	@FXML
	private Button enl3;
	@FXML
	private Button dep1;
	@FXML
	private Button dep2;
	@FXML
	private Button dep3;

	@FXML
	private VBox tour1VBox;
	@FXML
	private VBox tour2VBox;
	@FXML
	private VBox tour3VBox;
	@FXML
	private VBox currentRecHBox;

	VBox[] vbox = {tour1VBox, tour2VBox, tour3VBox};
	
	@FXML
	public void startNewGame(ActionEvent actionEvent) {
		Color[] color = { Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE,
				Color.RED, Color.PURPLE };
		Button button = (Button) actionEvent.getSource();
		nbDisk = Integer.parseInt(button.getId());

		for (int i = 0; i < nbDisk; ++i) {
			tower[0].addDisk(new Disk((350 - i * 50), (color[i])));
		}

		updateGraphics();

		
	}

	@FXML
	public void enleverDisk(ActionEvent actionEvent) {
		// --- Disable buttons

		enl1.setDisable(true);
		enl2.setDisable(true);
		enl3.setDisable(true);

		if (actionEvent.getSource() == enl1) {
			currentRectangle = tower[0].removeDisk();
		} else if (actionEvent.getSource() == enl2) {
			currentRectangle = tower[1].removeDisk();
		} else {
			currentRectangle = tower[2].removeDisk();
		}

		// --- Disable buttons Si le disque au top de la tour doit être plus
		// grande

		if (currentRectangle.getSize() > tower[0].getDiskOnTop().getSize()) {
			dep1.setDisable(true);
		} else {
			dep1.setDisable(false);
		}
		if (currentRectangle.getSize() > tower[1].getDiskOnTop().getSize()) {
			dep2.setDisable(true);
		} else {
			dep2.setDisable(false);
		}
		if (currentRectangle.getSize() > tower[2].getDiskOnTop().getSize()) {
			dep3.setDisable(true);
		} else {
			dep3.setDisable(false);
		}
		// --- End Disable Buttons

		updateGraphics();
	}

	@FXML
	public void deposerDisk(ActionEvent actionEvent) {

		if (actionEvent.getSource() == enl1) {
			tower[0].addDisk(currentRectangle);
		} else if (actionEvent.getSource() == enl2) {
			tower[1].addDisk(currentRectangle);
		} else {
			tower[2].addDisk(currentRectangle);
		}

		currentRectangle = null;

		if (tower[0].getSize() != 0) {
			enl1.setDisable(false);
		}
		if (tower[1].getSize() != 0) {
			enl2.setDisable(false);
		}
		if (tower[2].getSize() != 0) {
			enl3.setDisable(false);
		}
		dep1.setDisable(true);
		dep2.setDisable(true);
		dep3.setDisable(true);

		if (tower[2].getSize() == nbDisk) {
			try {
				Stage stage = new Stage();

				stage.setScene(new Scene(FXMLLoader.load(getClass()
						.getResource("MessageBox.fxml"))));

				stage.initOwner(parent.getScene().getWindow());
				stage.initModality(Modality.WINDOW_MODAL);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		updateGraphics();
	}

	@FXML
	public void RefreshDisks() {

		tour1VBox.getChildren().clear();
		tour2VBox.getChildren().clear();
		tour3VBox.getChildren().clear();

		if (currentRecHBox != null) {
			Rectangle rectangleCurrent = new Rectangle(
					currentRectangle.getSize(), 50);
			rectangleCurrent.setFill(currentRectangle.getColor());
			currentRecHBox.getChildren().add(rectangleCurrent);
		} else {
			currentRecHBox.getChildren().clear();
		}

		for (int i = 0; i < 3; i++) {
			if (tower[i].getSize() > -1) {
				for (int x = tower[i].getSize(); x > 0; x--) {
					Rectangle rectangle = new Rectangle(tower[x].getDiskAt(x)
							.getSize(), 50);
					rectangle.setFill(tower[x].getDiskAt(x).getColor());


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


	public void updateGraphics(){
		
		for(int i = 0; i < 3; ++i ){
			if(tower[i].getSize() != 0){
				vbox[i].getChildren().clear();
				for(int j = 0; j < tower[i].getSize(); ++j ){
					Rectangle rectangle = new Rectangle(tower[i].getDiskAt(tower[i].getSize()-j).getSize(),50);
					rectangle.setFill(tower[i].getDiskAt(j).getColor());
					vbox[i].getChildren().add(rectangle);
				} 
			}
		} 
		
	}
}
