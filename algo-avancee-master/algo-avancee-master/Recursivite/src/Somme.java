
public class Somme {

	public static void main(String[] args)
	{
		int[] tab = {100,100,100,100}; 
		System.out.println("" + somme(tab.length - 1, tab));	
	}
	
	
	public static int somme(int niveau, int[] valeurs)
	{
		if(niveau > 0)
		{
			return valeurs[niveau] + somme(niveau-1, valeurs);
		}
		else
		{
			return valeurs[niveau];
		}
	}
}
