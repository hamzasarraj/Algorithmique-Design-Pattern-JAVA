package fr.eql.ai108.tp1;

import javafx.scene.layout.BorderPane;

public class MainPanel extends BorderPane {
	
	private ButtonPanel buttonPanel = new ButtonPanel();
	private LabelPanel labelPanel = new LabelPanel();
	
	public MainPanel() {
		setTop(buttonPanel);
		setLeft(labelPanel);
		setStyle("-fx-background-color: teal");
	}
	
	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}
	public LabelPanel getLabelPanel() {
		return labelPanel;
	}
	public void setButtonPanel(ButtonPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}
	public void setLabelPanel(LabelPanel labelPanel) {
		this.labelPanel = labelPanel;
	}
	
	
}
