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
			File path = new File("src/scenario.txt");
			BufferedReader reader = new BufferedReader(new FileReader(path));
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
		
//		try {
//			
//			File path = new File("src/scenario.txt");
//			BufferedReader reader = new BufferedReader(new FileReader(path));
//			String line = reader.readLine(); //only read first line of scenario
//			System.out.println(line);
//			
//			if (line != null)
//			{
//				weatherTower = new WeatherTower();
//				int simulationCounter = Integer.parseInt(line); // get the count fr
//				System.out.println(simulationCounter);
//				
//				if (simulationCounter < 0) {
//					System.out.println("Simulation count cannot be negative"); // checking for negative simulation
//					System.exit(1);
//				}
//				while ((line = reader.readLine()) != null) //reading the entire file
//				{
//					String[] splitted = line.split(" ");
//					System.out.println(splitted[0]);
//					System.out.println(splitted[1]);
//					int i = 1;
//					while(i < simulationCounter) {
//						Flyable flyable = AircraftFactory.newAircraft(splitted[0], splitted[1], Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));
//						System.out.println(flyable);
//						//CreateFile.createSimulation("simulation.txt");
//						WriteToFile.createFile().writeToFile(str);;
//						flyable.registerTower(weatherTower);
//						
//						i++;
//					}
////					//flyables = line.split(" ")[0];
////					System.out.println(line);
////					
////					System.out.println(splitted[0]);
//////					Flyable flyables = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
//////	                        Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
//////	                        Integer.parseInt(line.split(" ")[4]));
////					
//				}
//////				
//				
//			}
//			
//			
//			
//		
//			//String line = reader.readLine(); //go y
////			
////			if(line !=null) {
////				weatherTower = new WeatherTower();
////				
////				int simulationCount = Integer.parseInt(line.split(" ")[0]);
////				if (simulationCount < 0)
////				{
////					System.out.println("The simulation count cannot be negetive");
////                    System.exit(1);
////				}
////				while ((line = reader.readLine()) != null) {
////
////	                  
////	                  Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
////	                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
////	                            Integer.parseInt(line.split(" ")[4]));
////	                    
////	                    if (flyable != null)
////	                        flyables.add(flyable);
////	                }
////				for (Flyable flyable : flyables) {
////                    flyable.registerTower(weatherTower);
////                }
////
////                for (int i = 1; i <= simulationCount; i++) {
////                    WriteToFile.createFile().writeToFile("\n"+"count" + i);
////                    weatherTower.changeWeather();
////                }
////
////			}
//			
//		}
		catch (FileNotFoundException e){
			
			 System.out.println("No such file or directory ");
			
		
			 }
		catch (IOException e) {
	            System.out.println("Unable to read file" + args[0]);
	    } 
			//catch (ArrayIndexOutOfBoundsException e) {
//	            System.out.println("You did not specify the simulation file");
//	    } catch (NullPointerException e) {
//	            System.out.println("value is null");
//	    } catch (NumberFormatException e) {
//	            System.out.println("not a valid number entered in file");
//	    } finally {
//	            WriteToFile.createFile().Close();
//	        }
	}
}
