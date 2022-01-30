package fr.eql.ai108.scope;

public class TestScope {

	//Une variable ne peut pas être consommée avant sa déclaration
	//EN Java, les variables ont un scope (portée) de bloc {}.
	//Dans un contexte d'exécution, les scope enfants ont accès aux variables déclarées
	//dans leur(s) parent(s) mais les scopes parents n'ont pas accès aux scopes 
	//de leurs enfants
	public static void main(String[] args) {
		//System.out.println(dansleMain);
		int dansLeMain = 42;
		//int dansLeMain = 78;
		
		if(true) {
			int dansLeIf = 43;
			System.out.println(dansLeMain);
			System.out.println(dansLeIf);
		}
		//System.out.println(dansLeIf); Dans le main, je n'ai pas accès aux variables
		//déclarée dans le if car c'est un scope enfant
		for (int i = 0; i < 1; i++) {
			int dansLaBoucle = 44;
			System.out.println(dansLeMain);
			System.out.println(dansLaBoucle);
			//System.out.println(dansLeIf);
			
			if(true) {
				int dansLeIfDansLaBoucle = 45;
				System.out.println(dansLeMain);
				System.out.println(dansLaBoucle);
				System.out.println(dansLeIfDansLaBoucle);
			}
		}
		//System.out.println(dansLeIfDansLaBoucle);
		int dansLeIfDansLaBoucle = 789;
	}

}
