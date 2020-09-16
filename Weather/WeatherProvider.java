package Weather;

import java.util.Random;

import Aircraft.Coordinates;

public class WeatherProvider {
	
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN","FOG","SUN","SNOW"};
	
	public WeatherProvider()
	{
		
	}
	
	public static WeatherProvider getProvider()
	{
		return weatherProvider;
		
	}
	
	public String getCurrentWeather(Coordinates coordinates)
	{
		Random random = new Random();
		return weather[random.nextInt(3)];  //return random integer numbers from 0 - 3
	}


}
