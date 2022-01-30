package fr.eql.ai108.evenement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PremierEvenement extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox(20);
		TextField saisie = new TextField();
		Button btn = new Button("Recopier");
		Label copie = new Label("Vide");
		
		root.getChildren().addAll(saisie, btn, copie);
		root.setStyle("-fx-background-color: hotpink");
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 400, 100);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Premier évènement");
		primaryStage.show();
		
		//J'appelle la méthode setOnAction sur le bouton qui provoque l'événement
		//Première solution: je lui passe en argument une classe anonyme interne
		//de EventHandler<ActionEvent>()
//		btn.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				copie.setText(saisie.getText());
//				
//			}
//		});
		
		//Idem avec une expression lambda
		btn.setOnAction((event) -> copie.setText(saisie.getText()));

	}

	public static void main(String[] args) {
		launch(args);

	}

}
