package Aircraft;

import java.util.HashMap;

import Weather.*;

public class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates){
		super(name,coordinates);
	}
	
	public void updateConditions() {
	
			String weather = this.weatherTower.getWeather(coordinates);
			
			HashMap<String, String> Baloon = new HashMap<String, String>();
			Baloon.put("SUN", "Great sunny day to be over the clouds");
			Baloon.put("FOG", "Not a great day to fly, low visibility due to fog");
			Baloon.put("RAIN", "Some rain from the sky....");
			Baloon.put("SNOW", "Snowy day, great for christmas but not for flying");
			
			String Identity = "Baloon " + super.name + "("+this.id +"): ";
			
			switch(weather) {
			case "SUN":
				super.coordinates.setLongitude(super.coordinates.getLongitude()+ 2);
				super.coordinates.setHeight(super.coordinates.getHeight() + 4);
				WriteToFile.createFile().writeToFile(Identity + Baloon.get("SUN"));
				break;
				
			case "RAIN":
				super.coordinates.setHeight(super.coordinates.getHeight() - 5);
				WriteToFile.createFile().writeToFile(Identity + Baloon.get("RAIN"));
				break;
				
			case "FOG":
				super.coordinates.setHeight(super.coordinates.getHeight() - 3);
				WriteToFile.createFile().writeToFile(Identity + Baloon.get("FOG"));
				break;
				
			case "SNOW":
				super.coordinates.setHeight(super.coordinates.getHeight() - 15);
				WriteToFile.createFile().writeToFile(Identity + Baloon.get("SNOW"));
				break;
				
			}
	}

	public void registerTower(WeatherTower weatherTower) {
		 weatherTower.register(this);
		 this.weatherTower = weatherTower;
		 this.weatherTower = weatherTower;
		 WriteToFile.createFile().writeToFile("Message from Tower: Baloon " + super.name + "("+ super.id +") has been registered to fly!");
	        

		
	}

}

