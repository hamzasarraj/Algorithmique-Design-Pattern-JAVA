package fr.eql.ai108.bibliotheque;

public class Lecteur {
	private String nom;
	private String prenom;
	private String adresse;
	private Livre[] livres;
	
	public Lecteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lecteur(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public Livre[] getLivres() {
		return livres;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setLivres(Livre[] livres) {
		this.livres = livres;
	}
		
}
