package fr.eql.ai108.real.poo;

public class Chien {
	
	//VARIABLES D'INSTANCE
	private String nom;
	private int age;
	private float taille;
	private float poids;
	private String race;
	private boolean estGentil;
	private char pedigree;
	private Collier collier;
	private Jouet[] jouets;
	private GroupeChien groupe;
	
	//VARIABLE DE CLASSE
	private static int nbChien;
	
	//CONSTANTE
	private static final int AGE_MAX = 30;
	
	//CONSTRUCTEURS

	//Génération du constructeur vide:  Alt + Shift + S + C
	public Chien() {
		nbChien++;
		// TODO Auto-generated constructor stub
	}
	//Génération du constructeur surchargé: Alt + Shift + S + O
	public Chien(String nom, int age, float taille, float poids, String race, boolean estGentil, char pedigree) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.race = race;
		this.estGentil = estGentil;
		this.pedigree = pedigree;
		nbChien++;
	}
	
	public Chien(String nom, int age, float taille, float poids, String race, char pedigree) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.race = race;
		this.pedigree = pedigree;
		nbChien++;
	}
	
	public Chien(String nom, int age, float taille, float poids, String race, boolean estGentil, char pedigree,
			Collier collier) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.race = race;
		this.estGentil = estGentil;
		this.pedigree = pedigree;
		this.collier = collier;
	}
	
	public Chien(String nom, int age, float taille, float poids, String race, boolean estGentil, char pedigree,
			Collier collier, Jouet[] jouets) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.race = race;
		this.estGentil = estGentil;
		this.pedigree = pedigree;
		this.collier = collier;
		this.jouets = jouets;
	}
	
	public Chien(String nom, int age, float taille, float poids, String race, boolean estGentil, char pedigree,
			Jouet[] jouets) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.race = race;
		this.estGentil = estGentil;
		this.pedigree = pedigree;
		this.jouets = jouets;
	}
	
	public Chien(String nom, int age, float taille, float poids, String race, boolean estGentil, char pedigree,
			Jouet[] jouets, GroupeChien groupe) {
		super();
		this.nom = nom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.race = race;
		this.estGentil = estGentil;
		this.pedigree = pedigree;
		this.jouets = jouets;
		this.groupe = groupe;
	}
	
	//REDEFINITION DE LA METHODE toString() (ALT + Shit + S   S)
	@Override
	public String toString() {
		return "Chien [nom=" + nom + ", age=" + age + ", taille=" + taille + ", poids=" + poids + ", race=" + race
				+ ", estGentil=" + estGentil + ", pedigree=" + pedigree + "]";
	}
	
	//METHODE HASHCODE ET EQUALS (ALT + Shit + S   H)

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (estGentil ? 1231 : 1237);
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + pedigree;
		result = prime * result + Float.floatToIntBits(poids);
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + Float.floatToIntBits(taille);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chien other = (Chien) obj;
		if (age != other.age)
			return false;
		if (estGentil != other.estGentil)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pedigree != other.pedigree)
			return false;
		if (Float.floatToIntBits(poids) != Float.floatToIntBits(other.poids))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (Float.floatToIntBits(taille) != Float.floatToIntBits(other.taille))
			return false;
		return true;
	}
	
	//METHODES D'INSTANCE
	public void aboyer() {
		System.out.println("Ouaf ouaf !!!");
	}
	
	public void ramenerLaBalle(int nbFois) {
		System.out.println("Je ramène " + nbFois + " la baballe");
	}
	
	public float rapportTaillePoids() {
		return taille/poids;
		
	}
	
	//ACCESSEURS ET MUTATEURS

	//Génération des getters et setters: Alt + Shift + S + R
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public boolean isEstGentil() {
		return estGentil;
	}

	public void setEstGentil(boolean estGentil) {
		this.estGentil = estGentil;
	}

	public char getPedigree() {
		return pedigree;
	}

	public void setPedigree(char pedigree) {
		this.pedigree = pedigree;
	}
	public static int getNbChien() {
		return nbChien;
	}
	public Collier getCollier() {
		return collier;
	}
	public void setCollier(Collier collier) {
		this.collier = collier;
	}
	public Jouet[] getJouets() {
		return jouets;
	}
	public void setJouets(Jouet[] jouets) {
		this.jouets = jouets;
	}
	public GroupeChien getGroupe() {
		return groupe;
	}
	public void setGroupe(GroupeChien groupe) {
		this.groupe = groupe;
	}
	public static int getAgeMax() {
		return AGE_MAX;
	}
	//Methode clone (ALT + Shit + S   V)
	@Override
	protected Chien clone() throws CloneNotSupportedException {
		Chien newInstance = new Chien(this.nom,this.age, this.taille, 
				this.poids, this.race, this.pedigree);
		return newInstance;
	}
	
	
	
	
}
