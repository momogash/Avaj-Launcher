package Weather;

import Aircraft.*;
import java.util.*;

public abstract class Tower {
	
	//create an arraylist object, observers of type flyable 
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		observers.add(flyable); //adds all the strings received from flyable in simulation class
	}
	
	public void unregister(Flyable flyable) {
		observers.remove(flyable); //removes an element to array
	}
	
	protected void conditionsChanged() {
		
		int i = 0;
		while( i <observers.size()) {
			observers.get(i).updateConditions();
			i++;
		}
	}	

}
