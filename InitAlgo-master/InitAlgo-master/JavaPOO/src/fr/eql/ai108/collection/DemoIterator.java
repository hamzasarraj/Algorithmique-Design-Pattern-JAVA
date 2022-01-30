package fr.eql.ai108.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DemoIterator {

	public static void main(String[] args) {
		
		//L'itérateur sert à modifier des éléments d'une collection
		//pendant leur parcours
		List<Integer> liste = new ArrayList<Integer>();
		Collections.addAll(liste, 10, 20, 30, 30, 40, 50);
		//Je veux supprimer tous les 30 de la liste
//		for(int i = 0; i < liste.size(); i++) {
//			if(liste.get(i) == 30) {
//				liste.remove(i);
//			}
//		}
		
		Iterator<Integer> i = liste.iterator();
		while(i.hasNext()) {
			if(i.next() == 30) {
				i.remove();				
			}
		}
		System.out.println(liste);

	}

}
