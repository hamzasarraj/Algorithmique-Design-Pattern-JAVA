package fr.eql.ai108.transition;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstPan extends HBox {
	
	private Button btn = new Button("Changer de scène");

	public FirstPan() {
		setPrefSize(400, 200);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: hotpink");
		getChildren().add(btn);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//On instancie notre SecondPan
				SecondPan root = new SecondPan();
				//On instancie une nouvelle scene
				Scene scene = new Scene(root);
				//Récupérer le stage en cours pour lui transmettre la nouvelle scene
				Stage stage = (Stage) getScene().getWindow();
				stage.setScene(scene);
				
			}
		});
	}

	public Button getBtn() {
		return btn;
	}

	public void setBtn(Button btn) {
		this.btn = btn;
	}
}
