package fr.eql.ai108.traficmanager;

import java.util.ArrayList;
import java.util.List;

public abstract class Garage {

	protected List<Vehicule> vehicules = new ArrayList<Vehicule>();
	
	public void ajouter(Vehicule v) {
		vehicules.add(v);
	}
	
	public String decrire() {
		return "je contiens " + vehicules.size();
	}
}
