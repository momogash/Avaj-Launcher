package Aircraft;

import Weather.*;

public class Helicopter extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates){
		super(name,coordinates);
	}
	
	public void updateConditions() {
		
	}

}
