package RefrigeratorRaider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import utilities.DataScanner;

public class RefrigeratorRaider {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//scanner object
		Scanner scan = DataScanner.getDataScanner();
		
		//context object
		Context context = new Context();
		
		//state objects
		State logIn = new LogIn();
		State mainMenu = new MainMenu();
		
		//set initial state
		context.setState(logIn);
		
		//variable used to check if menu should still be running.
		boolean menuRunning = true;
		
		//do while menuRunning is true
		do {
			
			switch (context.getState().toString()) {
			
			case "LogIn":
					
				System.out.println("current State: " + context.getState().toString());
				logIn.doAction(context);
				
				if (context.getUser().getUserType() == null) {
					break;
				} else {
					context.setState(mainMenu);
				}//end if else
			
			case "MainMenu":
				
				System.out.println("current State: " + context.getState().toString());
				mainMenu.doAction(context);
			
			}//end switch
			
			System.out.println("Do you want to continue?");
			System.out.println("	1. Contune");
			System.out.println("	2. Quit");
			int menuSel = scan.nextInt();
			switch (menuSel){
			case 1:
				menuRunning = true;
				break;
				
			case 2:
				menuRunning = false;
				break;
			}//end continue/quit switch
		
		} while (menuRunning == true); //end do while
		System.out.println("Exiting... GoodBye.");
		System.exit(0);
	}//end main
}//end RefrigeratorRaider
