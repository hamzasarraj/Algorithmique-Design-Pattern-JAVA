package fr.eql.initalgo.demo;

import java.util.Scanner;

public class DemoBouclesConditionnelles {

	public static void main(String[] args) {
		//La boucle tant que
		int nombre;
		Scanner scan = new Scanner(System.in);
		System.out.println("Donnez moi un nombre positif");
		nombre = scan.nextInt();
		while(nombre <= 0) {
			System.out.println("Erreur; votre nombre n'est pas positif. Recommencez");
			nombre = scan.nextInt();
		}
		System.out.println("Merci, le nombre " + nombre + " est bien positif");

		
		//La boucle répéter tant que
		
		float versement;
		float credit = 1000.0f;
		
		do {
			System.out.println("Votre crédit est de " + credit + "euros.");
			System.out.println("Quel versement souhaitez vous effectuer ?");
			versement = scan.nextFloat();
			credit -= versement;
		}while(credit > 0);
		System.out.println("Votre crédit est remboursé");
	}

}
