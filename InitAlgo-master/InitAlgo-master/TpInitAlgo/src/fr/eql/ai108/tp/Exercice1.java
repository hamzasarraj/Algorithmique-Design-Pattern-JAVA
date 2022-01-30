package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice1 {

	public static void main(String[] args) {
		int nb;
		Scanner scan = new Scanner(System.in);
		System.out.println("Choisissez un nombre");
		nb = scan.nextInt();
		if (nb > 0) {
			System.out.println("Votre nombre est positif");
		}else if (nb < 0) {
			System.out.println("Votre nombre est négatif");
		}else {
			System.out.println("Ni l'un ni l'autre");
		}
		scan.close();
	}

}
