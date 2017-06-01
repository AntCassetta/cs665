package navigation;

import java.util.Scanner;
import userProfiles.User;


public class LogIn implements State{	
	
	public void startLogIn(User givenUser) {
		
		User activeUser = givenUser;
		
		Scanner scan = DataScanner.getDataScanner();  // Reading from System.in
		System.out.println("Please Enter your user Name: ");
		String inputName = scan.next(); // Scans the next token of the input as a string.
		
		System.out.println("Please Enter your user ID: ");
		int inputInt = scan.nextInt();
		
		System.out.println("Please Enter your user Type (Owner or Raider): ");
		String inputType = scan.next();
		
		activeUser.setUserName(inputName);
		activeUser.setUserID(inputInt);
		activeUser.setUserType(inputType);
		
	}//end startLogIn

	@Override
	public void doAction(Context context) {
		
		this.startLogIn(context.getUser());	
	
	}
	
	 public String toString(){
	      return "LogIn";
	   }

}// end LogIn