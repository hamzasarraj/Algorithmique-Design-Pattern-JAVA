package fr.eql.initalgo.demo;

public class DemoOperateurs {

	public static void main(String[] args) {
		
		int nb1, nb2, nb3;
		
		//addition
		nb1 = 1 + 3;
		System.out.println(nb1);
		
		//multiplication
		nb2 = 2 * 6;
		System.out.println(nb2);
		
		//division
		nb3 = 5/2;
		System.out.println(nb3);
		
		float nb4 = 5f;
		float nb5 = 2f;
		float resultat = nb4 /nb5;
		System.out.println(resultat);
		
		//soustraction
		nb1 = 44 - 2;
		System.out.println(nb1);
		
		//modulo
		nb1 = 5 % 2;
		nb1 = 6 % 3;
		System.out.println(nb1);
		
		//Incrément
		int nb6 = 1;
		nb6 = nb6 + 1;
		nb6 += 1;
		nb6++;
		nb6--;
		System.out.println(nb6);

	}

}
