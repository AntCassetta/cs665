package dataIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ReadFile {

	protected static void readFromFile(String givenInvName, int givenInvID) throws IOException, FileNotFoundException {
		
		// The name of the file to open.
	        String fileName = givenInvName + givenInvID+".txt";
	
	        // This will reference one line at a time
	        String line = null;
	        
	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(fileName);
	            
	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            
	            //read the first line.
	            line = bufferedReader.readLine();
	            //String[] stringSplit = line.split(Pattern.quote(","));
	            

		            //if there is still a line, read the line. 
	            	while (line != null) {
	            		String[] stringSplit = line.split(Pattern.quote(","));
	            		//sanity check of line values.
	            		System.out.println("Line values: "+ line);
	            		System.out.println("String[] values: "+ stringSplit[0] + " | " + stringSplit[1]); //+ stringSplit[1]);
		            	line = bufferedReader.readLine();
	            	}//end if
	            	//System.out.print("\n");
	            	
	           
	            // Always close files.
	            bufferedReader.close();         
	        
	        } catch(FileNotFoundException ex) {
	        	
	            System.out.println(ex);
	            System.out.println("Unable to open file '" + fileName + "'");
	            
	            	        
	        } catch(IOException ex) {
	            
	        	System.out.println("Error reading file '" + fileName + "'");
	        	
	        }// end try catch
	        
		}//end readFile
	
	public static void main(String []args){
		try {
		ReadFile.readFromFile("TestFridge", 01);
		} catch (Exception ex){
			ex.printStackTrace();
			
		}
	}
}
