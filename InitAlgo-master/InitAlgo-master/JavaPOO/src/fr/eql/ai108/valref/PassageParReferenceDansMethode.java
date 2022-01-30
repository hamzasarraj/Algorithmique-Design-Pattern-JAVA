package fr.eql.ai108.valref;

public class PassageParReferenceDansMethode {

	public static void main(String[] args) {
		Personne capitaine = new Personne("Haddock", "François", 62);
		vieillir(capitaine);
		System.out.println("Après un passage dans la méthode vieillir, l'âge du "
				+ "capitaine est de " + capitaine.getAge() + "ans.");

	}
	
	public static void vieillir(Personne personne) {
		personne.setAge(personne.getAge() + 1);
	}

}
