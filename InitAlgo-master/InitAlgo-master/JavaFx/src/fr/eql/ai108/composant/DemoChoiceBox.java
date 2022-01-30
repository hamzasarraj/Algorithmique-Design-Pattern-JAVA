package fr.eql.ai108.composant;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DemoChoiceBox extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox(10);
		Label lbl = new Label();
		//On instancie notre menu déroulant:
		ChoiceBox<String> choiceBox = new ChoiceBox<String>();
		
		//On ajoute des valeurs sélectionnables dans la ChoiceBox
		choiceBox.getItems().addAll("Ville:", "Paris", "Ouagadougou", "Mexico", "Berlin");
		root.getChildren().addAll(choiceBox, lbl);
		choiceBox.getSelectionModel().select(0);
		
		root.setStyle("-fx-background-color: cyan");
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 500, 100);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Première ChoiceBox");
		primaryStage.sizeToScene();
		primaryStage.show();
		
		choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				lbl.setText(oldValue + " => " + newValue);
				
			}
		});
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
