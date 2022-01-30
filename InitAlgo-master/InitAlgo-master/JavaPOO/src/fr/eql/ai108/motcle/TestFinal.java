package fr.eql.ai108.motcle;

import fr.eql.ai108.valref.Personne;

public class TestFinal {

	public static void main(String[] args) {
		//Le mot final permet de déclarer des valeurs constantes;
		//qui ne peuvent être modifiées
		//Cependant, il se comporte un peu differemment pour les primitifs et les objets.
		
		//Par convention, on écrit les constants en UPPER_CASE
		final float PI = 3.141592f;
		//Pour un primitif, je ne peux pas changer la valeur d'une variable final
		//Une fois qu'une valeur lui ait été assignée.
		//PI = 42;
		
		//Je peux modifier la valeur des attributs d'un objet final
		final Personne OBERYN = new Personne("Martell", "Oberyn", 39);
		OBERYN.setAge(40);
		
		//Je ne peux pas assigner un nouvel objet à la réfence déclarée final
		//OBERYN = new Personne("de Toto", "Toto", 42);

	}

}
