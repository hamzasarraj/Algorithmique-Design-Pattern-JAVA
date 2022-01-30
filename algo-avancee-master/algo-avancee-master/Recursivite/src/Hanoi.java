
public class Hanoi {

	static int nbPermutations = 0;
	
	public static void main(String[] args) {

		int taille = 5;
		int[] colA = new int[taille];
		int[] colB = new int[taille];
		int[] colC = new int[taille];

		for (int i = 1; i <= taille; i++) {
			empiler(i, colA);
			empiler(0, colB);
			empiler(0, colC);
		}
		
		//dessiner(colA);
		//dessiner(colC);
		//dessiner(colB);
		
		hanoi(taille, colA, colB, colC);

		dessiner(colA);
		dessiner(colC);
		dessiner(colB);

		System.out.println(nbPermutations + " permutations");
	
	}

	public static void hanoi(int nbDisques, int[] origine, int[] destination, int[] intermediaire) {
		if (nbDisques > 0) 
		{
			nbPermutations++;
			
			// Déplacer (n-1) disques de orig vers inter en passant par dest
			hanoi(nbDisques - 1, origine, intermediaire, destination);

			// Déplacer 1 disque de orig vers destination
			int disque = depiler(origine);
			empiler(disque, destination);

			// Déplacer (n-1) disques de inter vers dest en passant par orig
			hanoi(nbDisques - 1,  intermediaire, destination, origine);
		}
	}

	public static void dessiner(int[] tableau) 
	{
		for (int i = 0; i < tableau.length; i++) 
		{
			if (tableau[i] > 0)
			{
				for (int j = 0; j <= i; j++) 
				{
					System.out.print("*");
				}
				System.out.println("");
			}			
		}
		System.out.println("-------");
	}

	public static void empiler(int valeur, int[] destination) {
		for (int i = 0; i < destination.length; i++) {
			if (destination[i] == 0) {
				destination[i] = valeur;
				break;
			}
		}
	}

	public static int depiler(int[] destination) {
		for (int i = destination.length - 1; i >= 0; i--) 
		{
			if (destination[i] > 0) 
			{
				
				int resultat = destination[i];
				destination[i] = 0;
				return resultat;
			}
		}
		return 0;
	}

}
