package fr.eql.ai108.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class DemoListIterator {

	public static void main(String[] args) {
		List<Integer> liste = new ArrayList<Integer>();
		Collections.addAll(liste, 10, 20, 30, 30, 40, 50);
		ListIterator<Integer> i = liste.listIterator();
		while(i.hasNext()) {
			if(i.next() == 30) {
				i.set(42);
			}
		}
		System.out.println(liste);
		while(i.hasPrevious()) {
			System.out.println(i.previous());
		}
	}

}
