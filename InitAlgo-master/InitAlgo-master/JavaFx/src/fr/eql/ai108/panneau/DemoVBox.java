package fr.eql.ai108.panneau;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoVBox extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(30);
		Button btn1 = new Button("OK");
		Button btn2 = new Button("Cancel");
		Button btn3 = new Button("Return");
		
		root.getChildren().addAll(btn1, btn2, btn3);
		
		root.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(root, 250, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Première VBOX");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
