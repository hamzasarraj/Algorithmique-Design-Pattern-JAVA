package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice7 {

	public static void main(String[] args) {
		int nb;
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir un nombre : ");
		nb = sc.nextInt();
		System.out.println("Table de " + nb);
		for (int i = 1; i <= 10; i++) {
			System.out.println(nb + " * " + i + " = " + nb*i);
		}
		sc.close();
	}

}
