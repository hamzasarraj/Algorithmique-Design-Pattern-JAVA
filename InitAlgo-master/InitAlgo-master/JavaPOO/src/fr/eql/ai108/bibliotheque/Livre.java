package fr.eql.ai108.bibliotheque;

public class Livre {
	private String titre;
	private String auteur;
	private int isbn;
	private Categorie categorie;
	
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livre(String titre, String auteur, int isbn, Categorie categorie) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.isbn = isbn;
		this.categorie = categorie;
	}
	
	public String getTitre() {
		return titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public int getIsbn() {
		return isbn;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
