package fr.eql.ai108.convertisseur;

public class LanceurConvertisseur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double montant = 50;
		//Pour une méthode static, je n'ai pas besoin d'instance de classe:
		double result = Convertisseur.euroToUSD(montant);
		
		//Pour une méthode d'instance, j'ai besoin d'une instance de classe pour l'invoquer:
		Convertisseur convertisseur = new Convertisseur();
		double result2 = convertisseur.euroToYEN(montant);
		System.out.println(result2);
	}

}
