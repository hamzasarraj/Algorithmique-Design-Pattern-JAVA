package fr.eql.ai108.tpserie.model;

public class Serie {
	
	private String titre;
	private int nbSaison;
	private int anneeDiffusion;
	private String maisonProd;
	private String evaluation;
	
	public Serie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Serie(String titre, int nbSaison, int anneeDiffusion, String maisonProd, String evaluation) {
		super();
		this.titre = titre;
		this.nbSaison = nbSaison;
		this.anneeDiffusion = anneeDiffusion;
		this.maisonProd = maisonProd;
		this.evaluation = evaluation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeDiffusion;
		result = prime * result + ((evaluation == null) ? 0 : evaluation.hashCode());
		result = prime * result + ((maisonProd == null) ? 0 : maisonProd.hashCode());
		result = prime * result + nbSaison;
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
		Serie other = (Serie) obj;
		if (anneeDiffusion != other.anneeDiffusion)
			return false;
		if (evaluation == null) {
			if (other.evaluation != null)
				return false;
		} else if (!evaluation.equals(other.evaluation))
			return false;
		if (maisonProd == null) {
			if (other.maisonProd != null)
				return false;
		} else if (!maisonProd.equals(other.maisonProd))
			return false;
		if (nbSaison != other.nbSaison)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Serie [titre=" + titre + ", nbSaison=" + nbSaison + ", anneDiffusion=" + anneeDiffusion + ", maisonProd="
				+ maisonProd + ", evaluation=" + evaluation + "]";
	}
	public String getTitre() {
		return titre;
	}
	public int getNbSaison() {
		return nbSaison;
	}
	public int getAnneeDiffusion() {
		return anneeDiffusion;
	}
	public String getMaisonProd() {
		return maisonProd;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setNbSaison(int nbSaison) {
		this.nbSaison = nbSaison;
	}
	public void setAnneeDiffusion(int anneDiffusion) {
		this.anneeDiffusion = anneDiffusion;
	}
	public void setMaisonProd(String maisonProd) {
		this.maisonProd = maisonProd;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
}
