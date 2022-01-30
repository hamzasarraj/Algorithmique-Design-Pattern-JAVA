
public class RechercheV1 {

	public static void main(String[] args) {
		String[] noms = { "Alice", "Bob", "Carole", "Denis", "Emily", "Fabrice", "Gerard", "Henry" };
		
		String valeurRechechee = "Emily";
		
		int i = 0;
		int nbElements = noms.length;
		
		
		while(i < nbElements && noms[i] != valeurRechechee) 
		{
			i++;
		} 
		// si je vais jusqu'au bout du tableau, alors i vaut 6 (pas trouvé)
		// sinon est inférieur à 6 (trouvé)
		
		if (i == nbElements)
		{
			System.out.println("pas touvé :/");
		}
		else
		{
			System.out.println("trouvé à la position " + i);
		}

	}

}
