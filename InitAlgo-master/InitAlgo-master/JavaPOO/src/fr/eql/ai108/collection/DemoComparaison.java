package fr.eql.ai108.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import fr.eql.ai108.valref.Personne;

public class DemoComparaison {

	public static void main(String[] args) {
		//Raccourci import: Ctrl + Shift + O
		List<Personne> personnes = new ArrayList<Personne>();
		Personne sacha = new Personne("Ketchum", "Sacha", 10);
		Personne pierre = new Personne("d'Argenta", "Pierre", 13);
		Personne ondine = new Personne("d'Azuria", "Ondine", 12);
		
		//Ajouter plusieurs éléments à une collection
		Collections.addAll(personnes, ondine, pierre, sacha);
		
		System.out.println("Collection non triée: ");
		System.out.println(personnes);
		
		Collections.sort(personnes);
		System.out.println("Collection triée: ");
		System.out.println(personnes);
		
		//Tri de la collection par age:
		Collections.sort(personnes, new PersonneComparatorByAge());
		System.out.println("Collection triée par age:");
		System.out.println(personnes);

	}

}
