
public class Exemples {

	
	public static void main(String[] args)
	{
		// méthode récursuve : méthode qui s'appelle elle-même
		
		afficherR("a", 100);
		
		
	}
	
	public static void afficher(String lettre, int quantite)
	{
		for (int i = 0; i < quantite; i++) 
		{
			System.out.print(lettre);
		}
	}
	
	// afficher n fois une lettre
	public static void afficherR(String lettre, int n)
	{
		System.out.print(lettre);
		if( n > 1)
		{
			afficherR(lettre, n-1);
		}
	}
	
	/*
	aff(100)
	 aff(99)
	  aff(98)
	    aff(97)
	      ...
	*/
	
}
