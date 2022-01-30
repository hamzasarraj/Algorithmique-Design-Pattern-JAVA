package fr.eql.ai108.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoForEachLambda {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();
		Collections.addAll(items, "A", "B", "C", "D", "E");
		
		//Jusqu'à Java 7
		for (String string : items) {
			System.out.println("Java 7: " + string);
		}
		
		//En Java 8
		
		items.forEach(toto -> System.out.println("Java 8: " + toto));
		
		items.forEach(item ->{
			if(item.equals("C")) {
				System.out.println("item trouvé: " + item);
			}
		});

	}

}
