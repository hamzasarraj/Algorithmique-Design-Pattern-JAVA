
public class QuickSort {

	public static void main(String[] args) {
		
		int[] tab = {5,7,1,3,4,98,6,47,3,184,6,684,378,152,4,4,2,75,8};
		//int[] tab2 = {5,7,1,3,4,98,6,47,3,184,6,684,378,152,4,4,2,75,8};
		
		//System.out.println(tab == tab2);
		
		triRapide(tab, 0, tab.length - 1);
		
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}

	}
	
	
	public static void triRapide(int[] tab, int debut, int fin)
	{
		if (debut < fin)
		{
			int position = partition(tab, debut, fin);
			triRapide(tab, debut, position - 1);
			triRapide(tab, position + 1,  fin);
		}
	}
	
	public static int partition(int[] tab, int debut, int fin)
	{	
		int position = debut;
		int pivot = tab[debut];
		
		for (int i = debut + 1; i <= fin; i++)
		{
			if (tab[i]<pivot)
			{
				position++;
				echanger(tab, position, i);
			}
		}
		echanger(tab, debut, position);
		return position;	
	}
	
	public static void echanger(int[] tab, int m, int n)
	{
		int buf = tab[m];
		tab[m] = tab[n];
		tab[n] = buf;
	}

}
