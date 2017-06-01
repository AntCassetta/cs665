package RefrigeratorRaider;

import java.util.Scanner;

import utilities.DataScanner;

public class RefrigeratorRaider {
	
	
	public static void main(String[] args) {
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
				context.setState(mainMenu);
			
					
			
			case "MainMenu":
				
				System.out.println("current State: " + context.getState().toString());
				mainMenu.doAction(context);
				
			}
			
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
		
		} while (menuRunning == true);
		System.out.println("Exiting... GoodBye.");
		System.exit(0);
	}//end main
}//end RefrigeratorRaider