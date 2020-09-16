package Aircraft;

public abstract class AircraftFactory {
	
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude,latitude,height);
		
		if(type.equals("Helicopter"))
			return new Helicopter(name,coordinates);
		else if(type.equals("Jetplane"))
			return new Jetplane(name,coordinates);
		else if(type.equals("Baloon"))
			return new Baloon(name,coordinates);
		
		else return null;
		
		
	}

}
