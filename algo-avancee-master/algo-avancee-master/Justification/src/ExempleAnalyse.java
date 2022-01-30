import java.util.EnumSet;
import java.util.Scanner;

public class ExempleAnalyse {

	static String nomJoueur;
	int scoreOrdi = 0;
	int scoreJoueur = 0;
	
	enum Couleur
	{
		bleu,
		rouge,
		vert
	}
	
	public static void main(String[] args) {

		for(Couleur c : EnumSet.allOf(Couleur.class))
		{
			System.out.println(c);
			
		}

		
		nomJoueur = identifierJoueur();

		do {

			jouerUnTour();

		} while (true);

	}

	public static void jouerUnTour() {
		
		int choixOrdi = determinerChoixOrdi();

		int choixJoueur = determinerChoixJoueur();

		int resultat = comparerChoix(choixOrdi, choixJoueur);

		// mettre � jour le score
		// ...
	}

	private static int comparerChoix(int choixOrdi, int choixJoueur) {
		// -1 ordi, 0: egalite, 1 : joueur

		return 0;
	}

	private static int determinerChoixJoueur() {
		// 2.2.1 - demander choix

		// 2.2.2 - r�cup�rer valeur

		// 2.2.3 - v�rifier valeur
		return 0;
	}

	private static int determinerChoixOrdi() {
		// g�n�rer une valeur al�atoire entre 1 et 3
		return 0;
	}

	public static String identifierJoueur() {
		System.out.println("votre nom : ");
		Scanner s = new Scanner(System.in);
		String nom = s.nextLine();
		return nom;
	}

}
