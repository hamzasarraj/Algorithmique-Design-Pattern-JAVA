
public class RechercheDichotomique {

	public static void main(String[] args) {

		// initialisation :
		
		String[] noms = {"Azkaban", "Bobba", "Edwige", "Ermione", "Fili", "Frodon", "Gandalf", "Gimli", "Golum", "Han solo", "Mithrandir"};
		String recherche = "Han solo";
		
		int debut = 0;
		int fin = noms.length;	
		boolean trouve = false; // flag 
		boolean rechercheTerminee = false; // flag
		
		
		// traitement :
		do
		{
			System.out.print("portion de " + debut + " à " + fin + " : ");
			int milieu = (debut + fin) / 2;
			
			if (recherche.equals(noms[milieu]))
			{
				System.out.println("Touvé !!! indice : " + milieu);
				trouve = true;
			}
			
			if (noms[milieu].compareTo(recherche) < 0)
			{
				System.out.println(" plus grand que " + noms[milieu]);
				debut = milieu + 1;
			}
			
			if (noms[milieu].compareTo(recherche) > 0)
			{
				System.out.println(" plus petit que " + noms[milieu]);
				fin = milieu;
			}
			
			if (fin == -1 || debut == noms.length || debut == fin)
			{
				rechercheTerminee = true;
			}
		}
		while(!trouve && !rechercheTerminee);
		
		if (!trouve)
		{
			System.out.println("Elément non trouvé...");
		}
		
		
		
		
	}

}
