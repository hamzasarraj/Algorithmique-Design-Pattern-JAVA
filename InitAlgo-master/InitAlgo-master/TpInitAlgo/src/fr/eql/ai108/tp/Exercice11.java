package fr.eql.ai108.tp;

import java.util.Random;
import java.util.Scanner;

public class Exercice11 {

	public static void main(String[] args) {
		int nbAllu;
		int nbAlluJoueur =0;
		int nbAlluOrdi =0;
		String restart = "o";
		String commence;
		Random random = new Random();
		Scanner entree;

		do {
			entree = new Scanner(System.in);
			nbAllu = 20;
			
			System.out.println("BIENVENUE DANS LE JEU DE NIM !");
			System.out.println("Il y a " + nbAllu + " allumettes.");
			System.out.println("Vous pouvez prendre 1, 2 ou 3 allumettes.");
			System.out.println("Celui qui prend la dernière allumette a gagné.");
			System.out.println("Qui commence ? (joueur/ordinateur)");
			commence = entree.nextLine();
			
			while (nbAllu >= 1) {

				if(commence.equals("joueur")) {
					System.out.println("C'est à vous de jouer. Combien prenez vous d'allumettes?");
					nbAlluJoueur = entree.nextInt();
					while(nbAlluJoueur <=0 || nbAlluJoueur > 3) {
						System.out.println("Tricheur! On a dit 3 allumettes max ! Recommence !");
						nbAlluJoueur = entree.nextInt();
					}

					nbAllu = nbAllu - nbAlluJoueur; // (ou n- = nbJoueur1) 
					System.out.println("Il reste " + nbAllu + " allumette(s).\n");

					if (nbAllu == 0) {
						System.out.println("Le joueur 1 a gagné");

					} 

					nbAlluOrdi = 4 - nbAlluJoueur;

					nbAllu = nbAllu - nbAlluOrdi;
					System.out.println("L'ordinateur a pris " + nbAlluOrdi + " allumette(s).");
					System.out.println("Il reste " + nbAllu + " allumette(s).\n");

					if (nbAllu == 0) {
						System.out.println("L'ordinateur a gagné");

					} 
				}else {
					switch (nbAllu) {
					case 1:
						nbAlluOrdi = 1;
						break;
					case 2:
						nbAlluOrdi = 2;
						break;
					case 3:
						nbAlluOrdi = 3;
						break;

					default:
						nbAlluOrdi = random.nextInt(3) +1;
						break;
					}

					nbAllu = nbAllu - nbAlluOrdi;
					System.out.println("L'ordinateur a pris " + nbAlluOrdi + " allumette(s).");
					System.out.println("Il reste " + nbAllu + " allumette(s).\n");

					if (nbAllu == 0) {
						System.out.println("L'ordinateur a gagné \n");

					} 
					if (nbAllu > 0) {
						System.out.println("C'est à vous de jouer. Combien prenez vous d'allumettes?");
						nbAlluJoueur = entree.nextInt();
						while(nbAlluJoueur <=0 || nbAlluJoueur > 3) {
							System.out.println("Tricheur! On a dit 3 allumettes max ! Recommence !");
							nbAlluJoueur = entree.nextInt();
						}

						nbAllu = nbAllu - nbAlluJoueur; // (ou n- = nbJoueur1) 
						System.out.println("Il reste " + nbAllu + " allumette(s).\n");

						if (nbAllu == 0) {
							System.out.println("Le joueur 1 a gagné \n");

						} 
					}					
				}
			}
			System.out.println("Voulez-vous rejouer ? (o ou n)");
			restart = entree.next();
		}while (restart.equals("o"));
		entree.close();
		System.out.println("Fin du programme");
	}

}

