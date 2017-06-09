package dataIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Pattern;
//import inventories.Inventory;

import io.ReadFile;


class ReadTxtFile implements ReadFile {
	
	private Vector<String> userCandidate = new Vector<String>();
	private Vector<String> userRoster = new Vector<String>();
	private Vector<String> userInventory = new Vector<String>();
	
	public Vector<String> readUserFile(String givenUserName, long givenUserID, String givenUserType) {
		
		// The name of the file to open.
        String fileName = "UserList.txt";

        // This will reference one line at a time
        String line = null;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //read the first line.
            line = bufferedReader.readLine();

	            //if there is still a line, read the line. 
            	while (line != null) {
            		String[] lineValues = line.split(Pattern.quote(","));
            		//sanity check of line values.
            		if(lineValues[0].equals(givenUserName) && Integer.parseInt(lineValues[1]) == givenUserID && lineValues[2].equals(givenUserType.toUpperCase())) {
            			
            			for(String I: lineValues){
            				userCandidate.add(I);
            			}
            		}//end if 
            		
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
    
        return userCandidate;
	}//end readUserFile
	

	public Vector<String> readRosterFile(String givenUserName, long givenUserID) {
		
		// The name of the file to open.
        String fileName = givenUserName + String.format("%02d",givenUserID) + ".txt";

        // This will reference one line at a time
        String line = null;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //read the first line.
            line = bufferedReader.readLine();

	            //if there is still a line, read the line. 
            	while (line != null) {
            		//String[] lineValues = line.split(Pattern.quote(","));
            		
            		userRoster.add(line);
            		
            		//System.out.println("User Roster: "+ lineValues[0] + " " + lineValues[1] + " " + lineValues[2]); //+ lineValues[1]);
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
        
    return userRoster;
	}//endRosterFile
	
	
	public Vector<String> readInventoryFile(String givenInvName, long givenInvID) 
			throws IOException, FileNotFoundException {

		// The name of the file to open.
		String fileName = givenInvName + String.format("%02d",givenInvID)+".txt";
		
		// This will reference one line at a time
		String line = null;
		
		try {
		// FileReader reads text files in the default encoding.
		FileReader fileReader = new FileReader(fileName);
		
		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		//read the first line.
		line = bufferedReader.readLine();
		
		//if there is still a line, read the line. 
		while (line != null) {
		
		userInventory.add(line);
		
		//String[] lineValues = line.split(Pattern.quote(","));
		//System.out.println("Inventoy Items: "+ lineValues[0] + " " + lineValues[1]); //+ lineValues[1]);
		
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
		return userInventory;

	}//end readInventoryFile

	
	public Vector<String> getUserCandidate(){ return userCandidate;}
	
	
	public Vector<String> getUserRoster(){ return userRoster;}
	
	
	public Vector<String> getUserInventory(){ return userInventory;}
	
	
	public void displayUser() {
		for(String I: userCandidate) { 
			System.out.print(I + "\n ");
		}//end for
	}//end displayUser
	
	
	public void displayRoster() {
		for(String I: userRoster) { 
			System.out.print(I + "\n");
		}//end for
	}//end displayRoster
	
	
	public void displayInventory() {
		for(String I: userInventory) { 
			System.out.print(I + "\n");
		}//end for
	}//end displayInvneotry
	
}//end ReadFileInventory
