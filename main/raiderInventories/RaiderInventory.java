package raiderInventories;
import dataStructures.LinkedPositionalList;
import inventory.InventoryControl;
import inventory.Inventory;

public abstract class RaiderInventory implements Inventory<RaiderItem>{
	
	private InventoryControl inventoryControl;
	private long inventoryID;
	private String inventoryName;
	protected LinkedPositionalList<RaiderItem> itemInventory = new LinkedPositionalList<RaiderItem>();
	
	public RaiderInventory (InventoryControl newInventoryControl,
							String nickName, long givenInventoryID) {
		
		inventoryControl = newInventoryControl;
		inventoryID = givenInventoryID;
		//inventoryControl.addInventory(this);
		inventoryControl.setInventoryName(this, nickName);
		
	}//end constructor
	
	
	public void setInventoryID (int idNumber) { inventoryID = idNumber; } //end setInventoryID
	
	
	public void setInventoryName(String givenName) {inventoryName = givenName;} // end setInventoryName
	
	
	public long getInventoryID() { return inventoryID; }//end getInventoryID
	
	
	public String getInventoryName() { return inventoryName; }//end getInventoryName
	
	
	public LinkedPositionalList<RaiderItem> getItemInv() { return itemInventory; }//end getItemInv 
	
	
	public void isEmpty(){ inventoryControl.isEmpty(this); }//end isEmpty

	
	public void printContents() { inventoryControl.printContents(this);	}//end printContents
	
	
	public void printOOS() {inventoryControl.printOOS(this);};//end printOOS
	
	
	public void printEXP() {inventoryControl.printEXP(this);};//end printEXP
	
	
	public void addItem (String givenItemName, int givenItemQuantity, String givenItemType) {
		
		inventoryControl.addItem(this, givenItemName, givenItemQuantity, givenItemType);
	
	}//end addItem
	
	
	public void removeItem (String givenItemName) {
			
		inventoryControl.removeItem(this, givenItemName);
		
	}//end addItem
	
	
	public void incrementItem(String givenItemName) {
		
		inventoryControl.incrementItem(this, givenItemName);
	
	}//end incrementItem
	
	
	public void decrementItem(String givenItemName) {
			
			inventoryControl.decrementItem(this, givenItemName);
		
		}//end decrementItem

	
	public void updateItemQuantity(String givenItemName, int givenItemQuantity) {
		
		inventoryControl.updateItemQuantity(this, givenItemName, givenItemQuantity);
	
	}//end updateItemQuantity
	
	public String toString() {
		return "RaiderInventory";
	};
	
}//end Inventory
