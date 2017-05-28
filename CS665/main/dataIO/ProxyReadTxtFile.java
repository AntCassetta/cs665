package dataIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class ProxyReadTxtFile implements ReadFile {
	
	private ReadTxtFile readTextFile;
	private Vector<String> userCandidate;
	private Vector<String> userRoster;
	private Vector<String> userInventory;
	
	public ProxyReadTxtFile(){
		this.readTextFile = new ReadTxtFile();
		/*this.userCandidate = readTextFile.getUserCandidate();
		this.userRoster= readTextFile.getUserRoster();
		this.userInventory = readTextFile.getUserInventory();*/
	}

	@Override
	public void readUserFile(String givenUserName, int givenUserID) {
		if (userCandidate == null) {
			
			readTextFile.readUserFile(givenUserName, givenUserID);
			userCandidate = readTextFile.getUserCandidate();
			System.out.println("\ndownloaded user data.");
			readTextFile.displayUser();
		
		} else {
			System.out.println("\nNo user download required.");
			readTextFile.displayUser();
		
		}
		
	}//end readUserFile

	

	@Override
	public void readRosterFile(String givenUserName, int givenUserID) {
		
		if (userRoster == null) {
			readTextFile.readRosterFile(givenUserName, givenUserID);
			userRoster = readTextFile.getUserRoster();
			System.out.println("\ndownloaded roster data.");
			readTextFile.displayRoster();
		
		} else {
			System.out.println("\nNo roster download required.");
			readTextFile.displayRoster();
		}
		
	}//end readRosterFile

	
	@Override
	public void readInventoryFile(String givenInvName, int givenInvID) throws IOException, FileNotFoundException {
		if (userInventory == null){
			readTextFile.readInventoryFile(givenInvName, givenInvID);
			userInventory = readTextFile.getUserInventory();
			System.out.println("\ndownloaded Inventory data.");
			readTextFile.displayInventory();
		
		} else {
			System.out.println("\nNo inventory download required.");
			readTextFile.displayInventory();
		}
		
	}//end readInventoryFile
}
