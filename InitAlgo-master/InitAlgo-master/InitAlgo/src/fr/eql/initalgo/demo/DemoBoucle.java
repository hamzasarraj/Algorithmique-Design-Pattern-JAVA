package fr.eql.initalgo.demo;

import java.util.Scanner;

public class DemoBoucle {

	public static void main(String[] args) {
		
		//La boucle POUR:
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i + "éme tour de boucle");
		}
		
		int nbVal, compteur, valeur, totalValeur = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Combien de valeurs"
				+ " souhaitez vous additionner?");
		nbVal = scan.nextInt();
		for(compteur = 0; compteur < nbVal; compteur++) {
			System.out.println("Saisissez un nombre");
			valeur = scan.nextInt();
			totalValeur += valeur;
		}
		System.out.println("Le total des " + nbVal + " valeurs"
				+ " est: " + totalValeur);
		scan.close();

	}

}
