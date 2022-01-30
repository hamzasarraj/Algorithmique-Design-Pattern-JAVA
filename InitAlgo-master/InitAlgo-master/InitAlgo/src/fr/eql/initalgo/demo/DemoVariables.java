package fr.eql.initalgo.demo;

public class DemoVariables {

	public static void main(String[] args) {
		//LES NOMBRES
		
		//byte: entier court codé sur un octet (-128 à +127)
		byte temperature;
		temperature = 42;
		System.out.println(temperature);
		temperature = 36;
		System.out.println(temperature);
		//Cette grandeur est trop élevée pour un byte
		//temperature = 7889465456186415641561;
		
		//short: entier court stocké sur 2 octets (-32768 à +32767)
		//On peut déclarer une variable et lui affecter une valeur
		//en meme temps
		short vitesse = 32000;
		System.out.println(vitesse);
		
		//int: entier codé sur 4 octets (-2*10^9 à 2*10^9)
		int distance = 420000000;
		System.out.println(distance);
		distance = 0b111;
		System.out.println(distance);
		distance = 0xFF;
		System.out.println(distance);
		
		//long: entier long codé sur 8 octets (-9*10^18 à +9*10^18)
		//Un long doit être suffixé par un L.
		long anneeLumiere = 9460700000000000L;
		System.out.println(anneeLumiere);
		
		//float: nombre à virgule flottante codé sur 4 octets
		//Un float doit être suffixé par un f.
		float pi = 3.141592653F;
		System.out.println(pi);
		
		//double: nombre à virgule flottante codé sur 8 octets
		//Un double doit être suffixé par un d
		double grosFloat = 0.333333333333333333333333333334d;
		System.out.println(grosFloat);
		
		//LES BOOLEENS
		
		//Un booleen est stocké sur 1 octet.
		boolean unBooleen = true;
		System.out.println(unBooleen);
		unBooleen = false;
		System.out.println(unBooleen);
		
		//Les caractères et chaines de caractères
		
		//char s'écrit par convention entre '' et est stocké
		//sur 2 octets
		char caractere = 'a';
		System.out.println(caractere);
	
		//Chaine de caractère
		
		//Première façon de déclarer une chaîne de caractère
		String phrase;
		phrase = "Une chaîne de caractère";
		System.out.println(phrase);
		System.out.println(phrase.charAt(4));
		
		//Deuxième façon de déclarer une chaine de caractère
		//On instancie une String
		String phrase2 = new String();
		phrase2 = "Une autre chaîne de caractère";
		System.out.println(phrase2);
		
		String phrase3 = 
				new String("Encore une chaine de caractère");
		System.out.println(phrase3);
		
		//Concaténation des chaînes de caractères
		String concat = phrase + " " + phrase2 + " " + phrase3;
		System.out.println(concat);
		
	}

}
