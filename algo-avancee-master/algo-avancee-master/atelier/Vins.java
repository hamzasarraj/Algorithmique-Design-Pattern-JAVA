package fr.eql.ai108.tpvins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Vins {

	//Variables de classe 
	static File fichierSource = new File("c:/DossierAI108/vins/VINStp.DON");
	static File fichierSortie = new File("c:/DossierAI108/vins/vinorama.txt");
	static FileReader fr = null;
	static BufferedReader br = null;
	static RandomAccessFile raf = null;
	static int tailleMax = 0; 
	static char[] tbChar = null;
	static byte[] tbCarac = null;
	static int tailleMaxNom = 0;
	static int tailleMaxAppellation = 0;
	static int tailleMaxRegion  = 0;
	static int tailleMaxProprietaire = 0;
	static int tailleMaxSurface= 0;
	static int tailleMaxStand = 0;
	static int nbCaracteres = 0;
	static int nbTabulation = 0;
	static int nbCaracteresTotal = 0;
	static int nbLignes = 0;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			parcourFichierSource();

			afficherTailleCategories();

			restituerFichierSortie();

			raf = new RandomAccessFile(fichierSortie, "rw");

			triRapide(raf, 0, nbLignes - 1);

			affichageVins();

			System.out.print("Saisissez votre recherche : ");
			System.out.println(rechercher(scan.nextLine()));


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void afficherTailleCategories() {
		System.out.println("taille nom : " + tailleMaxNom);
		System.out.println("taille appellation : " + tailleMaxAppellation);
		System.out.println("taille region : " + tailleMaxRegion);
		System.out.println("taille Proprietaire : " + tailleMaxProprietaire);
		System.out.println("taille surface : " + tailleMaxSurface);
		System.out.println("taille Stand : " + tailleMaxStand);
		System.out.println("Ceci est la taille max d'une ligne : " + nbCaracteresTotal);
	}

	public static void parcourFichierSource() {

		try {

			fr = new FileReader(fichierSource);
			br = new BufferedReader(fr);
			String ligne = br.readLine(); 

			while (ligne != null) { 				//Tant qu'il existe une ligne non vide alors...

				nbLignes++;							//compteur du nombre de lignes

				tbChar = ligne.toCharArray(); 		//On place chaque caractere de la ligne dans un tableau de caracteres

				for (char c : tbChar) {				//Pour chaque caractere du tableau on evalue si c'est un carac. ou une tabulation

					if (c != '\t') {

						nbCaracteres ++; 

					}else{

						nbTabulation++;

						switch (nbTabulation) {
						case 1: 
							if (nbCaracteres > tailleMaxNom ) {
								tailleMaxNom = nbCaracteres;
							}
							break;
						case 2:
							if (nbCaracteres > tailleMaxAppellation ) {
								tailleMaxAppellation = nbCaracteres;
							}
							break;
						case 3:
							if (nbCaracteres > tailleMaxRegion ) {
								tailleMaxRegion = nbCaracteres;
							}
							break;
						case 4:
							if (nbCaracteres > tailleMaxProprietaire ) {
								tailleMaxProprietaire = nbCaracteres;
							}
							break;
						case 5:	
							if (nbCaracteres > tailleMaxSurface ) {
								tailleMaxSurface = nbCaracteres;
							}
							break;
						default:
							break;
						}
						nbCaracteres = 0;
					} 
					if (nbTabulation == 5 && nbCaracteres > tailleMaxStand) {  //Gestion du cas particulier final car il n'y pas de tabulation à  la fin de phrase
						tailleMaxStand = nbCaracteres;
					}

				}

				nbCaracteres = 0;				//Remise à  zéro du nombre de Caracteres			
				nbTabulation = 0;				//Remsie à  zéro du nombre de tabulation 
				ligne = br.readLine(); 			//Passage à  la ligne suivante

			}

			nbCaracteresTotal = tailleMaxNom + tailleMaxAppellation + tailleMaxRegion + tailleMaxProprietaire + tailleMaxSurface + tailleMaxStand;

		} 
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void restituerFichierSortie() {
		
		try {

			fr = new FileReader(fichierSource);
			br = new BufferedReader(fr);
			raf = new RandomAccessFile(fichierSortie, "rw");
			String ligne = br.readLine();
			int nbEspaces = 0;

			while (ligne != null) {

				tbChar = ligne.toCharArray();

				for (int i = 0; i < tbChar.length; i++) {
					if (tbChar[i] != '\t') {

						raf.write(tbChar[i]);
						nbCaracteres ++;

					} else {

						nbTabulation++;

						switch (nbTabulation) {
						case 1: 
							nbEspaces = tailleMaxNom - nbCaracteres;
							break;
						case 2: 
							nbEspaces = tailleMaxAppellation - nbCaracteres;
							break;
						case 3: 
							nbEspaces = tailleMaxRegion - nbCaracteres;
							break;
						case 4: 
							nbEspaces = tailleMaxProprietaire - nbCaracteres;
							break;
						case 5: 
							nbEspaces = tailleMaxSurface - nbCaracteres;
							break;

						default:
							break; 
						}
						nbCaracteres = 0;

						if (nbEspaces > 0) {                           //Si et seulement si il y a nécessité d'écrire au moins un espace alors on rentre dans la boucle for
							for (int j = 0 ; j < nbEspaces; j++) {
								raf.write(' ');
							}
						}

					}

					if (nbEspaces > 0 && i == tbChar.length - 1) {		//Gestion du cas particulier : Categorie Stand : Si il y a besoin d'écrire au moins un espace alors o nrentre dans la boucle sinon on ne fait rien

						nbEspaces = tailleMaxStand - nbCaracteres;

					}

				}

				nbCaracteres = 0;									//Remise à zéro du nombre de Caracteres						
				nbTabulation = 0;									//Remise à zéro du nombre de Tabulations	
				ligne = br.readLine();								//Passage à  la ligne suivante

			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String recupererEnregistrement(RandomAccessFile raf, int index, int nombreCaracteres){ //Ajout du paramètre nombreCaracteres qui nous permet de définir si nous souhaitons récupérer l'ensemble des infos ou bien seulement une partie

		String donnee = "";
		tbCarac = new byte[nombreCaracteres];   			//Déclaration d'un tableau de bytes ayant une taille dépendante du ype d'info à renvoyer (EUM) -> stocker les infos

		try {

			raf.seek(index * nbCaracteresTotal);		//Positionnement au début de la donnee à extraire
			raf.read(tbCarac); 									//Lecture et enregistrement dans tbCarac de chaque caractere de la donnee et conversion en byte
			donnee = new String(tbCarac);						//instanciation sous forme d'un chaine de caracteres de chacun des byte de tbChar

		} catch (IOException e) {
			e.printStackTrace();
		}

		return donnee;
	}

	public static void ecrireEnregistrement(RandomAccessFile raf, String donnee, int index){

		try {

			raf.seek(index * nbCaracteresTotal);  		//Positionner le pointeur avant d'écrire la donnée
			tbCarac = donnee.getBytes();				//A partir de la chaine de carac "donnee" récupérer chaque caractere et les stocker sous forme de byte dans le tableau "tbcarac"
			raf.write(tbCarac);							//Ecrire chaque byte dans le fichier de sortie grace au RandomAccesFile

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void permuterVins(RandomAccessFile raf, int positionInitiale , int positionFinale) {

		String vinInitial = recupererEnregistrement(raf, positionInitiale, nbCaracteresTotal);
		String vinFinal = recupererEnregistrement(raf, positionFinale, nbCaracteresTotal);

		ecrireEnregistrement(raf, vinInitial, positionFinale);
		ecrireEnregistrement(raf, vinFinal, positionInitiale);

	}

	public static int partitionner(RandomAccessFile raf, int premierElement, int dernierElement) {

		int indexPivot = 0;
		int indexActuel = premierElement;
		String lignePivot = recupererEnregistrement(raf, dernierElement, nbCaracteresTotal);
		String ligneAComparer = "";

		for (int i = premierElement; i < dernierElement; i++) {

			ligneAComparer = recupererEnregistrement(raf, i, nbCaracteresTotal);

			if (ligneAComparer.compareTo(lignePivot) < 0) {				//Si valeur < Pivot alors on permute
				permuterVins(raf, i, indexActuel);
				indexActuel++;
			}

		}

		permuterVins(raf, indexActuel, dernierElement);					//On permute le pivot (dernier element) avec la position finale du pivot
		indexPivot = indexActuel;

		return indexPivot;

	}

	public static void triRapide(RandomAccessFile raf, int premierElement, int dernierElement) {

		if (premierElement < dernierElement) {

			int positionPivot = partitionner(raf, premierElement, dernierElement);

			triRapide(raf, premierElement, positionPivot - 1); // Tri rapide sur la partie gauche

			triRapide(raf, positionPivot + 1, dernierElement); // Tri rapide sur la partie droite

		}

	}

	public static String rechercher(String elementATrouver){

		int debut = 0;
		int fin = nbLignes;
		int comparaison;
		int milieu = 0;
		boolean trouve = false;    								//flag
		boolean rechercheTerminee = false;    					//flag

		while(!trouve && !rechercheTerminee) {

			milieu = (debut + fin) / 2;  																//Déterminer où se situe l'élément central
			String elementCentral = recupererEnregistrement(raf, milieu, elementATrouver.length());		//Récupère la chaine de caractere correspondant à l'élément central du fichier (en conservant le meme nombre de caractères que l'element recherché)
			comparaison = elementATrouver.toLowerCase().compareTo(elementCentral.toLowerCase());  		//Comparer l'élément à trouver avec l'élément placé au centre du fichier


			if (comparaison == 0) {

				for (int i = debut; i < fin; i++) {				//Balayer les occurences pouvant être similaires

					elementCentral = recupererEnregistrement(raf, i, elementATrouver.length());
					comparaison = elementATrouver.toLowerCase().compareTo(elementCentral.toLowerCase());

					if (comparaison == 0) {
						System.out.println("Résultat de la recherche (vin n° " + (i + 1) + ") ==> " + recupererEnregistrement(raf, i, nbCaracteresTotal));

					}
				}

				trouve = true;
			}
			if (comparaison < 0) {

				fin = milieu;

			}if(comparaison > 0) {

				debut = milieu + 1;	

			}if (fin == -1 || debut == nbLignes || debut == fin) {

				rechercheTerminee = true;
				break;

			}

		}
		if (trouve) {
			return "Ci-dessus, voici l'ensemble des résultats";
		}else {
			return elementATrouver + " n'est pas dans ce tableau";
		}



	}

	private static void affichageVins() {

		for (int i = 0; i < nbLignes; i++) {

			System.out.println("Le vin n° " + (i + 1) + " est : " + recupererEnregistrement(raf, i, nbCaracteresTotal));

		}
		
		System.out.println();

	}
}

