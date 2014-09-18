package ca.csf.Travail_Pratique_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SampleController {
	Tower[] tower = { new Tower(new ArrayStack()), new Tower(new ArrayStack()),
			new Tower(new ArrayStack()) };

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
	public void RefreshCircles() {
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
