package fr.eql.ai108.panneau;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DemoBorderPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		//On instancie quelques éléments à positionner sur le BorderPane
		
		Label lblBottom = new Label("Label d'en bas");
		Label lblRight = new Label("Label de droite");
		Button btnCenter = new Button("Bouton du centre");
		Pane topPanel = new Pane();
		topPanel.setPrefSize(800, 100);
		topPanel.setStyle("-fx-background-color: blue");
		Pane leftPanel = new Pane();
		leftPanel.setPrefSize(200, 700);
		leftPanel.setStyle("-fx-background-color: red");
		
		//Le BorderPane dipose de méthodes spécifiques pour positionner ses éléments
		//enfants		
		root.setBottom(lblBottom);
		root.setRight(lblRight);
		root.setCenter(btnCenter);
		root.setTop(topPanel);
		root.setLeft(leftPanel);
		
		Scene scene = new Scene(root, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premier BorderPane");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
