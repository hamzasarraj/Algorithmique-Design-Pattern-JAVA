package fr.eql.ai108.real.poo;

public class Lanceur {

	public static void main(String[] args) {
		
		//Instanciation d'objets avec constructeur vide
		Chien ein = new Chien();
		
		//Initialisation des variables d'instance grâce aux setters
		ein.setNom("Ein");
		ein.setAge(7);
		ein.setPoids(7.02f);
		ein.setTaille(0.75f);
		ein.setRace("Welsh Corgi");
		ein.setPedigree('E');
		
		//Récupération de la valeur des attributs grâce aux getters
		System.out.println("Je m'appelle " + ein.getNom() + ", je "
				+ "suis un " + ein.getRace() + " et j'ai " + ein.getAge() + 
				" ans.");
		
		//Instanciation et initialisation des variables d'instances
		//grâce au constructeur surchargé
		Chien laika = 
				new Chien("Laïka", 9, 0.9f, 15.42f, "Berger", true, 'L');
		
		Chien milou = new Chien("Milou", 9, 0.45f, 6.12f, "Fox Terrier", 'M');
		//System.out.println(laika.nom);
		System.out.println(laika.getNom());
		laika.setNom("Spot");
		System.out.println(laika.getNom());
		
		//Appel des méthodes d'instances
		ein.aboyer();
		ein.ramenerLaBalle(42);
		float rapport = ein.rapportTaillePoids();
		System.out.println(rapport);
		
		//Même chose avec Laica
		float rapportLaica = laika.rapportTaillePoids();
		System.out.println(rapportLaica);
		
		//Accès à ma variable de classe:
		System.out.println(ein.getNbChien());
		System.out.println(laika.getNbChien());
		System.out.println(Chien.getNbChien());
	}

}
