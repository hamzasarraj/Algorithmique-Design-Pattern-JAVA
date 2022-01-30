package fr.eql.ai108.tp2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPanel extends HBox {
	
	private Button redButton = new Button("Rouge");
	private Button blueButton = new Button("Bleu");
	private Button greenButton = new Button("Vert");
	private Button orangeButton = new Button("Orange");
	
	public ButtonPanel() {
		getChildren().addAll(redButton, blueButton, greenButton, orangeButton);
		setSpacing(5);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(5));
		
		//3ème méthode: géréer l'événement là où il est provoqué
		greenButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//Où que je sois, je peux récupérer mon panneau principal
				MainPanel root = (MainPanel) getScene().getRoot();
				root.getColorPanel().setStyle("-fx-background-color: green");			
			}
		});
	}

	public Button getRedButton() {
		return redButton;
	}

	public Button getBlueButton() {
		return blueButton;
	}

	public Button getGreenButton() {
		return greenButton;
	}

	public Button getOrangeButton() {
		return orangeButton;
	}

	public void setRedButton(Button redButton) {
		this.redButton = redButton;
	}

	public void setBlueButton(Button blueButton) {
		this.blueButton = blueButton;
	}

	public void setGreenButton(Button greenButton) {
		this.greenButton = greenButton;
	}

	public void setOrangeButton(Button orangeButton) {
		this.orangeButton = orangeButton;
	}

}
