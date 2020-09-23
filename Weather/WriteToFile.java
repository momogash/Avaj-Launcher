package Weather;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteToFile {
	
	private  static  File newFile ;
    private  static  FileWriter myWriter;
    private static BufferedWriter buffw;
    private static  WriteToFile fileWritter ;
    
    private  WriteToFile(){

    }
	
	//creating the file to be written in
	
	public static WriteToFile createFile() {
		
		 if (fileWritter  != null) {
	            return fileWritter ;
	        }
//	
//		if(newFile.exists())
//			System.out.println("File already exists");
		
			try {
				newFile = new File("Simulation.txt");//storing the file name
				myWriter = new FileWriter(newFile);//create the file
				buffw = new BufferedWriter(myWriter);//load the file into the buffer for writting
				newFile.createNewFile();
			}
			catch (IOException e){} 
			
			return fileWritter ;
	
	}
		
	public void writeToFile(String str){
			try {
				//opening the file and writting to the file
				FileWriter filew = new FileWriter(newFile);
				BufferedWriter buffw = new BufferedWriter(filew);
				buffw.write(str);
				buffw.newLine();
				buffw.close();
				System.out.println("Successfully written to file");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	
	public void Close() {
		try{
            if(buffw !=null)
                buffw.close();

        }catch(IOException e){
            System.out.println("Unable to close file" + e);
        }
		
	}
	
}
	


