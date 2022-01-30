package fr.eql.ai108.real.poo.tp;

public class Serie {
	
	private String titre;
	private String synopsis;
	private int nbSaison;
	private String[] personnages;
	
	public Serie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Serie(String titre, String synopsis, int nbSaison) {
		super();
		this.titre = titre;
		this.synopsis = synopsis;
		this.nbSaison = nbSaison;
	}

	public void presenterSerie() {
		System.out.println("Titre: " + titre);
		System.out.println("Synopsis: " + synopsis);
		System.out.println("Nombre de saison " + nbSaison);
	}
	
	public String obtenirInitialesPersonnages() {
		String retour = "";
		for(int i = 0; i < personnages.length; i++) {
			String personnage = personnages[i];
			String[] split = personnage.split(" ");
			String initiales = String.valueOf(split[0].charAt(0)) 
					+ "." + String.valueOf(split[1].charAt(0)) + ". \n";
			retour += initiales;
		}
		return retour;
		
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getNbSaison() {
		return nbSaison;
	}

	public void setNbSaison(int nbSaison) {
		this.nbSaison = nbSaison;
	}

	public String[] getPersonnages() {
		return personnages;
	}

	public void setPersonnages(String[] personnages) {
		this.personnages = personnages;
	}
	
}
