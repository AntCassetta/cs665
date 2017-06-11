package RefrigeratorRaider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import dataIO.ProxyReadTxtFile;
import io.ReadFile;
import raiderInventories.InventoryManager;
import raiderInventories.RaiderInventory;
import userProfiles.RaiderUser;
import utilities.DataScanner;

public class MainMenu implements State {
	
	InventoryManager Manager = InventoryManager.getInstance();
	private ReadFile readInventoryFile = new ProxyReadTxtFile();
	
	public void dispalyMainMenu(RaiderUser givenUser) {
		
		Scanner scan = DataScanner.getDataScanner();
		
		System.out.println("\nRefrigerator Raider Main Menu");
		System.out.println("Please choose an number option:");
		
		switch (givenUser.getUserType()) {
			
			case "OWNER":
				System.out.println("Fridge Owner options:" );
				break;
			
			case "RAIDER":
				System.out.println("Fridge Raider options:");
				break;
				
			case "BUSINESS":
				System.out.println("Business Fridge options:");
				break;
				
			case "CHARITY":
				System.out.println("Charity Fridge options:");
				break;
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
						
						//System.out.println("One day I'll print your Refrigerator contents");
						for (RaiderInventory inventory: Manager.getInventoryRoster()) {
							if (inventory.toString().equals("Refrigerator")) {
								try {
									this.loadInventory(inventory);
								} catch (Exception e) { 
									System.out.println(e); 
								}
								inventory.printContents();
							}//end if
						}//end for
						
						//TODO implement a system to pick between multiple Refrigerators
						break;
	
					case 2: 
						
						System.out.println("One day I'll print your ShoppingList");
						for (RaiderInventory inventory: Manager.getInventoryRoster()) {
							if (inventory.toString().equals("ShoppingList"))
								try {
									this.loadInventory(inventory);
								} catch (Exception e) { 
									System.out.println(e); 
								}
								inventory.printContents();
						}
						break;
						
				}//end Switch
	
			}// if else
		} catch (InputMismatchException e) {
				System.out.println(e);
				
		}//try-catch end
	
	}//end StartMainMenu
	
	
	public void loadInventory(RaiderInventory givenInventory) throws FileNotFoundException, IOException {
		String[] inventoryLine;
		Vector<String> inventory = readInventoryFile.readInventoryFile(givenInventory.getInventoryName(), givenInventory.getInventoryID());
		if (inventory.firstElement().equals(givenInventory.getInventoryName() + givenInventory.getInventoryID())) {
			for (String I : inventory) {
				if (!I.equals(inventory.firstElement())){
					inventoryLine = I.split(Pattern.quote(","));
					//System.out.println(inventoryLine[0]+ Long.parseLong(inventoryLine[1].trim())+ inventoryLine[2].trim());
					Manager.addItem(givenInventory, inventoryLine[0], Integer.parseInt(inventoryLine[1].trim()), inventoryLine[2].trim());
				}//end if to skip first element
			}//end for
		}//end else if to confirm cached data
	}//end loadRoster

	@Override
	public void doAction(Context context) {
		
		this.dispalyMainMenu(context.getUser());
		
	}
	
	public String toString(){
	      return "MainMenu";
	   }
	
}