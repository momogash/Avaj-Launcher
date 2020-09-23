package Simulator;

//import java.util.ArrayList;
import java.io.*;
import java.util.*;

import Aircraft.*;
import Weather.*;


public class Simulator {
	
	private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] args) throws InterruptedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("stimulator.txt"));
			String line = reader.readLine();
			
			if(line !=null) {
				weatherTower = new WeatherTower();
				
				int simulationCount = Integer.parseInt(line.split(" ")[0]);
				if (simulationCount < 0)
				{
					System.out.println("The simulation count cannot be negetive");
                    System.exit(1);
				}
				while ((line = reader.readLine()) != null) {

	                  
	                  Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
	                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
	                            Integer.parseInt(line.split(" ")[4]));
	                    
	                    if (flyable != null)
	                        flyables.add(flyable);
	                }
				for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulationCount; i++) {
                    WriteToFile.createFile().writeToFile("\n"+"count" + i);
                    weatherTower.changeWeather();
                }

			}
			
		}
		catch (FileNotFoundException e){
			 System.out.println("There should be atleast one argument " + args[0]);
			
		}catch (IOException e) {
	            System.out.println("Something went wrong while reading the file " + args[0]);
	    } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("You did not specify the simulation file");
	    } catch (NullPointerException e) {
	            System.out.println("value is null");
	    } catch (NumberFormatException e) {
	            System.out.println("not a valid number entered in file");
	    } finally {
	            WriteToFile.createFile().Close();
	        }
	}
}
