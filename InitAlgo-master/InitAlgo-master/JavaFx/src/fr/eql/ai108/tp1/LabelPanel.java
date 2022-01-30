package fr.eql.ai108.tp1;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LabelPanel extends VBox {

		private Label lbl1 = new Label("Label 1");
		private Label lbl2 = new Label("Label 2");
		private Label lbl3 = new Label("Label 3");
		private Label lbl4 = new Label("Label 4");
		
		
		public LabelPanel() {
		 getChildren().addAll(lbl1, lbl2, lbl3, lbl4);
		 setSpacing(50);
		 setStyle("-fx-background-color: green; -fx-border-color: black");
		 setAlignment(Pos.CENTER);
		 setPrefSize(100, 200);
		}
		
		public Label getLbl1() {
			return lbl1;
		}
		public Label getLbl2() {
			return lbl2;
		}
		public Label getLbl3() {
			return lbl3;
		}
		public Label getLbl4() {
			return lbl4;
		}
		public void setLbl1(Label lbl1) {
			this.lbl1 = lbl1;
		}
		public void setLbl2(Label lbl2) {
			this.lbl2 = lbl2;
		}
		public void setLbl3(Label lbl3) {
			this.lbl3 = lbl3;
		}
		public void setLbl4(Label lbl4) {
			this.lbl4 = lbl4;
		}
		
		
}
