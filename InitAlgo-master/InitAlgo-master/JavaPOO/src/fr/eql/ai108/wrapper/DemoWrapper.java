package fr.eql.ai108.wrapper;

public class DemoWrapper {

	public static void main(String[] args) {
		/*Les wrapper ou classe enveloppes permettebnt d'encapsuler des types primitifs.
		Chaque type primitif possède sa classe enveloppe qui lui permet de se comporter
	comme un objet:
		Boolean: pour le type booleen (16bits)
		Integer: pour le type int (16bits)
		Byte: pour le type byte (16bits)
		Short: pour le type short(16bits) 
		Long: pour le type long (24 bits)
		Float: pour le type float (16bits)
		Double: pour le type double (24 bits)
		Character: pour le type char (16bits)
		
	*/
		
		//Les wrappers sont nullables
		//int i = null;
		Integer unInteger = null;
		
		//Un wrapper peut être instancié
		Integer unAutreInteger = new Integer(42);
		System.out.println(unAutreInteger);
		
		//Pour simplifier leur écriture, l'instanciation n'est pas nécessaire
		//C'est ce que l'on appelle l'auto-boxing:
		Float f = 3.45f;
		
		//Chaque wrapper (sauf Character) possède une méthode parseXXX(String str) qui permet
		//de renvoyer un type primitif à partir d'une chaine de caractère
		double d = Double.parseDouble("42.2222");
		
		//Chaque wrapper (sauf CHaracter) possède une méthode valueOf(String str) 
		//qui permet cette fois de renvoyer un type objet à partir d'une chaîne de caractères
		
		Boolean bool = Boolean.valueOf("true");
		Integer integerWrapper = Integer.valueOf("42");
		int integer = Integer.valueOf("42");
		int integer2 = Integer.parseInt("42");

	}

}
