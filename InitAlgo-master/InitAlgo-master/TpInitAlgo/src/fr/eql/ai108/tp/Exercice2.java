package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice2 {

	public static void main(String[] args) {
		int nb;
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez choisir un entier");
		nb = scan.nextInt();
		if(nb%2 == 0) {
			System.out.println("Votre entier est pair");
		}else {
			System.out.println("Votre entier est impair");
		}
		scan.close();
	}

}
