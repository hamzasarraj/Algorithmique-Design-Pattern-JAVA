package fr.eql.ai108.observer;

public class App {

	public static void main(String[] args) {
		
		Thermometer thermometer = new Thermometer();
		
		TemperatureDisplaySystem tds = new TemperatureDisplaySystem();
		
		thermometer.subscribe(tds);
		
		thermometer.setTemperature(25);
		
		thermometer.setTemperature(25);
		thermometer.setTemperature(26);
		thermometer.setTemperature(23);
		thermometer.setTemperature(38);
		thermometer.setTemperature(12);
		
		
		
	}
	
}
