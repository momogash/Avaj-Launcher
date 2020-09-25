package Weather;

import Aircraft.*;
import java.util.*;

public abstract class Tower {
	
	//create an arraylist object, observers of type flyable 
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		observers.add(flyable); //adds and element to array observers
	}
	
	public void unregister(Flyable flyable) {
		observers.remove(flyable); //removes an element to array
	}
	
	protected void conditionsChanged() {
		for(int i = 0; i < observers.size(); i++)
			observers.get(i).updateConditions();
	}	

}
