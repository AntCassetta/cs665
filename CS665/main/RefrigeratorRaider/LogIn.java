package RefrigeratorRaider;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import dataIO.ProxyReadTxtFile;
import io.ReadFile;
import raiderInventories.InventoryManager;
import userProfiles.RaiderUser;
import utilities.DataScanner;


public class LogIn implements State{
	
	private Vector<String> candidate;
	private Vector<String> roster;
	private ReadFile readUserFile = new ProxyReadTxtFile();
	InventoryManager Manager = InventoryManager.getInstance();
	
	
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
	public void doAction(Context context) {
		
		this.startLogIn(context.getUser());	
	
	}//end doAction
	
	public void loadRoster(RaiderUser givenUser) {
		String[] rosterLine;
		roster = readUserFile.readRosterFile(givenUser.getUserName(), givenUser.getUserID());
		for (String I : roster) {
		
		rosterLine = I.split(Pattern.quote(","));
		Manager.addInventory(rosterLine[0], Long.parseLong(rosterLine[1].trim()), rosterLine[2]);

		}//end for
	
	}//end loadRoster
	
	
	 public String toString(){
		 return "LogIn"; 
	     
	   }

}// end LogIn