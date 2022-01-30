package fr.eql.ai108.transition;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SecondPan extends HBox {
	
	private Label lbl = new Label("Transition réussie !");

	public SecondPan() {
		setPrefSize(400, 200);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: teal");
		lbl.setTextFill(Color.WHITE);
		getChildren().add(lbl);
	}

	public Label getLbl() {
		return lbl;
	}

	public void setLbl(Label lbl) {
		this.lbl = lbl;
	}
	
	
	
}
