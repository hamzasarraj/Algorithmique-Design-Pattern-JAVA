package fr.eql.ai108.collection;

import java.util.HashMap;
import java.util.Map;

public class DemoMapSimple {

	public static void main(String[] args) {
		//Instancier une HashMap
		Map<String, Integer> listeCourses = new HashMap<String, Integer>();
		
		//Ajouter des couples clé/valeur dans la map avec la méthode put
		listeCourses.put("kiwi", 6);
		listeCourses.put("lime", 2);
		listeCourses.put("banane", 4);
		
		//Récupérer une valeur de ma Map j'utilisa la methode get
		System.out.println("Quantité de bananes => " + listeCourses.get("banane"));
		
		//Vérifier la présence d'une clé dans la map
		if(listeCourses.containsKey("lime")) {
			//suppresion d'un couple clé/valeur
			listeCourses.remove("kiwi");
		}
		
		//Afficher toutes les clés de la map
		System.out.println(listeCourses.keySet());
	}
}
