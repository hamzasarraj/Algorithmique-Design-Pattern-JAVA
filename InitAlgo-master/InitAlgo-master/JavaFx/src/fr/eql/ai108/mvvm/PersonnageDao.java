package fr.eql.ai108.mvvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonnageDao {
	//Classe d'accès aux données: connectée à notre unité de persistance et fait le lien avec la vue
	
	//getAll(): renvoyer tous les objets Personnage présents dans l'unité de persistance
	//add(Personnage pers)
	//delete(Personnage pers)
	//update(Personnage pers)
	
	public List<Personnage> getAll(){
		 List<Personnage> personnages = new ArrayList<Personnage>();
		 
		 Personnage oberyn = new Personnage("Martell", "Oberyn", 45);
		 Personnage jojo = new Personnage("Joestar", "Joseph", 58);
		 Personnage sacha = new Personnage("Ketchum", "Sacha", 12);
		 Personnage paul = new Personnage("Atréide", "Paul", 22);
		 Personnage dio = new Personnage("Brando", "Dio", 35);
		 
		 Collections.addAll(personnages, oberyn, jojo, sacha, paul, dio);
		
		return personnages;
	}
}
