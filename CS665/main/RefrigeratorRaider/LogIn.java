package RefrigeratorRaider;

import java.util.Scanner;
import java.util.Vector;

import dataIO.ProxyReadTxtFile;
import io.ReadFile;
import userProfiles.RaiderUser;
import utilities.DataScanner;


public class LogIn implements State{
	
	private Vector<String> candidate;
	
	public void startLogIn(RaiderUser givenUser) {
		
		RaiderUser activeUser = givenUser;
		ReadFile readUserFile = new ProxyReadTxtFile();
		
		
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
		
		}
		
	}//end startLogIn

	@Override
	public void doAction(Context context) {
		
		this.startLogIn(context.getUser());	
	
	}
	
	 public String toString(){
		 return "LogIn"; 
	     
	   }

}// end LogIn