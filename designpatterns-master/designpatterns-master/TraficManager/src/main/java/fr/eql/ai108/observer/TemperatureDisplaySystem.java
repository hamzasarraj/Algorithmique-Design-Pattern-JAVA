package fr.eql.ai108.observer;

public class TemperatureDisplaySystem implements ThermometerObserver {

	public void notifyNewTemperature(int temperature) {
		System.out.println(temperature + "°C");		
	}

	
	
}
