import fr.eql.ai108.flightsimulator.FlyingFactory;
import fr.eql.ai108.skywars.SpaceFactory;
import fr.eql.ai108.traficmanager.TraficManager;

public class App {

	public static void main(String[] args) {
		
		
		TraficManager tm = new TraficManager(new SpaceFactory());
		
		tm.gererTrafic(7);
		
	}
	
}
