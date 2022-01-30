package fr.eql.ai108.valref;

public class CopieParReference {

	public static void main(String[] args) {
		Personne capitaine = new Personne("Haddock", "François", 62);
		Personne tournesol = capitaine;
		tournesol.setNom("Tournesol");
		System.out.println(capitaine.getNom());
		

	}

}
