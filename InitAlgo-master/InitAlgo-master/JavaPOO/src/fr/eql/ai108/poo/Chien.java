package fr.eql.ai108.poo;

public class Chien {
	
	//Attributs ou variables d'instance de notre chien
	public String nom;
	public int age;
	public float taille;
	public float poids;
	public String race;
	public boolean estGentil;
	public char pedigree;
	
	//Constructeurs:

	//Constructeur vide
	public Chien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Chien(String nom, int age, float taille, float poids, String race, boolean estGentil, char pedigree) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.race = race;
		this.estGentil = estGentil;
		this.pedigree = pedigree;
	}

	public Chien(String nom, int age, float taille, float poids, boolean estGentil) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.estGentil = estGentil;
	}



	public void aboyer() {
		System.out.println("Ouaf ouaf !!!");
	}
	
	public void ramenerLaBalle(int nbFois) {
		System.out.println("Je ramène " + nbFois + " la baballe");
	}
	
	public float rapportTaillePoids() {
		return taille/poids;
		
	}
}
