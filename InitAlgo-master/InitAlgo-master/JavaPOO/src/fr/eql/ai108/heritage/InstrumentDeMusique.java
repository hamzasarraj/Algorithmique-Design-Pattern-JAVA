package fr.eql.ai108.heritage;

public abstract class InstrumentDeMusique {
	
	private String nom;
	private String marque;
	private float prix;
	
	public abstract boolean estLePLusBelInstrumentDuMonde();
	
	public InstrumentDeMusique(String nom, String marque, float prix) {
		super();
		this.nom = nom;
		this.marque = marque;
		this.prix = prix;
	}
	
	public void faireDeLaMusique() {
		System.out.println("PimPamPimPoumPoum");
	}

	public String getNom() {
		return nom;
	}

	public String getMarque() {
		return marque;
	}

	public float getPrix() {
		return prix;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
		
}
