package Weather;

import Aircraft.Coordinates;

public class WeatherTower extends Tower {
	
	public String getWeather(Coordinates coordinates)
	{
		WeatherProvider weatherProvider = WeatherProvider.getProvider();
		String weather = weatherProvider.getCurrentWeather(coordinates);
		return weather;
				
	}
	 public void changeWeather(){
	        super.conditionsChanged();
	    }
	
}
