package Simulator;

//import java.util.ArrayList;
import java.io.*;
import java.util.*;

import Aircraft.*;
import Weather.*;


public class Simulator {
	
	
	
	private static WeatherTower weatherTower;
    private static ArrayList<Flyable> flyables = new ArrayList<Flyable>();
    

	public static void main(String[] args) throws InterruptedException {
	

		try {
			
//			if (args.length == 0)
//			{
//				System.out.println("must have atlest one arg input e.g scenario.txt");
//				return;
//			}
			File path = new File("src/scenario.txt");
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = reader.readLine();
			
			if(line !=null) {
				weatherTower = new WeatherTower();
				
				int scenario = Integer.parseInt(line.split(" ")[0]);
				
				if (scenario < 0)
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
				
				//register Aircrafts to tower
				int i = 0;
				Flyable flyable;
				while(i < flyables.size()) {
					flyable = flyables.get(i);
					System.out.println(flyable);
					flyable.registerTower(weatherTower);
					i++;
				
				}
//register aircraft to weather tower
				int j = 1;
				while(j <= scenario ) {
					WrittingToFile.createFile().writeToFile("\n"+"scenario: " + j);
					weatherTower.changeWeather();
					j++;
                }

			}
			reader.close();
		}
		catch (FileNotFoundException e){
			
			 System.out.println("No such file or directory ");
			
		
			 }
		catch (IOException e) {
	            System.out.println("Unable to read file" + args[0]);
	    } 
			catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("You did not specify the simulation file");
	    } catch (NullPointerException e) {
	            System.out.println("value is null");
	    } catch (NumberFormatException e) {
	            System.out.println("not a valid number entered in file");
	    } finally {
	            WrittingToFile.createFile().Close();
	        }
	}
}
