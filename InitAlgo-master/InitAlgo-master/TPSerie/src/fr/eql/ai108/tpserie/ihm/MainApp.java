package fr.eql.ai108.tpserie.ihm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//La classe de lancement de l'application:
public class MainApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {		
		MainPannel root = new MainPannel();
		stage.setTitle("TP Séries");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}