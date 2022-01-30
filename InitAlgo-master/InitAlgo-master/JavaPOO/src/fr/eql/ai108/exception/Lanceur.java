package fr.eql.ai108.exception;

public class Lanceur {

	//Ici l'exception s'est propagée jusqu'au main et n'a jamais étée gérée
	//Du coup, le programme cesse de s'exécuter
//	public static void main(String[] args) throws Exception {
//		Calculatrice calc = new Calculatrice();
//		double result = calc.diviser(20, 0);
//		System.out.println("____________________________________");
//		System.out.println(result);
//
//	}
	public static void main(String[] args){
		Calculatrice calc = new Calculatrice();
		double result = 0;
		//Essaye d'effectuer la division: try
		try {
			result = calc.diviser(20, 0);
			double resultAdd = calc.additionner(100, 150);
			//Si l'exception est jetée, attrape là et arrête de la propager
			
			//Gérer mes deux exceptions au même endroit:
		} catch (DivisionParZeroException | GrandNombreException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("Attention vous ne pouvez"
					+ "Pas diviser par zéro. Votre résultat est don faux");
		} 
//		catch (GrandNombreException e) {
//			// Je gère ici le GrandNombreException: un bloc catch par Exeption à gérer
//			e.printStackTrace();
//		}
		finally {
			//On ferme ici toutes les ressources utilisées que l'exception soit jetée ou pas
			System.out.println("Nettoyage");
		}
		
		//Faire un bloc try catch par exception à catcher:
//		try {
//			double resultAdd = calc.additionner(20, 150);
//		} catch (GrandNombreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("____________________________________");
		System.out.println(result);

	}

}
