package Aircraft;

public abstract class Aircraft
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 1;
	
	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();	
	}
	
	protected long nextId()
	{
		return Aircraft.idCounter++;
	}
	

}
