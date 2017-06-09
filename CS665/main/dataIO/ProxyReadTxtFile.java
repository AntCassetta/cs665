package dataIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import io.ReadFile;


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
	public Vector<String> readUserFile(String givenUserName, long givenUserID, String givenUserType) {
		if (userCandidate == null) {
			
			readTextFile.readUserFile(givenUserName, givenUserID, givenUserType);
			userCandidate = readTextFile.getUserCandidate();
			System.out.println("\ndownloaded user data.");
			//readTextFile.displayUser();
		
		} else {
			
			System.out.println("\nNo user download required.");
			//readTextFile.displayUser();
		
		}//end readUserFile
		
		return userCandidate;
	}//end readUserFile

	
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> readRosterFile(String givenUserName, long givenUserID) {
		
		if (userRoster == null) {
			readTextFile.readRosterFile(givenUserName, givenUserID);
			userRoster = readTextFile.getUserRoster();
			System.out.println("\ndownloaded roster data.");
			//readTextFile.displayRoster();
		
		} else {
			System.out.println("\nNo roster download required.");
			//readTextFile.displayRoster();
		}
		return (Vector<String>)userRoster.clone();
	}//end readRosterFile

	
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> readInventoryFile(String givenInvName, long givenInvID) throws IOException, FileNotFoundException {
		if (userInventory == null){
			readTextFile.readInventoryFile(givenInvName, givenInvID);
			userInventory = readTextFile.getUserInventory();
			System.out.println("\ndownloaded Inventory data.");
			//readTextFile.displayInventory();
		
		} else {
			System.out.println("\nNo inventory download required.");
			//readTextFile.displayInventory();
		}
		return (Vector<String>) userInventory.clone();
	}//end readInventoryFile
}
