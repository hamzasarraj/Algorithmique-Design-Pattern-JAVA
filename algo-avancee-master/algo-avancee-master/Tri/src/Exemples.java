import java.io.StreamCorruptedException;

public class Exemples {

	public static void main(String[] args) {
		
		int[] tableau = {5,7,2,9,4,3,1,8,6};
		
		//corrigeTriSelection(tableau);
		triSelectionRecursif(tableau, tableau.length);
		//triABulle(tableau, tableau.length);
		//triInsertion(tableau);
		
		for (int i = 0; i < tableau.length; i++) {
			System.out.println(tableau[i]);
		}
		
	}
	
	public static void permuter(int[] tableau, int m, int n)
	{
		int buffer = tableau[m];
		tableau[m] = tableau[n];
		tableau[n] = buffer;
	}
	
	public static void corrigeTriSelection(int[] tableau)
	{
		//x x x x x o x x x x x n
		//x x x o x x x x x x n -
		//x x x o x x x x x n - -
		//x x x o x x x x n - - -
		//x x x o x x x n - - - -
		//x x x o x x n - - - - -
		
		for (int n = tableau.length; n > 1; n--)
		{
			int indexPlusGrand = 0;
			
			for (int i = 1; i < n; i++) 
			{
				if (tableau[i] > tableau[indexPlusGrand])
				{
					indexPlusGrand = i;
				}
			}
			
			permuter(tableau, indexPlusGrand, n-1);
		}
	}
		
		
	public static void triSelectionRecursif(int[] tableau, int n)
	{
		if (n > 1)
		{
			int indexPlusGrand = 0;
			
			for (int i = 1; i < n; i++) 
			{
				if (tableau[i] > tableau[indexPlusGrand])
				{
					indexPlusGrand = i;
				}
			}
			
			permuter(tableau, indexPlusGrand, n-1);
			
			triSelectionRecursif(tableau, n-1);
		}
	}
	
	
}
