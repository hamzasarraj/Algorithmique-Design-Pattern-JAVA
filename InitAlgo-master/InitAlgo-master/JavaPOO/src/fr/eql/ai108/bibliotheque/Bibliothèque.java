package fr.eql.ai108.bibliotheque;

import java.util.Scanner;

public class Bibliothèque {

	public static void main(String[] args) {
		
		Lecteur lecteur = null;
		Scanner scan = new Scanner(System.in);
		String reponse ="";
		
		System.out.println("*************************");
		System.out.println("BIENVENUE DANS iBIBLIO");
		System.out.println("*************************");
		
		//Je boucle sur les menus utilisateur tant que l'utilisateur
		//ne souhaite pas quitter l'application
		
		do {					
		//SI le lecteur n'a pas renseigné son identité, je lui demande (nom, prenom, etc.)
			if(lecteur == null) {
				System.out.println("Pour commencer, veuillez renseigner votre identité");
				System.out.println("Quel est votre nom?");
				String nom = scan.nextLine();
				System.out.println("Quel est votre prénom?");
				String prenom = scan.nextLine();
				System.out.println("Quelle est votre adresse?");
				String adresse = scan.nextLine();
				lecteur = new Lecteur(nom, prenom, adresse);
			}
		//MENU
		//Je propose à l'utilisateur d'afficher son identité
		System.out.println("Que voulez vous faire ?");
		System.out.println("\t Afficher mon identité (I)");
		//SI l'utilisateur a enregistré des livre, je lui propose de les afficher
		if(lecteur.getLivres() != null) {
			System.out.println("\t Afficher mes livre (L)");
		}
		//Si l'utilisateur n'a pas enregistré de livres, je lui propose de les enregistrer
		if(lecteur.getLivres() == null) {
			System.out.println("\t Enregistrer mes livres (E)");
		}
		//Je propose à l'utilisateur de quitter l'application
		System.out.println("\t Quitter l'application (Q)");
		reponse = scan.nextLine();
		switch (reponse) {
		case "I":
			System.out.println("IDENTITE \n Nom: " + lecteur.getNom() + "\n Prenom : " 
					+ lecteur.getPrenom() + "\n Adresse: " + lecteur.getAdresse());
			break;
		case "E":
			System.out.println("Combien voulez vous enregistrer de livres ?");
			//On connait le nombre de livres que souhaite enregistrer l'utilisateur
			int nbLivres = Integer.parseInt(scan.nextLine());
			//On donne à notre utilisateur un tableau de livre de cette taille
			lecteur.setLivres(new Livre[nbLivres]);
			//Pour chacun des livres que souhaite ajouter l'utilisateur
			for(int i = 0; i < lecteur.getLivres().length ; i++) {
				//On récupère chacun des champs du livre
				System.out.println("Saisissez les informations du livre numero " + (i + 1));
				System.out.println("Titre du livre ?");
				String titre = scan.nextLine();
				System.out.println("Auteur du livre ?");
				String auteur = scan.nextLine();
				System.out.println("ISBN du livre ?");
				int isbn = Integer.parseInt(scan.nextLine());
				System.out.println("Catégorie du livre ? (Merci de choisir parmi les "
						+ "catégories suivantes");
				//On itère sur les différentes valeurs de notre enum pour permettre
				//à l'utilisateur de choisir sa catégorie
				Categorie[] categories = Categorie.values();
				for (Categorie categorie : categories) {
					System.out.println(categorie);
				}
				Categorie categorie = Categorie.valueOf(scan.nextLine().toUpperCase());
				//On instancie un livre avec les valeurs récupérées
				Livre livre = new Livre(titre, auteur, isbn, categorie);
				//On ajoute le livre dans le tableau de livre que possède le lecteur
				//à l'index où l'on est dans la boucle
				lecteur.getLivres()[i] = livre;
			}
			break;
		case "L":
			for (Livre livre : lecteur.getLivres()) {
				System.out.println("Titre : " + livre.getTitre() + "\t Auteur: "
						+ livre.getAuteur() + "\t ISBN: " + livre.getIsbn());
			}
			break;

		default:
			break;
		}
		}while(!reponse.equals("Q"));
		System.out.println("Fin du programme");
		scan.close();
	}

}
