package fr.eql.ai108.collection;

import java.util.ArrayList;
import java.util.List;

import fr.eql.ai108.valref.Personne;

public class DemoArrayList {

	public static void main(String[] args) {
		//Instancier une ArrayList de Personne
		List<Personne> personnes = new ArrayList<Personne>();
		
		Personne sacha = new Personne("de Bourg Palette", "Sacha", 12);
		Personne pierre = new Personne("d'Argenta", "Pierre", 14);
		Personne ondine = new Personne("d'Azuria", "Ondine", 13);
		
		//La méthode add(Object o) permet d'ajouter des objets à la liste	
		personnes.add(sacha);
		personnes.add(sacha);
		personnes.add(sacha);
		personnes.add(sacha);
		personnes.add(pierre);
		personnes.add(ondine);
		
		//size() nous permet de connaître la taille de la liste
		System.out.println("Ma liste contient " + personnes.size() + " personnes");
		
		for (Personne personne : personnes) {
			System.out.println(personne);
		}
		
		//Récupérer un index à partir de la référence de mon instance:
		int indexSacha = personnes.indexOf(sacha);
		System.out.println("Index de Sacha: " + indexSacha);
		
		//Récupérer un élément à partir de son index:
		Personne persIndex2 = personnes.get(2);
		System.out.println(persIndex2);
		
		//Supprimer un élément dans la liste par la référence ou par l'index
		personnes.remove(pierre);
		personnes.remove(0);
		
		//2 solution pour vider une ArrayList:
		//personnes.removeAll(personnes);
		//personnes = new ArrayList<Personne>();
		System.out.println("Ma liste contient " + personnes.size() + " personnes");
	}

}
