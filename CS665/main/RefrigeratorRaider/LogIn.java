package RefrigeratorRaider;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import dataIO.ProxyReadTxtFile;
import io.ReadFile;
import raiderInventories.InventoryManager;
import userProfiles.RaiderUser;
import utilities.DataScanner;

/**LogIn is a state used in the control of the Refrigerator Raider. LogIn is the initial stare which facilitates user LogIn 
 * @author anthonycassetta
 */
public class LogIn implements State{
	
	private Vector<String> candidate;
	private Vector<String> roster;
	private ReadFile readUserFile = new ProxyReadTxtFile();
	InventoryManager Manager = InventoryManager.getInstance();
	
	/**startLogIn prompts the end user for in their caseSentsative user name, user ID and user Type. 
	 * Then checks this information against the userList.
	 * If a match is found the appropriate values are set within the User object for the remainder of runtime.
	 * @param givenUser the the singleton User object to be configured by the log in process.
	 */
	public void startLogIn(RaiderUser givenUser) {
		
		RaiderUser activeUser = givenUser;
		
		Scanner scan = DataScanner.getDataScanner();  // Reading from System.in
		System.out.println("Please Enter your user Name: ");
		String inputName = scan.next(); // Scans the next token of the input as a string.
		
		System.out.println("Please Enter your user ID: ");
		int inputInt = scan.nextInt();
		
		System.out.println("Please Enter your user Type (Owner, Raider, Business, Charity): ");
		String inputType = scan.next();
		
		candidate = readUserFile.readUserFile(inputName, inputInt, inputType);
		
		if (candidate.size() < 3 || candidate.size() > 3) {
			System.out.println("We did not find a registered user for :" + inputName +" " + inputInt);
		} else {
		
		activeUser.setUserName(candidate.get(0));
		activeUser.setUserID(Integer.parseInt(candidate.get(1)));
		activeUser.setUserType(candidate.get(2));
		}//end if else
		
		loadRoster(activeUser);
		
	}//end startLogIn

	
	@Override
	/**This method corresponds with the Context object to facilitate the state pattern*/
	public void doAction(Context context) {	this.startLogIn(context.getUser());	}//end doAction
	
	
	/**loadRoster takes the singleton User, loads their roster information and creates instances of their rosters, if any.
	 * @param givenUser
	 */
	public void loadRoster(RaiderUser givenUser) {
		String[] rosterLine;
		roster = readUserFile.readRosterFile(givenUser.getUserName(), givenUser.getUserID());
		for (String I : roster) {
		
			rosterLine = I.split(Pattern.quote(","));
			System.out.println(rosterLine[0]+ Long.parseLong(rosterLine[1].trim())+ rosterLine[2].trim());
			Manager.addInventory(rosterLine[0], Long.parseLong(rosterLine[1].trim()), rosterLine[2].trim());

		}//end for
	}//end loadRoster
	
	
	/** Returns a string representation of the object. This method is used to confirm the current state of Context.*/
	 public String toString() { return "LogIn"; }//end toString

}// end LogIn