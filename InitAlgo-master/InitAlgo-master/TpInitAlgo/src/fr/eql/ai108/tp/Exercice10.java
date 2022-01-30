package fr.eql.ai108.tp;

import java.util.Random;
import java.util.Scanner;

public class Exercice10 {

	public static void main(String[] args) {
		
		Random rdm = new Random();
		Scanner scan = new Scanner(System.in);
		String rejouer = "";
		int score = 0;
		
		//Boucle de jeu
		
		do {
			int cible = rdm.nextInt(100) +1;
			int propositionJoueur = 0;
			int nbMaxEssais = 5;
			int nbEssais = 0;
			
			//Boucle de partie
			//Tant que le joueur n'a pas trouve la cible et tant que le nombre d'essais max
			//n'a pas été épuisé
			do {
				nbEssais++;
				//demander de choisi un nombre
				System.out.println("Choisissez un nombre");
				propositionJoueur = scan.nextInt();
				scan.nextLine();
				
				//lui donner un indice
				if(propositionJoueur > cible) {
					System.out.println("C'est plus petit");
				}else if (propositionJoueur < cible) {
					System.out.println("C'est plus grand");
				}
				
			}while(propositionJoueur != cible && nbEssais < nbMaxEssais);
		
			//Si le joueur a trouvé le bon nombre
			if(propositionJoueur == cible) {
				score++;
				System.out.println("Bravo! Vous avez trouve en " + nbEssais + " essais. Votre score est de " + score);
			}else {
				//Si le joueur n'a pas trouvé le bon nombre
				score--;
				System.out.println("Dommage... le nombre a trouver était: " + cible + ". Votre score est : " + score);
					
			}
						
			//Sortie de partie 
						
			System.out.println("Voulez vous rejouer (o/n)");
			rejouer = scan.nextLine();
		}while(!rejouer.equals("n"));
		
		System.out.println("Fin du jeu");
		scan.close();
	}
}
