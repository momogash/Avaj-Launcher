package Aircraft;

import java.util.HashMap;

import Weather.*;

public class JetPlane extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	
	JetPlane(String name, Coordinates coordinates){
		super(name,coordinates);
	}
	
	public void updateConditions() {
	
			String weather = this.weatherTower.getWeather(coordinates);
			
			HashMap<String, String> JetPlane = new HashMap<String, String>();
			JetPlane.put("SUN", "Great sunny day to be over the clouds");
			JetPlane.put("FOG", "Not a great day to fly, low visibility due to fog");
			JetPlane.put("RAIN", "Some rain from the sky....");
			JetPlane.put("SNOW", "Snowy day, great for christmas but not for flying");
			
			String Identity = "JetPlane#" + super.name + "("+this.id +"): ";
			
			switch(weather) {
			case "SUN":
				super.coordinates.setLatitude(super.coordinates.getLatitude() + 10);
				super.coordinates.setHeight(super.coordinates.getHeight() + 2);
				WriteToFile.createFile().writeToFile(Identity + JetPlane.get("SUN"));
				break;
				
			case "RAIN":
				super.coordinates.setLatitude(super.coordinates.getLatitude() + 5);
				WriteToFile.createFile().writeToFile(Identity + JetPlane.get("RAIN"));
				break;
				
			case "FOG":
				super.coordinates.setLatitude(super.coordinates.getLatitude() + 1);
				WriteToFile.createFile().writeToFile(Identity + JetPlane.get("FOG"));
				break;
				
			case "SNOW":
				super.coordinates.setHeight(super.coordinates.getHeight() - 7);
				WriteToFile.createFile().writeToFile(Identity + JetPlane.get("SNOW"));
				break;
				
			}
	}

	public void registerTower(WeatherTower weatherTower) {
		 weatherTower.register(this);
		 this.weatherTower = weatherTower;
		 WriteToFile.createFile().writeToFile("Message from Tower: JetPlane#" + super.name + "("+ super.id +") has been registered to fly!");
	        

		
	}

}

