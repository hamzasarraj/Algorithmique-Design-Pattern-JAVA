package fr.eql.ai108.real.poo;

public class Collier {
	
	private String couleur;
	private String matiere;
	public Collier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collier(String couleur, String matiere) {
		super();
		this.couleur = couleur;
		this.matiere = matiere;
	}
	public String getCouleur() {
		return couleur;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
}
