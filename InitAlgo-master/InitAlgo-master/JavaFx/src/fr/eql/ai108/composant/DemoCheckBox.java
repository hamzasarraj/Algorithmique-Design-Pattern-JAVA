package fr.eql.ai108.composant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoCheckBox extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		
		Label lbl = new Label("Choisissez vos personnages préférés: ");
		Label affichage = new Label();
		Button btn = new Button("Valider");
		
		//On instancie des CHeckBox
		CheckBox oberyn = new CheckBox("Oberyn Martell");
		CheckBox doran = new CheckBox("Doran Martell");
		CheckBox eddard = new CheckBox("Eddard Stark");
		CheckBox tyrion = new CheckBox("Tyrion Lannister");
		CheckBox arya = new CheckBox("Arya Stark");
		
		//On regroupe nos CheckBoxes dans un tableau pour pouvoir les traiter d'un seul coup
		CheckBox[] boxes = {oberyn, doran, eddard, tyrion, arya};
		
		//On ajoute nos composants à notre panneau root.
		root.getChildren().addAll(boxes);
		root.getChildren().addAll(lbl, affichage, btn);
		
		root.setStyle("-fx-background-color: cyan");
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premières CheckBoxes");
		primaryStage.sizeToScene();
		primaryStage.show();
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//On instancie un StringBuilder dans lequel on stockera les valeurs des cases cochées
				//par l'utilisateur
				StringBuilder builder = new StringBuilder();
				//On interroge chacune des checkboxes pour savoir si elles sont cochées ou pas
				//Pour chaque CheckBox
				for(CheckBox box : boxes) { 	
					//Si la box est bien cochée
					if(box.isSelected()) {
						//On ajoute la valeur de la boxe à notre builder
						builder.append(String.format("\t%s%n", box.getText()));
					}
				}
				//Si aucune case n'est cochée
				if(builder.length() == 0) {
					builder.append("Vous n'avez rien sélectionné");
				}else {
					builder.insert(0, "Vous personnages préférés sont : \n");
				}
				
			//ENfin on affiche dans le label le contenu du builder
				lbl.setText(builder.toString());
			}
		});
		
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
