
public class Factorielle {

	public static void main(String[] args) {
	
		System.out.println(factorielleR(10));
	
	}
	
	public static int factorielle(int n)
	{
		int resultat = 1;
		for(int i = n; i > 1; i--)
		{
			resultat = resultat * i;
		}
		return resultat;
	}
	
	public static int factorielleR(int n)
	{
		if (n>1)
		{
			return n * factorielleR(n-1);
		}
		else
		{
			return 1;
		}
	}
	

}
