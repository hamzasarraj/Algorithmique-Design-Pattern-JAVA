package fr.eql.ai108.tp;

public class Exercice9 {

	public static void main(String[] args) {
		//Déclaration de variable
		int taille = 20;
		int nbEspace, nbEtoile;
		//Pour chaque étage de la pyramide
		for (int etage = 0; etage < taille; etage++) {
			
			//Calculer le nombre d'espaces à afficher
			nbEspace = taille - etage - 1;
			//Calculer le nombre d'étoiles à afficher
			nbEtoile = 2 * etage + 1;
			//Afficher le nombre d'espace nécessaire:
			for (int i = 0; i < nbEspace; i++) {
				System.out.print(" ");
			}
			//Afficher le nombre d'étoile nécessaire
			for (int i = 0; i< nbEtoile; i++) {
				System.out.print("*");
			}
			System.out.println();
			
		}

	}

}
