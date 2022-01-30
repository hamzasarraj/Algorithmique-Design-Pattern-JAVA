package fr.eql.ai108.exception;

public class Calculatrice {
	//Délaration au niveau de la méthode sa possibilité de jeter une exception
	public double diviser(double dividende, double diviseur) throws DivisionParZeroException {
		if(diviseur == 0) {
			//Notre méthode est susceptible de jeter une exception
			//si le programme tente de diviser par 0
			throw new DivisionParZeroException("Division par 0 impossible!");
		}	
		return dividende/diviseur;
	}
	
	public double additionner (double nb1, double nb2) throws GrandNombreException {
		int grandNombre = 100;
		if(nb1 > grandNombre || nb2 > grandNombre) {
			throw new GrandNombreException("Trop grand nombre !");
		}	
		return nb1 + nb2;
	}
}
