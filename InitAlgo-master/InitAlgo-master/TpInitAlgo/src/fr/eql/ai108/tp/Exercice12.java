package fr.eql.ai108.tp;

public class Exercice12
{
	public static void main(String[] args) {
		int dimension = 20;
		long[][] triangle = new long[dimension][];

		// REMPLISSAGE :

		for (int x = 0; x < dimension; x++) {
			// création de niveau 2 de la ligne courante :
			triangle[x] = new long[(x/2)+1];

			// remplissage de chaque case :
			for(int y = 0; y < (x/2)+1; y++) {
				// cases de droite
				if (y > 0) {
					if (x%2 == 0 && y == x/2) {
						triangle[x][y] = triangle[x-1][y-1] * 2;

					}
					else {
						triangle[x][y] = triangle[x-1][y-1] 
								+ 
								triangle[x-1][y];						
					}
				}
				// première case :
				else {
					triangle[x][y] = 1;
				}
			}

		}
		// AFFICHAGE :

		// déterminer le nombre de caractères de chaque case 
		// (nombre de chiffres de la plus grande valeur) :
		long plusGrandeValeur = triangle[dimension - 1][(dimension-1)/2];
		String txtPGV = "" + plusGrandeValeur;
		int tailleCase = txtPGV.length();

		for (int x = 0; x < dimension; x++){
			// affichage des cases vides (à gauche)
			int nbCasesVides = dimension - x - 1;

			for (int i = 0; i < tailleCase * nbCasesVides; i++){
				System.out.print(" ");
			}

			// partie gauche du "mirroir" :
			for(int y = 0; y < (x/2)+1; y++){
				// déterminer le nombre d'espaces � afficher :
				// (ex : ---1 si plus grande valeur = 1564)

				// calculer taille du nombre à afficher :
				String s = "" + triangle[x][y];

				int nbEspaces = tailleCase - s.length();

				// 1 - affichage des espaces (complement chiffre) :
				for (int i = 0; i < nbEspaces; i++){
					System.out.print(" ");
				}

				// 2 - affichage du nombre :
				System.out.print(triangle[x][y]);

				// 3 - affichage d'une case vide :
				for (int i=0; i<tailleCase; i++){
					System.out.print(" ");
				}
			}


			// partie droite du "mirroir" :
			for (int y = (x-1)/2; y >= 0 && x > 0; y--){
				// déterminer le nombre d'espaces à afficher :
				// (ex : ---1 si plus grande valeur = 1564)

				// calculer taille du nombre à afficher :
				String s = "" + triangle[x][y];

				int nbEspaces = tailleCase - s.length();

				// 1 - affichage des espaces (complement chiffre) :
				for (int i = 0; i < nbEspaces; i++){
					System.out.print(" ");
				}

				// 2 - affichage du nombre :
				System.out.print(triangle[x][y]);

				// 3 - affichage d'une case vide :
				for (int i=0; i<tailleCase; i++){
					System.out.print(" ");
				}

			}

			System.out.println();
		}

	}	
}
