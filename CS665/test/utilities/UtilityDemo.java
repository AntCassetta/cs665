package utilities;

import raiderInventories.InventoryManager;
import raiderInventories.RaiderInventory;

public class UtilityDemo {

	public static void main(String[] args) {
		UtilityTool toolBox = new UtilityTool();
		
		InventoryManager testManager = InventoryManager.getInstance();
		RaiderInventory testFridge = testManager.addInventory("testFridge", 01, "Refrigerator");
		
		testFridge.addItem("Baby Spinich", 2, "produce");
		testFridge.addItem("Milk", 0, "Dairy");
		testFridge.addItem("butter", 0, "Dairy");
		testFridge.addItem("beef", 2, "Meat");
		testFridge.addItem("chicken", 2, "Meat");
		testFridge.addItem("baking soda",1, "misc");
		testFridge.addItem("eggs", 0, "Meat");
		
		//toolBox.checkForEXP();
		System.out.println();
		toolBox.checkForOOS(testFridge);
		System.out.println();
		toolBox.getDateToday();
		toolBox.getExpDate();
		toolBox.getExpDate("2017-05-28");

	}//end main

}//end utility demo
