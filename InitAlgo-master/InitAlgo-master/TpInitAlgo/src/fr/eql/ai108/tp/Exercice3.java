package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nb;
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez choisir un entier");
		nb = scan.nextInt();
		if(nb%2 == 0) {
			System.out.println("Résultat si nb est pair: " + nb/2);
		}else {
			System.out.println("Résultat si nb est impair: " + (3*nb+1));
		}
		
		int resultat = nb%2 == 0 ? nb/2 : 3*nb+1;
		System.out.println(resultat);
		scan.close();
	}

}
