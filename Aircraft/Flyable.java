package Aircraft;

import Weather.*;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);

}
