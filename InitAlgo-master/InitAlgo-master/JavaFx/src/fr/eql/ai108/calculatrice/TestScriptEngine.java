package fr.eql.ai108.calculatrice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestScriptEngine extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox(10);
		TextField tf = new TextField();
		Button btn = new Button("Calculer");
		Label display = new Label();
		root.getChildren().addAll(tf, btn, display);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("js");
				try {
					Object result = engine.eval(tf.getText());
					display.setText(result.toString());
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
	}

	public static void main(String[] args) {
		launch(args);

	}

}
