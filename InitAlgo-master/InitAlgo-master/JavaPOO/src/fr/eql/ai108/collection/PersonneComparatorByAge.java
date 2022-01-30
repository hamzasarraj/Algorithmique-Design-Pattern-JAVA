package fr.eql.ai108.collection;

import java.util.Comparator;import fr.eql.ai108.valref.Personne;

public class PersonneComparatorByAge implements Comparator<Personne>{

	@Override
	public int compare(Personne p1, Personne p2) {
		// TODO Auto-generated method stub
		return p1.getAge() - p2.getAge();
	}

}
