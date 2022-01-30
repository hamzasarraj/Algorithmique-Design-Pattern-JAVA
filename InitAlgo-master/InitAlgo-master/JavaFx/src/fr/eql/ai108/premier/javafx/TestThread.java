package fr.eql.ai108.premier.javafx;

import javafx.application.Application;
import javafx.stage.Stage;


public class TestThread extends Application{

	public static void main(String[] args) {		
		System.out.println("Thread déclenché par la méthode main: " + Thread.currentThread().getName());
		//Launch args démarre thread JavaFX
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Thread déclenché par la méthode start: " + Thread.currentThread().getName());
		
	}


}
