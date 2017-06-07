package RefrigeratorRaider;

import java.util.InputMismatchException;
import java.util.Scanner;

import userProfiles.RaiderUser;
import utilities.DataScanner;

public class MainMenu implements State {
	
	public void dispalyMainMenu(RaiderUser givenUser){
		
		Scanner scan = DataScanner.getDataScanner();
		
		
		System.out.println("\nRefrigerator Raider Main Menu");
		System.out.println("Please choose an number option:");
		
		switch (givenUser.getUserType()) {
			
			case "OWNER":
			System.out.println("Fridge Owner options:" );
			
			case "RAIDER":
				System.out.println("Fridge Owner options:");
		}//end user level switch
		
		System.out.println("	1. Display Refrigerator Contents");
		System.out.println("	2. Display Shopping List Contents");
		//System.out.println("	3. quit");
	
		try {
		System.out.print("Enter Choice: "); 
		int menuSel = scan.nextInt();
	
			if (menuSel > 3 || menuSel < 1) {
				//menuScan.close();
				throw new InputMismatchException("You must enter one of the options listed by number.");
				
			} else {
	
				switch (menuSel){
					case 1: 
						System.out.println("Now I'll show Fridge contents");
						break;
	
					case 2: 
						System.out.println("Now I'll show Shopping List contents");
						break;
						
					//case 3:
						//System.out.println("Exiting... GoodBye.");
						//break;
						
				}//end Switch
	
			}// if else
		} catch (InputMismatchException e) {
				System.out.println(e);
				
		}//try-catch end
	
	}//end StartMainMenu

	@Override
	public void doAction(Context context) {
		
		this.dispalyMainMenu(context.getUser());
		
	}
	
	public String toString(){
	      return "MainMenu";
	   }
	
}