package Simulator;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

import Aircraft.*;
import Weather.*;


public class Simulator {
	
	
	
	private static WeatherTower weatherTower;
    private static ArrayList<Flyable> flyables = new ArrayList<Flyable>();
    

	public static void main(String[] args) throws InterruptedException {
	

		try {
			
			ReadingFile textFile = new ReadingFile();
			ArrayList<String> fileContent = textFile.textFile(args[0]);
			

			if(fileContent !=null) {
				weatherTower = new WeatherTower();
				
				int scenario = Integer.parseInt(fileContent.get(0));				
				int i = 1;
				while (i < fileContent.size() -1) {

	                
	                  Flyable flyable = AircraftFactory.newAircraft(fileContent.get(i).split(" ")[0], fileContent.get(i).split(" ")[1],
	                            Integer.parseInt(fileContent.get(i).split(" ")[2]), Integer.parseInt(fileContent.get(i).split(" ")[3]),
	                            Integer.parseInt(fileContent.get(i).split(" ")[4]));

	                    if (flyable != null)
	                        flyables.add(flyable);
	                    i++;
	                    
	                }
				
				
				//register Aircrafts to tower
				int j = 0;
				Flyable flyable;
				while(j < flyables.size()) {
					flyable = flyables.get(j);
					flyable.registerTower(weatherTower);
					j++;
				
				}
				
//register aircraft to weather tower
				int k = 1;
				while(k <= scenario ) {
					WrittingToFile.createFile().writeToFile("\n"+"scenario: " + k);
					weatherTower.changeWeather();
					k++;
                }

			}

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
