package fr.eql.ai108.panneau;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DemoFlowPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Le flowpane agence ses éléments enfants en fonction de l'espace disponible
		FlowPane root = new FlowPane();
		
		Button btn1 = new Button("Bouton 1");
		Button btn2 = new Button("Bouton 2");
		Button btn3 = new Button("Bouton 3");
		Button btn4 = new Button("Bouton 4");
		Button btn5 = new Button("Bouton 5");
		Button btn6 = new Button("Bouton 6");
		Button btn7 = new Button("Bouton 7");
		Button btn8 = new Button("Bouton 8");
		
		root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);
		
		//Modifier l'orientation par défaut
		root.setOrientation(Orientation.VERTICAL);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premier FlowPane");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
