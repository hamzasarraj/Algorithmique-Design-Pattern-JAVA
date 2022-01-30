package fr.eql.ai108.observer;

import java.util.ArrayList;
import java.util.List;

public class Thermometer {

	private List<ThermometerObserver> observers = new ArrayList<ThermometerObserver>();
	
	public void subscribe(ThermometerObserver observer)
	{
		observers.add(observer);
	}
	
	public void unsubscribe(ThermometerObserver observer)
	{
		observers.remove(observer);
	}
	
	private int temperature;
	
	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		// la température change :
		this.temperature = temperature;
		// je notifie mes observers :
		for(ThermometerObserver observer : observers) {
			observer.notifyNewTemperature(this.temperature);
		}
	}
	
	
}
