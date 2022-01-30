package fr.eql.ai108.traficmanager;

public class TraficManager {

	private TraficFactory factory;
	
	public TraficManager(TraficFactory factory) {
		this.factory = factory;
	}
	
	public void gererTrafic(int nbVehicules)
	{
		// créer un garage
		Garage g = factory.createGarage();	
		
		// ajouter nb vehicules au garage
		for (int i = 0; i < nbVehicules; i++) {
			Vehicule v = factory.createVehicule();
			g.ajouter(v);
		}		
		
		System.out.println(g.decrire());		
	}
	
}
