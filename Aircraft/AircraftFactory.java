package Aircraft;

public abstract class AircraftFactory {
	
	//in here we create all the different flight times with their specific names and coordinates as received from the scenario file
	
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude,latitude,height);
		
		if(type.equals("Helicopter"))
			return new Helicopter(name,coordinates);
		else if(type.equals("JetPlane"))
			return new JetPlane(name,coordinates);
		else if(type.equals("Baloon"))
			return new Baloon(name,coordinates);
		
		return null;
		
		
	}

}
