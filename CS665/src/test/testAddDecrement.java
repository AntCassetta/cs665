package test;
import inventories.*;

public class testAddDecrement {
	
	public static void main(String[] args) {
		
		InventoryManager InvMaster = new InventoryManager();
		
		Refrigerator kitchen = new Refrigerator(InvMaster);
		
		Refrigerator poolHouse = new Refrigerator(InvMaster);
		
		ShoppingList marketList = new ShoppingList(InvMaster);
		
		kitchen.addItem("Chedder Cheese", 2);
		
		kitchen.addItem("Milk", 1);
		
		kitchen.addItem("butter", -2);
		
		kitchen.isEmpty();
		
		kitchen.printContents();
		
		
		
		kitchen.incrementItem("milk");
		
		kitchen.removeItem("Chedder Cheese");
		
		kitchen.printContents();
		/*
		marketList.addItem("Apples", 12);
		
		marketList.addItem("butter", -2);
		
		marketList.addItem("Chedder Cheese", 2);
		
		marketList.printContents();
		
		marketList.incrementItem("milk"); //TODO need to add error checking for when and Item is not found
		
		marketList.decrementItem("Chedder Cheese");
		
		marketList.printContents();
		
		poolHouse.addItem("Sam Adams", 12);
		
		poolHouse.addItem("Salsa", 1);
		
		poolHouse.decrementItem("Salsa"); //QTY >= 0 should work
		
		poolHouse.decrementItem("Salsa"); //QTY < 0 should not work
		*/
	}
}
