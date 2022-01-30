package fr.eql.ai108.tpserie.ihm;


import fr.eql.ai108.tpserie.model.Serie;
import fr.eql.ai108.tpserie.model.SerieDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

//Le TablePannel qui gère l'affichage de nos séries:
public class TablePannel extends AnchorPane {
	
	private SerieDao dao = new SerieDao();
	private ObservableList<Serie> observableSeries;
	private TableView<Serie> tableView;
	
	@SuppressWarnings("unchecked")
	public TablePannel() {
		super();
		
		observableSeries = FXCollections.observableArrayList(dao.getAll());
		
		tableView = new TableView<>(observableSeries);
		
		TableColumn<Serie, String> colTitre = new TableColumn<>("Titre");
		colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		
		TableColumn<Serie, Integer> colNbSaison = new TableColumn<>("Nombre de saison");
		colNbSaison.setCellValueFactory(new PropertyValueFactory<>("nbSaison"));
		colNbSaison.setStyle("-fx-alignment: CENTER");
		
		TableColumn<Serie, Integer> colAnnee = new TableColumn<>("Année de diffusion");
		colAnnee.setCellValueFactory(new PropertyValueFactory<>("anneeDiffusion"));
		
		TableColumn<Serie, String> colMaisonProd = new TableColumn<>("Maison de production");
		colMaisonProd.setCellValueFactory(new PropertyValueFactory<>("maisonProd"));
		
		TableColumn<Serie, String> colEval = new TableColumn<>("Evaluation");
		colEval.setCellValueFactory(new PropertyValueFactory<>("evaluation"));
		
		tableView.getColumns().addAll(colTitre, colNbSaison, colAnnee, colMaisonProd, colEval);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		getChildren().add(tableView);
		
		setPrefSize(1000, 500);
		AnchorPane.setTopAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		AnchorPane.setBottomAnchor(tableView, 5.);
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Serie>() {

			@Override
			public void changed(ObservableValue<? extends Serie> observable, Serie oldValue, Serie newValue) {
				MainPannel root = (MainPannel) TablePannel.this.getScene().getRoot();
				FormPannel formPannel = root.getFormPannel();
				if(newValue != null){
					formPannel.getTxtTitre().setText(newValue.getTitre());
					formPannel.getTxtNbSaison().setText(Integer.toString(newValue.getNbSaison()));
					formPannel.getTxtDiff().setText(Integer.toString(newValue.getAnneeDiffusion()));
					
					for (String str : formPannel.getCbMaisonProd().getItems()){
 
						if(str.startsWith(newValue.getMaisonProd())){
							formPannel.getCbMaisonProd().getSelectionModel().select(str);
						}
					}
					
					formPannel.getCbMaisonProd().getSelectionModel().select(newValue.getMaisonProd());

					switch (newValue.getEvaluation()) {
					case "Pas bien":
						formPannel.getPasBien().setSelected(true);
						break;
					case "Bien":
						formPannel.getBien().setSelected(true);
						break;
					case "Moyen":
						formPannel.getMoyen().setSelected(true);
						break;
					case "Excellent":
						formPannel.getTresBien().setSelected(true);
						break;

					default:
						break;
					}	
				}			
			}
		});
	}
	
	public SerieDao getDao() {
		return dao;
	}
	public void setDao(SerieDao dao) {
		this.dao = dao;
	}
	public ObservableList<Serie> getObservableSeries() {
		return observableSeries;
	}
	public void setObservableSeries(ObservableList<Serie> observableSeries) {
		this.observableSeries = observableSeries;
	}
	public TableView<Serie> getTableView() {
		return tableView;
	}
	public void setTableView(TableView<Serie> tableView) {
		this.tableView = tableView;
	}
}