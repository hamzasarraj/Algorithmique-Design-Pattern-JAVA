public class AppJustification {

	// PARAMETRES :
	// ------------
	
	static int tailleMarges = 5;
	static int tailleLigneComplete = 120;
	static int tailleLigneUtile = tailleLigneComplete - (2 * tailleMarges);
	static String texteAJustifier = "    le   petit  chat est rouge    ";

	static char[] tableauEntree;
	static int nbMots;
	static int nbLettres;
	static int nbSeparateurs;
	static int tailleSeparateur;
	static int nbEspacesComplementaires = 0;
	static char[] tableauSortie = new char[tailleLigneComplete];

	public static void main(String[] args) {
		// TRAITEMENT :
		// ------------
		
		// 1 - transformer le texte à justifier en tableau de caractères
		tableauEntree = texteAJustifier.toCharArray();

		// 2 - compter les mots
		compterMotsV2();
		System.out.println("Il y a " + nbMots + " mots");

		// 3 - compter le nombre de lettres (tout caractère différent de l'espace)
		compterLettres();
		System.out.println("il y a " + nbLettres + " lettres");
		
		// 4 - définir le nombre de séparateurs
		nbSeparateurs = nbMots - 1;
		System.out.println("il y a " + nbSeparateurs + " separateurs");

		// 5 - définir la taille du séparateur
		tailleSeparateur = (tailleLigneUtile - nbLettres) / nbSeparateurs;
		System.out.println("taille separateur :  " + tailleSeparateur);
		
		nbEspacesComplementaires = tailleLigneUtile - nbLettres - (nbSeparateurs * tailleSeparateur);
		System.out.println("nb espaces complémentaires :  " + nbEspacesComplementaires);
		
		// 6 - fabriquer le texte justifié (tableauSortie)
		
		int indexEcriture = 0;
		
		// ecrire la marge de gauche
		for(int i = 0 ; i < tailleMarges; i++)
		{
			tableauSortie[i] = '*';
			indexEcriture++;
		}		
		
		
		// écriture de la ligne utile :
		int nbMotsEcrits = 0;
		
		for (int i = 0; i < tableauEntree.length; i++)
		{
			// ecriture d'un caractère :
			if (tableauEntree[i] != ' ')
			{
				tableauSortie[indexEcriture] = tableauEntree[i];
				indexEcriture++;
			}
			// ecrire un séparateur : quand j'ai un espace qui suit une lettre et que je suis avant le dernier mot
			if (tableauEntree[i] == ' ' && i > 0 && tableauEntree[i-1] != ' ')
			{
				nbMotsEcrits++;
				// pas de séprateur après le dernier mot :
				if (nbMotsEcrits < nbMots) 
				{	
					for (int j = 0; j < tailleSeparateur; j++)
					{
						tableauSortie[indexEcriture] = ' ';
						indexEcriture++;
					}
					// affichage espaces complémentaires :
					if (nbEspacesComplementaires > 0)
					{
						tableauSortie[indexEcriture] = ' ';
						indexEcriture++;
						nbEspacesComplementaires--;
					}
					
				}
			}
		}

		// ecrire la marge de droite
		for(int i = 0 ; i < tailleMarges; i++)
		{
			tableauSortie[indexEcriture] = '*';
			indexEcriture++;
		}	
		
		// 8 - afficher le résultat (tableauSortie)
		for(int i = 0; i < tableauSortie.length; i++)
		{
			System.out.print(tableauSortie[i]);
		}
		System.out.println();

	}

	private static void compterLettres() {
		nbLettres = 0;
		
		for(int i = 0; i < tableauEntree.length; i++)
		{
			if (tableauEntree[i] != ' ')
			{
				nbLettres ++;
			}			
		}
	}

	private static void compterMotsV2() {
		
		nbMots = 0;
		
		for(int i = 0; i < tableauEntree.length; i++)
		{
			char courant = tableauEntree[i];
			
			if (courant == ' ' && i > 0 && tableauEntree[i-1] != ' ') 
			{
				nbMots++;
			}
			
			if (courant != ' ' && i == tableauEntree.length -1)
			{
				nbMots++;
			}
		}
	}
		
	private static void compterMotsV1() {

		nbMots = 0;

		// A TESTER for(int i = 1; i < tableauEntree.length; i++)
		for (int i = 0; i < tableauEntree.length; i++) {
			char courant = tableauEntree[i];

			if (courant == ' ') // le caractere courant est un espace
			{
				if (i > 0) // j'ignore le cas ou c est le premier element
				{
					char precedent = tableauEntree[i - 1];

					if (precedent != ' ') // le caractere précédent est une lettre
					{
						nbMots++;
					}
				}
			} 
			else // le caractere courant est une lettre
			{
				if (i == tableauEntree.length - 1) // le caractere courant est le dernier element
				{
					nbMots++;
				}
			}
		}

	}

}