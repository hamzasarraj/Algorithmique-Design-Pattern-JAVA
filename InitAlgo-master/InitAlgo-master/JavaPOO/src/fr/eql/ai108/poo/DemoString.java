package fr.eql.ai108.poo;

public class DemoString {

	public static void main(String[] args) {
		
		String uneString = "Une chaine de caractères est un objet; elle possède "
				+ "donc des méthodes d'instances";
		String uneStringVide = "";
		
		//Une méthode pour obtenir sa taille:
		System.out.println(uneString.length());
		
		//Une méthode pour vérifier si la chaine est vide ou pas:
		System.out.println(uneString.isEmpty());
		System.out.println(uneStringVide.isEmpty());
		
		//Une méthode de comparaison
		System.out.println(uneString.equals(uneStringVide));
		
		//Une méthode pour découper la chaine:
		System.out.println(uneString.substring(4));
		System.out.println(uneString.substring(9, 18));
		
		//Des méthodes qui changent la casse de ma chaine:
		System.out.println(uneString.toLowerCase());
		System.out.println(uneString.toUpperCase());
		
		//Une méthode pour enlever les espaces avant et après ma chaine
		String derniereString = "         blablablablablabla     ";
		System.out.println(derniereString.length());
		String trimedString = derniereString.trim();
		System.out.println(trimedString.length());
		
		//Une méthode split qui permet de découper une chaine de caractère
		//en fonction d'un séparateur
		String[] split = uneString.split(";");
		System.out.println(split[0]);
		System.out.println(split[1]);
		
		//Replace permet de remplacer une partie d'une chaine
		// de caractères par une autre chaine.
		String romain = uneString.replace("objet", "toto");
		System.out.println(romain);

	}

}
