package fr.eql.ai108.tpserie.ihm;

import fr.eql.ai108.tpserie.model.Serie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

//Le FormPannel qui contient le formulaire d'édition de nos séries:
public class FormPannel extends GridPane {
	
	private Label lblTitre;
	private TextField txtTitre;
	private Label lblNbSaison;
	private TextField txtNbSaison;
	private Label lblDiff;
	private TextField txtDiff;
	private Label lblMaisonProd;
	private ChoiceBox<String> cbMaisonProd;
	private Label lblEval;
	private RadioButton pasBien;
	private RadioButton moyen;
	private RadioButton bien;
	private RadioButton tresBien;
	private ToggleGroup evalGroup;
	private HBox evalBox;
	private Button btnAdd;
	private Button btnErase;
	private Button btnUpdate;
	private HBox btnBox;
	private HBox cbBox;
	
	public FormPannel() {
		super();
		
		lblTitre= new Label("Titre: ");
		txtTitre = new TextField();		
		addRow(0, lblTitre, txtTitre);
		
		lblNbSaison= new Label("Nombre de saison: ");
		txtNbSaison = new TextField();	
		addRow(1, lblNbSaison, txtNbSaison);
		
		lblDiff= new Label("Date de diffusion: ");
		txtDiff = new TextField();
		addRow(2, lblDiff, txtDiff);
		
		lblMaisonProd = new Label("Maison de production: ");
		cbMaisonProd = new ChoiceBox<>();
		cbMaisonProd.getItems().addAll("Choisir", "HBO", "Netflix", "Amazon", "BBC", "TF1");
		cbMaisonProd.getSelectionModel().select("Choisir");
		cbMaisonProd.setStyle("-fx-alignment: CENTER");		
		cbBox = new HBox();
		cbBox.setAlignment(Pos.CENTER);
		cbBox.getChildren().add(cbMaisonProd);
		addRow(3, lblMaisonProd, cbBox);
		
		lblEval = new Label("Evaluation: ");
		evalGroup = new ToggleGroup();
		pasBien = new RadioButton("Pas bien");
		moyen = new RadioButton("Moyen");
		bien = new RadioButton("Bien");
		tresBien = new RadioButton("Excellent");
		evalGroup.getToggles().addAll(pasBien, moyen, bien, tresBien);
		evalBox = new HBox(50);
		evalBox.getChildren().addAll(pasBien, moyen, bien, tresBien);
		addRow(4, lblEval, evalBox);
		
		btnAdd = new Button("Ajouter");
		btnAdd.setPrefSize(200, 100);
		btnErase = new Button("Effacer");
		btnErase.setPrefSize(200, 100);
		btnUpdate = new Button("Mettre à jour");
		btnUpdate.setPrefSize(200, 100);
		btnBox = new HBox(50);
		btnBox.getChildren().addAll(btnAdd, btnErase, btnUpdate);
		btnBox.setAlignment(Pos.CENTER);
		add(btnBox, 0, 10, 2, 1);
		
		
		setVgap(20);
		setPadding(new Insets(20));
		setStyle("-fx-background-color:teal");
		
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String titre = txtTitre.getText();
				int nbSaison = Integer.parseInt(txtNbSaison.getText()) ;
				int diffusion = Integer.parseInt(txtDiff.getText());
				String maisonProd = cbMaisonProd.getSelectionModel().getSelectedItem();
				String eval =  ((Labeled) evalGroup.getSelectedToggle()).getText();
				Serie serie = new Serie(titre, nbSaison, diffusion, maisonProd, eval);
				MainPannel root = (MainPannel) getScene().getRoot();
				root.getTablePannel().getObservableSeries().add(serie);
				root.getTablePannel().getDao().ajouterSerie(serie);
						
				
			}
		});
		
		btnErase.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainPannel root = (MainPannel) FormPannel.this.getScene().getRoot();
				TableView<Serie> tv = root.getTablePannel().getTableView();
				Serie serie = tv.getSelectionModel().getSelectedItem();
				root.getTablePannel().getObservableSeries().remove(serie);
				root.getTablePannel().getDao().supprimerSerie(serie.getTitre());
				
			}
		});
		
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int nbSaison = Integer.parseInt(txtNbSaison.getText()) ;
				int diffusion = Integer.parseInt(txtDiff.getText());
				String eval =  ((Labeled) evalGroup.getSelectedToggle()).getText();
				String maisonProd = cbMaisonProd.getSelectionModel().getSelectedItem();
				MainPannel root = (MainPannel)getScene().getRoot();
				TableView<Serie> tv = root.getTablePannel().getTableView();
				Serie serie = tv.getSelectionModel().getSelectedItem();
				serie.setNbSaison(nbSaison);
				serie.setAnneeDiffusion(diffusion);
				serie.setMaisonProd(maisonProd);
				serie.setEvaluation(eval);
				tv.refresh();
				root.getTablePannel().getDao().mettreAJour(serie);
				
			}
		});
	}

	public Label getLblTitre() {
		return lblTitre;
	}

	public void setLblTitre(Label lblTitre) {
		this.lblTitre = lblTitre;
	}

	public TextField getTxtTitre() {
		return txtTitre;
	}

	public void setTxtTitre(TextField txtTitre) {
		this.txtTitre = txtTitre;
	}

	public Label getLblNbSaison() {
		return lblNbSaison;
	}

	public void setLblNbSaison(Label lblNbSaison) {
		this.lblNbSaison = lblNbSaison;
	}

	public TextField getTxtNbSaison() {
		return txtNbSaison;
	}

	public void setTxtNbSaison(TextField txtNbSaison) {
		this.txtNbSaison = txtNbSaison;
	}

	public Label getLblDiff() {
		return lblDiff;
	}

	public void setLblDiff(Label lblDiff) {
		this.lblDiff = lblDiff;
	}

	public TextField getTxtDiff() {
		return txtDiff;
	}

	public void setTxtDiff(TextField txtDiff) {
		this.txtDiff = txtDiff;
	}

	public Label getLblMaisonProd() {
		return lblMaisonProd;
	}

	public void setLblMaisonProd(Label lblMaisonProd) {
		this.lblMaisonProd = lblMaisonProd;
	}

	public ChoiceBox<String> getCbMaisonProd() {
		return cbMaisonProd;
	}

	public void setCbMaisonProd(ChoiceBox<String> cbMaisonProd) {
		this.cbMaisonProd = cbMaisonProd;
	}

	public Label getLblEval() {
		return lblEval;
	}

	public void setLblEval(Label lblEval) {
		this.lblEval = lblEval;
	}

	public RadioButton getPasBien() {
		return pasBien;
	}

	public void setPasBien(RadioButton pasBien) {
		this.pasBien = pasBien;
	}

	public RadioButton getMoyen() {
		return moyen;
	}

	public void setMoyen(RadioButton moyen) {
		this.moyen = moyen;
	}

	public RadioButton getBien() {
		return bien;
	}

	public void setBien(RadioButton bien) {
		this.bien = bien;
	}

	public RadioButton getTresBien() {
		return tresBien;
	}

	public void setTresBien(RadioButton tresBien) {
		this.tresBien = tresBien;
	}

	public ToggleGroup getEvalGroup() {
		return evalGroup;
	}

	public void setEvalGroup(ToggleGroup evalGroup) {
		this.evalGroup = evalGroup;
	}

	public HBox getEvalBox() {
		return evalBox;
	}

	public void setEvalBox(HBox evalBox) {
		this.evalBox = evalBox;
	}

	public Button getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(Button btnAdd) {
		this.btnAdd = btnAdd;
	}

	public Button getBtnErase() {
		return btnErase;
	}

	public void setBtnErase(Button btnErase) {
		this.btnErase = btnErase;
	}

	public Button getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(Button btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public HBox getBtnBox() {
		return btnBox;
	}

	public void setBtnBox(HBox btnBox) {
		this.btnBox = btnBox;
	}

	public HBox getCbBox() {
		return cbBox;
	}

	public void setCbBox(HBox cbBox) {
		this.cbBox = cbBox;
	}
}