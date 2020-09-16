package Aircraft;

public class Coordinates 
{
	private int longitude;
	private int latitude;
	private int height;
	
	Coordinates(int longitude, int latitude, int height)
	{
		if(longitude < 0)
			longitude = 0;
		if(latitude < 0)
			latitude = 0;
		if(height < 0)
			height = 0;
		if(height >100)
			height = 100;
		
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

}
