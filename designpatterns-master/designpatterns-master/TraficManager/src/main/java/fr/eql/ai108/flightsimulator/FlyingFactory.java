package fr.eql.ai108.flightsimulator;

import fr.eql.ai108.traficmanager.Garage;
import fr.eql.ai108.traficmanager.TraficFactory;
import fr.eql.ai108.traficmanager.Vehicule;

public class FlyingFactory implements TraficFactory {

	public Vehicule createVehicule() {
		return new Avion();
	}

	public Garage createGarage() {
		return new Hangar();
	}

		
}
