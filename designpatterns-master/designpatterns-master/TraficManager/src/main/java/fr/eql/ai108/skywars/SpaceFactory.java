package fr.eql.ai108.skywars;

import fr.eql.ai108.traficmanager.Garage;
import fr.eql.ai108.traficmanager.TraficFactory;
import fr.eql.ai108.traficmanager.Vehicule;

public class SpaceFactory implements TraficFactory {

	public Vehicule createVehicule() {
		return new Vaisseau();
	}

	public Garage createGarage() {
		return new BaseSpatiale();
	}

		
}
