package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nb, resultat = 1;
		System.out.println("Veuillez choisir un nombre strictement positif : ");
		nb = sc.nextInt();
		if (nb > 0) {
			for (int i = 1; i <= nb; i++) {
				resultat *= i;
			}
		} else {
			System.out.println("Vous n'avez pas choisi un nombre strictement positif");
		}
		System.out.println("Le résultat du produit des entiers de 1 jusqu'à " + nb + " est : " + resultat);

		sc.close();
	}

}
