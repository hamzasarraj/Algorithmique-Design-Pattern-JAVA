package fr.eql.ai108.tp2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class MainPanel extends GridPane {
	
	private ButtonPanel buttonPannel = new ButtonPanel();
	private ColorPanel colorPanel = new ColorPanel();
	private ColorHandler handler;
	
	public MainPanel() {
		addColumn(0, buttonPannel, colorPanel);
		
		//2ème méthode: gestion de l'événement dans le MainPanel
		buttonPannel.getRedButton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				colorPanel.setStyle("-fx-background-color: red");				
			}
		});
		
		handler = new ColorHandler(colorPanel, "orange");
		buttonPannel.getOrangeButton().setOnAction(handler);
	}

	public ButtonPanel getButtonPannel() {
		return buttonPannel;
	}

	public ColorPanel getColorPanel() {
		return colorPanel;
	}

	public void setButtonPannel(ButtonPanel buttonPannel) {
		this.buttonPannel = buttonPannel;
	}

	public void setColorPanel(ColorPanel colorPanel) {
		this.colorPanel = colorPanel;
	}
}
