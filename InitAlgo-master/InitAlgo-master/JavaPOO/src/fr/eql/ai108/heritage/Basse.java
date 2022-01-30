package fr.eql.ai108.heritage;

public final class Basse extends InstrumentDeMusique{

	private int nbCordes;
	private boolean estActive;
	
	
	//Redéfinition de la méthode faire de la musique:
	@Override
	public void faireDeLaMusique() {
		System.out.println("BimBamBoumBamBam");
	}

	public Basse(String nom, String marque, float prix) {
		super(nom, marque, prix);
		// TODO Auto-generated constructor stub
	}

	public Basse(String nom, String marque, float prix, int nbCordes, boolean estActive) {
		super(nom, marque, prix);
		this.nbCordes = nbCordes;
		this.estActive = estActive;
	}

	public int getNbCordes() {
		return nbCordes;
	}

	public boolean isEstActive() {
		return estActive;
	}

	public void setNbCordes(int nbCordes) {
		this.nbCordes = nbCordes;
	}

	public void setEstActive(boolean estActive) {
		this.estActive = estActive;
	}

	@Override
	public boolean estLePLusBelInstrumentDuMonde() {
		return true;
	}	
}
