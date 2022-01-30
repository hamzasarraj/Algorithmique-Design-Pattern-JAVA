package fr.eql.ai108.real.poo.tp;

public class Lanceur {

	public static void main(String[] args) {
		
		Serie got = new Serie("Game of thrones", "A Westeros bla bla bla bla...", 8);
		Serie tqg = new Serie("The Queen's Gambit", "Ça parle d'échec", 1);
		got.presenterSerie();
		tqg.presenterSerie();
		String[] lesPersonnages = {"Oberyn Martell", "Jon Snow", "Arya Stark"};
		got.setPersonnages(lesPersonnages);
		String initiales = got.obtenirInitialesPersonnages();
		System.out.println(initiales);

	}

}
