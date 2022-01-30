package fr.eql.initalgo.demo;

import java.util.Scanner;

public class DemoInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue. Choisissez le nom "
				+ "de votre héros");
		String nomHeros = scan.nextLine();
		
		System.out.println("Quel est l'âge de votre héros?");
		int age = scan.nextInt();
		
		System.out.println("Votre héros s'appelle donc " 
		+ nomHeros + " et a " + age + " ans.");
		
		scan.close();
		
	}

}
