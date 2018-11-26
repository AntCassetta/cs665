package dataIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import io.ReadFile;

/**Proxy file responsible for managing reading data from the text files representing Users, user rosters and inventory contents
 * @author anthonycassetta
 */
public class ProxyReadTxtFile implements ReadFile {
	
	private ReadTxtFile readTextFile;
	private Vector<String> userCandidate;
	private Vector<String> userRoster;
	private Vector<String> userInventory;
	
	
	public ProxyReadTxtFile(){
		this.readTextFile = new ReadTxtFile();
	}
	
	
	/**Will return the cached data if present, otherwise will load and return the data from txt file.
	 * @param givenUserName the user name to be verified
	 * @param givenUserID the ID number of the user to be verified
	 * @param givenUserType the type of user to be verified
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Override
	public Vector<String> readUserFile(String givenUserName, long givenUserID, String givenUserType) throws FileNotFoundException, IOException {
		if (userCandidate == null) {
			
			userCandidate = readTextFile.readUserFile(givenUserName, givenUserID, givenUserType);
			//userCandidate = readTextFile.getUserCandidate();
			System.out.println("\ndownloaded user data.");
			//readTextFile.displayUser();
		
		} else {
			
			System.out.println("\nNo user download required.");
			//readTextFile.displayUser();
		
		}//end readUserFile
		
		return userCandidate;
	}//end readUserFile

	
	/** Returns the user's roster if it's already been loaded, otherwise the user's inventory will be loaded from the text file.
	 * @param givenUserName The user name associated with the roster
	 * @param givenUserID  The userID associated with the roster
	 * @return Vector<String> a vector of strings representing each rosters Name, ID, and Type 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> readRosterFile(String givenUserName, long givenUserID) throws FileNotFoundException, IOException {
		
		if (userRoster == null) {
			userRoster = readTextFile.readRosterFile(givenUserName, givenUserID);
			System.out.println("\ndownloaded roster data.");

		
		} else {
			System.out.println("\nNo roster download required.");

		}
		return (Vector<String>)userRoster.clone();
	}//end readRosterFile

	
	/** Returns the user's inventory contents if it's already been loaded, otherwise the user's roster will be loaded from the text file.
	 * @param givenInvName The associated inventory name
	 * @param givenInvID  The associated inventory ID
	 * @return Vector<String> a vector of strings representing each Items Name, ID, and Type
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> readInventoryFile(String givenInvName, long givenInvID) throws FileNotFoundException, IOException {
		if (userInventory == null){
			userInventory =readTextFile.readInventoryFile(givenInvName, givenInvID);
			System.out.println("\ndownloaded Inventory data.");
		
		} else if (!userInventory.firstElement().equals(givenInvName + givenInvID)) {
			userInventory = readTextFile.readInventoryFile(givenInvName, givenInvID);
			System.out.println("\ndownloaded Inventory data.");
			
		} else {
			System.out.println("\nNo inventory download required.");
		}
		return (Vector<String>) userInventory.clone();
	}//end readInventoryFile
}
