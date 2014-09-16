package ca.csf.Travail_Pratique_1;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class SampleController {
	@FXML
	private VBox tour1Vbox;

	@FXML
	private VBox tour2Vbox;
	
	@FXML
	private VBox tour3Vbox;
	
	@FXML
	public void ajoutertour(){
		Rectangle rectangle = new Rectangle(300,50);
		 tour1Vbox.getChildren().add(rectangle);
	}
	
		Rectangle[] listeRectangle = new Rectangle[6];
	
// il faut rentrer en propriété le numero de la tour
 // Une fonction pour créer tout les rectangles d'une tower
// On va prendre la largueur du rectangle par le Disk de la classe Tower
// Loop pour chaque rectangle


}