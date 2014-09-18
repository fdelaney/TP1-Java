package ca.csf.Travail_Pratique_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameController {
	Tower[] tower = { new Tower(new ArrayStack(3)), new Tower(new ArrayStack(3)),
			new Tower(new ArrayStack(3)) };

	private Disk currentRectangle = null;
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

	public void DeposerTour(ActionEvent actionEvent){
		
		Enl1.setDisable(false);
		Enl2.setDisable(false);
		Enl3.setDisable(false);
		Dep1.setDisable(true);
		Dep2.setDisable(true);
		Dep3.setDisable(true);
		
		if(actionEvent.getSource() == Dep1){
			tower[0].addDisk(currentRectangle);
		}
		else if(actionEvent.getSource() == Dep2){
			tower[1].addDisk(currentRectangle);
		}
		else if(actionEvent.getSource() == Dep3){
			tower[2].addDisk(currentRectangle);
		}
		currentRectangle = null;
		RefreshDisks();
	}
	
	
	
	@FXML
	public void RefreshDisks() {
		for (int i = 0; i < 3; i++) {
			if (tower[i].getSize() > -1) {
				for (int x = tower[i].getSize(); x > 0; x--) {
					Rectangle rectangle = new Rectangle(tower[x].getDiskAt(x)
							.getSize(), 50);
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
		boolean confirmation = false;
		int NbOfTheColor = 0;

		while (confirmation = false || NbOfTheColor > 5) {
			if (rectangle.getWidth() == width) {

				rectangle.setFill(Color.valueOf(color[NbOfTheColor]));
				confirmation = true;
			}
			width = width + 10;
			NbOfTheColor++;
		}

		return rectangle;
	}
}
// il faut rentrer en propriété le numero de la tour
// Une fonction pour créer tout les rectangles d'une tower
// On va prendre la largueur du rectangle par le Disk de la classe Tower
// Loop pour chaque rectangle
