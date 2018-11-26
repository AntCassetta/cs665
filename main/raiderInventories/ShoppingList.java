package raiderInventories;

import inventory.InventoryControl;

public class ShoppingList extends RaiderInventory{

	public ShoppingList(InventoryControl newInventoryControl, String nickName, long givenInventoryID) {
		super(newInventoryControl, nickName, givenInventoryID);
		
		System.out.println("Shopping list " + this.getInventoryID() +  " \""+this.getInventoryName() + "\" has been created.");
	}
	
	public String toString() {
		return "ShoppingList";
	};

}//end ShoppingList
