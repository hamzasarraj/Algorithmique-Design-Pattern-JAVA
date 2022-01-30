package calculette;

import java.util.Scanner;

public class HP {

	static double[] pile = new double[1024];
	static int taillePile = 0;
	
	public static void main(String[] args)
	{
		//initialiser(pile);

		Scanner s = new Scanner(System.in);
		
		do{
			
			System.out.println("Saisir une valeur : ");
			String saisie = s.nextLine();
			
			switch (saisie) 
			{
				case "+":
					operation("+");
					break;
				case "-":
					operation("-");
					break;
				case "*":
				case "x":
				case "X":	
					operation("*");
					break;
				case "/":
					operation("/");
					break;
				case "clear":
				case "c" :
					// vider la pile
					taillePile = 0;
					break;
				case "drop":
				case "d" :
					// effacer le dernier operande
					pop();
					break;
				case "swap":
				case "s" :
					// inverser les deux derniers opérandes :
					double a = pop();
					double b = pop();
					push(a);
					push(b);
					break;
				case "q":
				case "Q":	
					System.out.println("bye...");
					return;
				default:
					try
					{
						double valeur = Double.parseDouble(saisie);
						push(valeur);
					}
					catch(Exception e)
					{
						System.out.println("valeur incorrecte");
					}
					break;
			}
			
			System.out.print("PILE : ");
			afficher(pile);
			
			
		}while(true);
		
	}

	public static void operation(String operateur)
	{
		if (taillePile > 1)
		{
			double b = pop(); 
			double a = pop();
			
			double resultat = 0;
			
			switch(operateur)
			{
				case "+" :
					resultat = a+b;
					break;
				case "-" :
					resultat = a-b;
					break;
				case "*" :
					resultat = a*b;
					break;
				case "/" :
					resultat = a/b;
					break;
			}
			
			System.out.println(a + operateur + b + " = " + resultat);
			
			push(resultat);
		}
		else
		{
			System.out.println("il n'y a pas assez d'opérandes dans la pile");
		}
	}
	
	/*
	 * //AVANT FACTORISATION
	public static void additionner(double[] pile)
	{
		double b = pop(pile); 
		double a = pop(pile); 
		
		double resultat = a+b; // spé
		System.out.println(a + " + " + b + " = " + resultat);
		push(resultat, pile);
	}
	
	public static void soustraire(double[] pile)
	{
		double a = pop(pile);
		double b = pop(pile);
		
		double resultat = a-b;
		System.out.println( a + " - " + b + " = " + resultat);
		push(resultat, pile);
	}
	
	public static void diviser(double[] pile)
	{
		double b = pop(pile); // 40
		double a = pop(pile); // 30
		
		double resultat = a/b; 
		System.out.println( a + " / " + b + " = " + resultat);
		push(resultat, pile);
	}
	
	public static void multiplier(double[] pile)
	{
		double a = pop(pile);
		double b = pop(pile);
		
		double resultat = a*b;
		System.out.println( a + " * " + b + " = " + resultat);
		push(resultat, pile);
	}
	*/
	
	public static void afficher(double[] tableau)
	{
		for (int i = 0; i < taillePile; i++) {
			System.out.print(tableau[i] + "  ");
		}
		System.out.println();
	}
	
	public static void initialiser (double[] tableau)
	{
		for (int i = 0; i < tableau.length; i++) {
			tableau[i] = Double.MIN_VALUE;
		}
	}
	
	public static void push(double valeur)
	{
		pile[taillePile] = valeur;
		taillePile++;
//		for (int i = 0; i < pile.length; i++) {
//			// case vide, j'insere
//			if (pile[i] == Double.MIN_VALUE)
//			{
//				pile[i] = valeur;
//				return;
//			}
//		}
	}
	
	public static double pop()
	{
		taillePile--;
		return pile[taillePile];
		
//		for (int i = pile.length - 1; i >= 0; i--) {
//			// case non vide, je dépile :
//			if (pile[i] != Double.MIN_VALUE)
//			{
//				double resultat = pile[i];
//				pile[i] = Double.MIN_VALUE; // je vide la case
//				return resultat;
//			}
//		}
		
//		return Double.MIN_VALUE; // pas trouvé : retour 
	}
	
	public static void queue(double d, double[] tableau)
	{
		
	}
	
	public double dequeue(double[] tableau)
	{
		return 0;
	}

}
