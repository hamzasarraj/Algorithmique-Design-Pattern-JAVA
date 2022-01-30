package fr.eql.ai108.premier.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PremiereAppGraphique extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//On instancie un premier panneau
		Pane root = new Pane();
		
		//On donne la couleur cyan à notre panneau root
		root.setStyle("-fx-background-color:cyan");
		
		//On instancie une Scene à laquelle on transmet notre panneau root et des dimensions:
		Scene scene = new Scene(root, 500, 500);
		
		//On donne notre scène à notre stage
		primaryStage.setScene(scene);
		
		//On souhaite ajouter des éléments au panneau root de notre scène
		
		//On instancie un cercle
		Circle cercle = new Circle(75);
		//On donne une couleur à notre cercle
		cercle.setFill(Color.YELLOW);
		//On peut lui donner une couleur de bordure
		cercle.setStroke(Color.ORANGE);
		cercle.relocate(50, 50);
		
		//On instancie un rectangle
		Rectangle rectangle = new Rectangle(500, 150, Color.GREEN);
		rectangle.setStroke(Color.DARKGREEN);
		rectangle.relocate(0, 350);
		
		//On ajoute du texte
		Label label = new Label("Dessin de Thibaud");
		label.setTextFill(Color.HOTPINK);
		label.setFont(Font.font("Brush Script MT", 35));
		label.relocate(250, 450);
		
		
		//On donne notre cercle, notre rectangle et notre label à la liste de composants enfants de notre panneau root
		root.getChildren().add(cercle);
		root.getChildren().add(rectangle);
		root.getChildren().add(label);
		
		//Définir une largeur de Stage
		//primaryStage.setWidth(1000);
		
		//Fenêtre en taille max
		//primaryStage.setMaximized(true);
		
		//Le stage s'adapte à la taille de la scène
		primaryStage.sizeToScene();
	
		//Interdir le redimensionnement de la fenêtre
		primaryStage.setResizable(false);
		
		//Donner un titre à ma fenêtre
		primaryStage.setTitle("Ma première scène graphique");
		
		
		//On affiche notre stage
		primaryStage.show();
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
