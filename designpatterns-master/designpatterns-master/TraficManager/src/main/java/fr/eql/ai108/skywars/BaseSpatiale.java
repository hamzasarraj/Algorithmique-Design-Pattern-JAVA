package fr.eql.ai108.skywars;

import fr.eql.ai108.traficmanager.Garage;
import fr.eql.ai108.traficmanager.Vehicule;

public class BaseSpatiale extends Garage {

	@Override
	public String decrire() {
		return "Je suis une base spatiale, " + super.decrire() + " vaisseaux";
	}
	
	@Override
	public void ajouter(Vehicule v) {
		if (vehicules.size() > 5)
		{
			System.out.println("Alert ! Collision détectée ");
		}
		else
		{
			super.ajouter(v);
		}
	}
	
}
