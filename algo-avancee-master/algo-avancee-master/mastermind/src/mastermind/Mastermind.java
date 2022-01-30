package mastermind;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	
	
	public static void main(String[] args) {

		//Bleu,  Jaune,  Vert,  Rouge,  Marron  et  Noir
		char[] couleursPossibles = {'b','j','v','r','m','n'};
		int taille = 4;
		int nbEssais = 10;

		Scanner s = new Scanner(System.in);
		
		char[] ordi = getChoixOrdi(taille, couleursPossibles);

		boolean victoire = false;
		boolean[] places = new boolean[taille];
		boolean[] trouves = new boolean[taille];
		
		do 
		{
			char[] propal = getChoixJoueur(s);

			// initilaiser dynamiquement les tableaux (boucle for sur la taille)  
			for (int i = 0; i < taille; i++) {
				places[i] = false;
				trouves[i] = false;
			}
			
			int nbplaces = 0;
			int nbtrouves = 0;

			// plac�s :
			for (int i = 0; i < taille; i++) 
			{
				if (ordi[i] == propal[i]) 
				{
					places[i] = true;
					propal[i] = ' ';
				}
			}
			
			// trouv�s :
			for (int i = 0; i < taille; i++)
			{
				for (int j = 0; j < taille; j++) 
				{
					if (i != j && propal[i] == ordi[j] && places[j] == false && trouves[j] == false) 
					{
						trouves[j] = true;
						propal[i] = ' ';
					}
				}
			}			
			
			for (int i = 0; i < taille; i++)
			{
				if (trouves[i])
				{
					nbtrouves++;
				}
				if (places[i])
				{
					nbplaces++;
				}
			}

			System.out.println("trouv�s : " + nbtrouves);
			System.out.println("plac�s : " + nbplaces);
			
			nbEssais--;
			if (nbplaces == taille)
			{
				victoire = true;
			}

		} while (nbEssais > 0 && !victoire);

		if (victoire)
		{
			System.out.println("GAGNE !!!");
		}
		else
		{
			System.out.println("PERDU :(");
		}
		
	}

	public static char[] getChoixJoueur(Scanner s)
	{		
		System.out.print("proposition : ");
		String sPropal = s.nextLine();
		char[] propal = sPropal.toCharArray();
		return propal;
	}
	
	public static char[] getChoixOrdi(int taille, char[] couleursPossibles)
	{	
		// g�n�rer al�atoirement choix ordi
		Random r = new Random();
				
		char[] ordi = new char[taille];
				
		for(int i = 0; i < taille; i++)
		{
			int indexCouleur = r.nextInt(couleursPossibles.length); // valeur entre 0 et 5
			ordi[i] = couleursPossibles[indexCouleur];
			System.out.print(ordi[i]);
		}
		System.out.println();
		System.out.println("--------------");
		
		return ordi;
	}
}
