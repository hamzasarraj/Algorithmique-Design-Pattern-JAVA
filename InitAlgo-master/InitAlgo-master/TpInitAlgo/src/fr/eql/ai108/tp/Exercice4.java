package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice4 {
	public static void main(String[] args) {
		//Correction exercice 4
		Scanner scan = new Scanner(System.in);
		int age;
		System.out.println("Quel est votre age ?");
		age = scan.nextInt();
		
		switch (age) {
		case 0:
		case 1:
		case 2:
		case 3:	
		case 4:
		case 5:
			System.out.println("Vous n'entrez dans aucune catégorie");
			break;
		case 6:
		case 7:
			System.out.println("Poussin");
			break;
		case 8:
		case 9: System.out.println("Pupille");
		    break;
		case 10:
		case 11:
			System.out.println("Minime");
			break;
		default:
			System.out.println("Cadet");
			break;
		}
		scan.close();
	}
}
