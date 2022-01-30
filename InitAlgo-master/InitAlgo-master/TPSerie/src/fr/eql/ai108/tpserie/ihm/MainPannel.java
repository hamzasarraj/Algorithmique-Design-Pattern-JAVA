package fr.eql.ai108.tpserie.ihm;

import javafx.scene.layout.BorderPane;

//Le panneau principal qui contient les deux autres:
public class MainPannel extends BorderPane {
	
	private TablePannel tablePannel = new TablePannel();
	private FormPannel formPannel = new FormPannel();
		
	public MainPannel() {
		super();
		setLeft(formPannel);
		setCenter(tablePannel);
	}
	public TablePannel getTablePannel() {
		return tablePannel;
	}
	public void setTablePannel(TablePannel tablePannel) {
		this.tablePannel = tablePannel;
	}
	public FormPannel getFormPannel() {
		return formPannel;
	}
	public void setFormPannel(FormPannel formPannel) {
		this.formPannel = formPannel;
	}		
}