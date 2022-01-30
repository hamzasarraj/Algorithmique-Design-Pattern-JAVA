package fr.eql.ai108.valref;

public class PassageParReferenceDansMethodeEtInstanciation {

	public static void main(String[] args) {
		Personne capitaine = new Personne("Haddock", "François", 62);
		remplacerParJon(capitaine);
		System.out.println("Nom du capitaine: " + capitaine.getNom());

	}
	public static void remplacerParJon(Personne personne) {
		personne = new Personne("Snow", "Jon", 22);
	}

}
