package fr.eql.ai108.style;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DemoStyleSheet extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox(20);
		
		Button btn1 = new Button("Ok");
		Button btn2 = new Button("Cancel");
		Button btn3 = new Button("Add");
		Button btn4 = new Button("Remove");
		
		//btn1.setStyle("-fx-background-color: red");
		System.out.println(btn1.getStyleClass().size());
		System.out.println(btn1.getStyleClass().get(0));
		
		//Création d'une classe custom pour certains boutons:
		btn3.getStyleClass().add("customButton");
		btn4.getStyleClass().add("customButton");
		
		//Création un id CSS pour le 4ème bouton
		btn4.setId("bigButton");
		
		root.getChildren().addAll(btn1, btn2, btn3, btn4);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 500, 200);
		
		//Charger la feuille de style dans la Scene
		scene.getStylesheets().add(getClass().getResource("./stylesheet.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Première Feuille de Style CSS");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
