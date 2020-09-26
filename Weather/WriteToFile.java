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
	
	
	public static WriteToFile createFile() {
		
		 if (fileWritter  != null) {
	            return fileWritter ;
	        }
		
			try {
				fileWritter = new WriteToFile();
				newFile = new File("Simulation.txt");
				myWriter = new FileWriter(newFile);//create the file
				buffw = new BufferedWriter(myWriter);//load the file into the buffer for writting
			}
			catch (IOException e){} 
			
			return fileWritter ;
	
	}
		
	public void writeToFile(String str){
			try {
				
				buffw.write(str);
				buffw.newLine();
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
	


