package fr.eql.ai108.flightsimulator;

import fr.eql.ai108.traficmanager.Garage;

public class Hangar extends Garage {

	@Override
	public String decrire() {
		return "Je suis un hangar, " + super.decrire() + " avions";
	}
	
}
