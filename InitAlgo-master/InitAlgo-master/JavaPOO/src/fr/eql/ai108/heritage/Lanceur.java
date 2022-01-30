package fr.eql.ai108.heritage;

public class Lanceur {

	public static void main(String[] args) {
		
		//InstrumentDeMusique tambour = new InstrumentDeMusique("Tambour", "Tama", 78.12f);
		Basse jazzbass = new Basse("Jazz Bass", "Fender", 1500f, 4, false);
		InstrumentDeMusique stingray = new Basse("Sting Ray", "Music Man",
				2000.45f, 5, true);
		Piano k500 = new Piano("K-500", "Kawai", 10909f, 88, "lourd");
		InstrumentDeMusique primus = new Piano("Primus", "Seller", 15000.45f, 
				88, "dynamique");
		
		k500.faireDeLaMusique("Moonlight Sonata");
		
		//Tous sont des instruments de musique; tous ont donc accès à la méthode
		//faire de la musique.
		System.out.print("La jazz bass fait: ");
		 jazzbass.faireDeLaMusique();
		 
		 System.out.print("Le Primus fait: ");
		 primus.faireDeLaMusique();
		 
		 //Comme tous mes objets sont des Instruments de Musique, je peux les placer
		 //dans une collection d'Instruments de Musique
		 InstrumentDeMusique[] instruments = {jazzbass, stingray, k500, primus};
		 
		 
		 for (InstrumentDeMusique instrumentDeMusique : instruments) {
			instrumentDeMusique.faireDeLaMusique();
			//instance of est un operateur de comparaison qui permet de
			//vérifier le type réel d'une classe
			if(instrumentDeMusique instanceof Piano) {
				System.out.println(instrumentDeMusique.getNom());
				//instrumentDeMusique.faireDeLaMusique("Experience");
				//Le casting
				Piano piano = (Piano)instrumentDeMusique;
				piano.faireDeLaMusique("Experience");
				
				((Piano) instrumentDeMusique).faireDeLaMusique("Experience");
			}
		}
		 
		 
		 

	}

}
