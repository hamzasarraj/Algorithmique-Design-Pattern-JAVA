package fr.eql.ai108.tp2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainPanel root = new MainPanel();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TP Event");
		primaryStage.sizeToScene();
		primaryStage.show();
		
		//1ère façon: gérer l'événement dans la classe d'exécution
//		root.getButtonPannel().getBlueButton().setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				root.getColorPanel().setStyle("-fx-background-color: blue");
//				
//			}
//		});
		
		//Pareil avec le handler
		ColorHandler handler = new ColorHandler(root.getColorPanel(), "blue");
		root.getButtonPannel().getBlueButton().setOnAction(handler);
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
