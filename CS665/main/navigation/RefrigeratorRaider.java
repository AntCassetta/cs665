package navigation;

import java.util.Scanner;

import userProfiles.User;

public class RefrigeratorRaider {

	public static void main(String[] args) {
		Scanner scan = DataScanner.getDataScanner();
		User activeUser = LogIn.startLogIn();
		
		boolean menuRunning = true;
		
		do {
			
			MainMenu.dispalyMainMenu(activeUser);
			
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