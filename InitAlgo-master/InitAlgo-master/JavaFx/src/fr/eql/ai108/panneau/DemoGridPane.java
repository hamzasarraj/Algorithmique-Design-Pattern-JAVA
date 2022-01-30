package fr.eql.ai108.panneau;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DemoGridPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		
		//On instancie des composants de formulaire:
		Label lblNom = new Label("Nom: ");
		TextField tfNom = new TextField();
		Label lblPrenom = new Label("Prénom: ");
		TextField tfPrenom = new TextField();
		Label lblAdresse = new Label("Adresse: ");
		TextField tfAdresse= new TextField();
		Label lblAge = new Label("Age: ");
		TextField tfAge = new TextField();
		Button btn = new Button("Valider");
		
		//Pour ajouter des composants à mon GridPane, j'uilise des coordonnées
		// add(refComposant, colonne, ligne)
//		root.add(lblNom, 0, 0);
//		root.add(tfNom, 1, 0);
//		root.add(lblPrenom, 0, 1);
//		root.add(tfPrenom, 1, 1);
//		root.add(lblAdresse, 0, 2);
//		root.add(tfAdresse, 1, 2);
//		root.add(lblAge, 0, 3);
//		root.add(tfAge, 1, 3);
//		root.add(btn, 1, 4);
		//On peut aussi ajouter les composants ligne par ligne
		root.addRow(0, lblNom, tfNom, lblPrenom, tfPrenom);
		root.addRow(1, lblAdresse, tfAdresse, lblAge, tfAge);
		root.addRow(2, btn);
		
		//root.addColumn(columnIndex, children);
		
		//Options
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premier GridPane");
		primaryStage.show();
			

	}

	public static void main(String[] args) {
		launch(args);

	}

}
