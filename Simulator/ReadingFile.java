package Simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingFile {
	
	public ArrayList<String> textFile(String inputFile){
		
		ArrayList<String> fileContent = new ArrayList<String>();

		try {
			File file = new File("/Users/molokomogashoa/eclipse-workspace/Avaj_launcher/src/scenario.txt");
			Scanner scan = new Scanner(file);
			//System.out.println(scan.nextLine()); //prints first line of text file
			
			//read each line while there is a next line and store in an arraylist of strings
			
			
			
			while (scan.hasNextLine()) {
				//fileContent = fileContent.concat(scan.nextLine() + "\n"); //store read line
				fileContent.add(scan.nextLine());
			}
			scan.close();
			System.out.println(fileContent);
			
			//getting the simulations count and accounting for negatives
			int simulationCount = Integer.parseInt(fileContent.get(0)); 
			
			if(simulationCount <= 0) {
				System.out.println("The simulation count cannot be negetive");
                System.exit(1);
			}
			
			//ensure scenarios given are the correct ones as per PDF spec
			int i = 1;
			while (i < fileContent.size())
			{
				String[] line = fileContent.get(i).split(" ");
				//System.out.println(line[0]);
				if (line.length != 5)
					System.out.println("Cannot create an aircraft with the given format");
				if(!line[0].equals("Baloon") && !line[0].equals("JetPlane") && !line.equals("Helicopter"))
					System.out.println("Please check the aircraft type:Baloon,JetPlane,Helicopter");
				int longitude = Integer.parseInt(line[2]);
				int latitude = Integer.parseInt(line[3]);
				int height = Integer.parseInt(line[4]);
				
				if( longitude <= 0 || latitude <= 0 || height <= 0)
					System.out.println("Coordinates cannot be negetive");
				i++;
			}
		
			
				
				
				
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("No such file or directory ");
		}
		
//		while (scan.hasNextLine()) {
//			System.out.println(scan.hasNextLine());
//		}
		
	return fileContent;
	}

}
