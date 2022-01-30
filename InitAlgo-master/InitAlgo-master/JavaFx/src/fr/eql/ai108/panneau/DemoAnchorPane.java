package fr.eql.ai108.panneau;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DemoAnchorPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = new AnchorPane();
		FlowPane panel = new FlowPane();
		panel.setPrefSize(100, 100);
		panel.setStyle("-fx-background-color:teal");
		root.getChildren().add(panel);
		
		//Définition des ancres
		AnchorPane.setBottomAnchor(panel, 5.);
		AnchorPane.setRightAnchor(panel, 5.);
		AnchorPane.setTopAnchor(panel, 5.);
		AnchorPane.setLeftAnchor(panel, 5.);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premier AnchorPane");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
