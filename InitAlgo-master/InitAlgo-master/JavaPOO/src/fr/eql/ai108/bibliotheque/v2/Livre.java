package fr.eql.ai108.bibliotheque.v2;

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
	
	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur + ", isbn=" + isbn + ", categorie=" + categorie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + isbn;
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Livre other = (Livre) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (categorie != other.categorie)
			return false;
		if (isbn != other.isbn)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
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
