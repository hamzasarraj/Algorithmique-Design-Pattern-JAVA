package fr.eql.initalgo.demo;

import java.util.Scanner;

public class DemoStructureDeControle {

	public static void main(String[] args) {
		
		int x = 127;
		int y = 255;
		
		//Si avec l'opérateur booléen OU: | soit ||
		
		if ((x > 400) || (y < 50)) {
			System.out.println("Ça passe");
		}else {
			System.out.println("Ça passe pas");
		}
		
		//SI avec l'opérateur ET: & soit &&
		if((x == 42) && (y >= 30)) {
			System.out.println("Ça passe");
		}else if (x <= 4) {
			System.out.println("Ça passe dans le else if");
		}else {
			System.out.println("Ça ne passe ni dans le if "
					+ "ni dans le else if");
		}
		
		//Le OU Exclusif: ^
		if((x != 0) ^ (y == 255)) {
			System.out.println("Ça passe dans le XOR");
		}
		
		String chaine1 = "toto";
		String chaine2 = "tata";
		//Pour comparer des chaines de caractères ou des objects
		//on utilise la méthode equals
		if(!chaine1.equals(chaine2)) {
			System.out.println("Les chaines sont pas identiques");
		}
		
		//La structure de contrôle switch
		Scanner scan = new Scanner(System.in);
		String arme = null;
		System.out.println("Un troll vous attaque; quelle arme "
				+ "souhaitez vous utiliser ? (épée/arc/magie)");
		
		arme = scan.nextLine();
		switch(arme) {
		case "épée" :
			System.out.println("Vous avez choisi la voie du guerrier;"
					+ " votre coup d'épée fait perdre 2PV au troll");
			break;
		case "arc" :
			System.out.println("Vous avez choisi la voie du chasseur;"
					+ "votre flèche fait perdre 1PV au troll");
			break;
		case "magie" :
			System.out.println("Vous avez choisi la voie du magicien;"
					+ "malheureusement le troll est résistant à la magie et vous bouffer");
			break;
		default:
			System.out.println("Vous faites le malin."
					+ " Vous êtes donc tout nu. Le troll vous bouffe");
			break;
		}	
		scan.close();
	}

}
