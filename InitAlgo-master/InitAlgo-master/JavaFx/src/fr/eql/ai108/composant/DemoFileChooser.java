package fr.eql.ai108.composant;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DemoFileChooser extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(5);
		
		Button btn = new Button("Browse");
		Label lbl = new Label();
		root.getChildren().addAll(btn, lbl);
		
		root.setStyle("-fx-background-color: teal");
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premier FileChooser");
		primaryStage.sizeToScene();
		primaryStage.show();
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				
				//SI je souhaite que l'explorateur de fichier s'ouvre à un emplacement précis
				File initDir = new File("C:/Users/formation/desktop");
				fileChooser.setInitialDirectory(initDir);
				
				//J'ouvre une pop up qui va permettre à l'utilisateur de choisir un fichier
				File f = fileChooser.showOpenDialog(primaryStage.getOwner());
				
				if(f != null) {
					//J'affiche dans le label le chemin absolu du fichier sélectionné
					//par l'utilisateur:
					lbl.setText(f.getAbsolutePath());
				}
				
			}
		});

	}

	public static void main(String[] args) {
		launch(args);

	}

}
