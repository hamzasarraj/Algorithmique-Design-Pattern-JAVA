package fr.eql.ai108.mvvm;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoTableView extends Application {

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		AnchorPane anchorPane = new AnchorPane();
		PersonnageDao dao = new PersonnageDao();
		ObservableList<Personnage> observablePersonnages = FXCollections.observableArrayList(dao.getAll());
		
		//On instancie un TableView: composant qui permet d'afficher des données sous forme de tableau
		TableView<Personnage> tableView = new TableView<Personnage>(observablePersonnages);
		
		//Paramétrage du TableView
		//On instancie une colonne
		TableColumn<Personnage, String> colNom = new TableColumn<Personnage, String>("Nom");
		//On transmet le nom du personnage à cette colonne
		colNom.setCellValueFactory(new PropertyValueFactory<Personnage, String>("nom"));
		
		TableColumn<Personnage, String> colPrenom = new TableColumn<Personnage, String>("Prénom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<Personnage, String>("prenom"));
		
		TableColumn<Personnage, Integer> colAge = new TableColumn<Personnage, Integer>("Age");
		colAge.setCellValueFactory(new PropertyValueFactory<Personnage, Integer>("age"));
		
		//Donner la colonne à notre tableview
		tableView.getColumns().addAll(colNom, colPrenom, colAge);
		
		//Ajuster la taille du tableau à son contenu
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		anchorPane.getChildren().add(tableView);
		anchorPane.setPrefSize(300, 200);
		AnchorPane.setTopAnchor(tableView, 5.);
		AnchorPane.setBottomAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
		
		//VBOX D'affichage
		VBox box = new VBox();
		Label lbl1 = new Label("Personnage sélectionné: ");
		Label lbl2 = new Label();
		box.getChildren().addAll(lbl1, lbl2);
		lbl1.setPadding(new Insets(0, 70, 0, 0));
		box.setAlignment(Pos.CENTER);
		box.setPrefWidth(600);
		box.setStyle("-fx-background-color: cyan");
		
		root.setLeft(anchorPane);
		root.setRight(box);
		Scene scene = new Scene(root, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Premier TableView");
		primaryStage.show();
		
		//Evenement
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Personnage>() {

			@Override
			public void changed(ObservableValue<? extends Personnage> observable, Personnage oldValue,
					Personnage newValue) {
				lbl2.setText(newValue.toString());
				
			}
		});

	}

	public static void main(String[] args) {
		launch(args);

	}

}
