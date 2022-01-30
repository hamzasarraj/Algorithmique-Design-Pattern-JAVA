package fr.eql.ai108.bibliotheque.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bibliothèque {

	public static void main(String[] args) {

		Lecteur lecteur = null;
		Scanner scan = new Scanner(System.in);
		String reponse ="";
		//Initialisation de la Map
		Map<Categorie, List<Livre>> mapCategorieLivre =
				new HashMap<Categorie, List<Livre>>();
		Categorie[] categories = Categorie.values();
		for (Categorie categorie : categories) {
			mapCategorieLivre.put(categorie, new ArrayList<Livre>());
		}
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
				lecteur.setLivres(new ArrayList<Livre>());
			}
			//MENU
			//Je propose à l'utilisateur d'afficher son identité
			System.out.println("Que voulez vous faire ?");
			System.out.println("\t Afficher mon identité (I)");
			//SI l'utilisateur a enregistré des livre, je lui propose de les afficher
			if(lecteur.getLivres().size() > 0) {
				System.out.println("\t Afficher mes livre (L)");
				System.out.println("\t Afficher mes livres par catégorie (C)");
			}
			//Si l'utilisateur n'a pas enregistré de livres, je lui propose de les enregistrer	
			System.out.println("\t Enregistrer mes livres (E)");

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
				int nbLivres =0;
				boolean error = true;

				do {
					try {
						nbLivres = Integer.parseInt(scan.nextLine());
						error = false;
					}catch (NumberFormatException e) {
						System.out.println("Erreur: Veuillez saisir un nombre entier !");
						error = true;
					}
				}while(error);
				//Pour chacun des livres que souhaite ajouter l'utilisateur
				for(int i = 0; i < nbLivres ; i++) {
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
					for (Categorie categorie : categories) {
						System.out.println(categorie);
					}
					Categorie categorie = Categorie.valueOf(scan.nextLine().toUpperCase());
					//On instancie un livre avec les valeurs récupérées
					Livre livre = new Livre(titre, auteur, isbn, categorie);
					//On ajoute le livre dans la liste de livre que possède le lecteur
					lecteur.getLivres().add(livre);
					//Après avoir ajouté le livre à la liste de livres du lecteur
					//Je l'ajoute également dans la HashMap
					mapCategorieLivre.get(categorie).add(livre);
				}
				break;
			case "L":
				for (Livre livre : lecteur.getLivres()) {
					System.out.println("Titre : " + livre.getTitre() + "\t Auteur: "
							+ livre.getAuteur() + "\t ISBN: " + livre.getIsbn());
				}
				break;
			case "C":
				System.out.println("De quelle catégorie souhaitez vous afficher les livres ?");
				for (Categorie categorie : categories) {
					System.out.println(categorie);
				}
				Categorie categorie = Categorie.valueOf(scan.nextLine().toUpperCase());
				List<Livre> livres = mapCategorieLivre.get(categorie);
				for (Livre livre : livres) {
					System.out.println(livre);
				}
				if(livres.size() == 0) {
					System.out.println("Aucun livre dans cette catégorie");
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
