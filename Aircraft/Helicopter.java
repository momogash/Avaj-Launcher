package Aircraft;

import java.util.HashMap;

import Weather.*;

public class Helicopter extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates){
		super(name,coordinates);
	}
	
	public void updateConditions() {
	
			String weather = this.weatherTower.getWeather(coordinates);
			
			HashMap<String, String> Helicopter = new HashMap<String, String>();
			Helicopter.put("SUN", "Great sunny day to be over the clouds");
			Helicopter.put("FOG", "Not a great day to fly, low visibility due to fog");
			Helicopter.put("RAIN", "Some rain from the sky....");
			Helicopter.put("SNOW", "Snowy day, great for christmas but not for flying");
			
			String Identity = "Helicopter#" + super.name + "("+this.id +"): ";
			
			switch(weather) {
			case "SUN":
				super.coordinates.setLatitude(super.coordinates.getLatitude()+ 10);
				super.coordinates.setHeight(super.coordinates.getHeight() + 2);
				WriteToFile.createFile().writeToFile(Identity + Helicopter.get("SUN"));
				break;
				
			case "RAIN":
				super.coordinates.setLongitude(super.coordinates.getLongitude() + 5);
				WriteToFile.createFile().writeToFile(Identity + Helicopter.get("RAIN"));
				break;
				
			case "FOG":
				super.coordinates.setLongitude(super.coordinates.getLongitude() + 1);
				WriteToFile.createFile().writeToFile(Identity + Helicopter.get("FOG"));
				break;
				
			case "SNOW":
				super.coordinates.setHeight(super.coordinates.getHeight() - 12);
				WriteToFile.createFile().writeToFile(Identity + Helicopter.get("SNOW"));
				break;
				
			}
			
		
		
		
	}

	public void registerTower(WeatherTower weatherTower) {
		 weatherTower.register(this);
		 this.weatherTower = weatherTower;
		 WriteToFile.createFile().writeToFile("Message from Tower: Helicopter#" + super.name + "("+ super.id +") has been registered to fly!");
	        

		
	}

}
