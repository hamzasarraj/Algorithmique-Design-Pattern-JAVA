package fr.eql.ai108.debug.scanner;

import java.util.Scanner;

public class Methode1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisissez un int");
		int unInt = scan.nextInt();
		System.out.println(unInt);
		//Ajouter un scan.nextLine() avant de scanner autre chose
		scan.nextLine();
		System.out.println("Saisissez une String");
		String uneString = scan.nextLine();
		System.out.println(uneString);
		System.out.println("Fin du programme");
		scan.close();

	}

}
