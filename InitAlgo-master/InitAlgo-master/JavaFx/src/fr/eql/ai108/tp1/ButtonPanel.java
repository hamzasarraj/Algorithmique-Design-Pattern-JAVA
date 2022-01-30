package fr.eql.ai108.tp1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPanel extends HBox{
	
	private Button btn1 = new Button("Bouton 1");
	private Button btn2 = new Button("Bouton 2");
	private Button btn3 = new Button("Bouton 3");
	private Button btn4 = new Button("Bouton 4");
	
	
	public ButtonPanel() {
		getChildren().addAll(btn1, btn2, btn3, btn4);
		setSpacing(50);
		setStyle("-fx-background-color: red; -fx-border-color: black");
		setAlignment(Pos.CENTER);
		setPrefSize(400, 75);
	}
	
	public Button getBtn1() {
		return btn1;
	}
	public Button getBtn2() {
		return btn2;
	}
	public Button getBtn3() {
		return btn3;
	}
	public Button getBtn4() {
		return btn4;
	}
	public void setBtn1(Button btn1) {
		this.btn1 = btn1;
	}
	public void setBtn2(Button btn2) {
		this.btn2 = btn2;
	}
	public void setBtn3(Button btn3) {
		this.btn3 = btn3;
	}
	public void setBtn4(Button btn4) {
		this.btn4 = btn4;
	}
}
