package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nb;
		System.out.println("Veuillez choisir un nombre : ");
		nb = sc.nextInt();
		for (int i = nb+1; i <= nb + 10; i++) {
			System.out.print(i + " "); // seulement sur une ligne
		}
		sc.close();
	}

}
