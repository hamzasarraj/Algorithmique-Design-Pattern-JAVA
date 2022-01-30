package fr.eql.ai108.collection;

import java.util.HashSet;
import java.util.Set;

import fr.eql.ai108.valref.Personne;

public class DemoHashSet {

	public static void main(String[] args) {
		Set<Personne> personnes = new HashSet<Personne>();
		
		Personne sacha = new Personne("de Bourg Palette", "Sacha", 12);
		Personne pierre = new Personne("d'Argenta", "Pierre", 14);
		Personne ondine = new Personne("d'Azuria", "Ondine", 13);
		
		personnes.add(sacha);
		personnes.add(pierre);
		personnes.add(ondine);
		personnes.add(ondine);
		personnes.add(ondine);
		personnes.add(ondine);
		
		System.out.println("Ma liste contient " + personnes.size() + " personnes");
		
		for (Personne personne : personnes) {
			System.out.println(personne);
		}
		
		personnes.remove(sacha);
		System.out.println("Ma liste contient " + personnes.size() + " personnes");


	}

}
