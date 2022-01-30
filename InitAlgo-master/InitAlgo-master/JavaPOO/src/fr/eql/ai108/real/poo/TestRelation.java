package fr.eql.ai108.real.poo;

public class TestRelation {

	public static void main(String[] args) {
		//Instanciation de jouets:
		Jouet balle = new Jouet("balle", 5.50f);
		Jouet os = new Jouet("os", 3.50f);
		Jouet doudou = new Jouet("doudou", 8.50f);
		Jouet baton = new Jouet("baton", 0.0f);
		Jouet[] jouetsEin = {balle, os};
		Jouet[] jouetsLaica = {doudou, baton};
		
		Chien ein = new Chien("Ein", 8, 0.70f, 7.45f, "Welsh Corgi", true, 'E', jouetsEin, 
				GroupeChien.SPITZ);
		Collier collierEin = new Collier("rouge", "cuir");
		ein.setCollier(collierEin);
		System.out.println("Ein possède un collier en " + ein.getCollier().getMatiere() 
				+ " de couleur " + ein.getCollier().getCouleur() + ".");
		//Affichage des jouets de Ein
		System.out.println("Jouets de Ein");
		for(int i = 0; i < ein.getJouets().length; i++) {
			System.out.println(ein.getJouets()[i].getLibelle() + " " 
		+ ein.getJouets()[i].getPrix());
		}
		//Affichage du groupe de EIN
		System.out.println("Ein fait partie de la famille " + ein.getGroupe());

		Collier collierLaica = new Collier("jaune", "tissus");
		Chien laica = new Chien("Laïca", 12, 0.9f, 12.42f, "Berger Allemand",
				true, 'L', collierLaica);
		System.out.println("Laïca possède un collier en " + laica.getCollier().getMatiere()
		+ " de couleur " + laica.getCollier().getCouleur() + ".");
		laica.setJouets(jouetsLaica);
		
		//Affectation d'une valeur enum par le setter
		laica.setGroupe(GroupeChien.BERGER);
		System.out.println("Laïca fait partie de la famille " + laica.getGroupe());
		
		//Pour chaque Jouet compris dans la collection de jouets de laica
		//que je référence localement par joujou
		for(Jouet joujou : laica.getJouets()) {
			System.out.println(joujou.getLibelle() + " " + joujou.getPrix());
		}
	}

}
