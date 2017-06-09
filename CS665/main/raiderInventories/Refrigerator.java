package raiderInventories;

import inventory.InventoryControl;

public class Refrigerator extends RaiderInventory{

	public Refrigerator(InventoryControl newInventoryControl,
						String nickName, long givenInventoryID) {
		super(newInventoryControl, nickName, givenInventoryID);
		
		System.out.println("Refrigerator " + this.getInventoryID() + " \""+this.getInventoryName() + "\" has been created.");
	}
	
}//end refrigerator
