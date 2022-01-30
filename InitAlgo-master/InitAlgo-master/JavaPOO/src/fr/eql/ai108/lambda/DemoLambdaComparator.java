package fr.eql.ai108.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.eql.ai108.collection.PersonneComparatorByAge;
import fr.eql.ai108.valref.Personne;

public class DemoLambdaComparator {

	public static void main(String[] args) {
		List<Personne> personnes = new ArrayList<Personne>();
		Personne harry = new Personne("Seldon", "Harry", 72);
		Personne oberyn = new Personne("Martell", "Oberyn", 45);
		Personne luke = new Personne("Skywalker", "Luke", 55);
		
		Collections.addAll(personnes, harry, oberyn, luke);
		
		System.out.println("Collection non triée");
		System.out.println(personnes);
		
		//Collections.sort(personnes, new PersonneComparatorByAge());
		
		//A partir de java8, on peut appeler la méthode sort directement depuis l'instance de collection
		//personnes.sort(new PersonneComparatorByAge());
		
		//Classe anonyme interne
//		personnes.sort(new Comparator<Personne>() {
//
//			@Override
//			public int compare(Personne p1, Personne p2) {
//				// TODO Auto-generated method stub
//				return p1.getAge() - p2.getAge();
//			}
//		});
		
		//La même chose avec une lambda expression	
		//personnes.sort((Personne p1, Personne p2) -> p1.getAge() - p2.getAge());
		
		//La même en encore plus court
		personnes.sort((p1, p2) -> p1.getAge() - p2.getAge());
		
		
		System.out.println("Collection triée");
		System.out.println(personnes);

	}

}
