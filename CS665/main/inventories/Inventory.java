package inventories;
import dataStructures.LinkedPositionalList;

public abstract class Inventory {
	
	private InventoryControl inventoryControl;
	private int inventoryID;
	private String inventoryName;
	//private int totalItems = 0;
	//private int totalOOS = 0;
	protected LinkedPositionalList<Item> itemInventory = new LinkedPositionalList<Item>();
	
	public Inventory(InventoryControl newInventoryControl, String nickName){
		
		inventoryControl = newInventoryControl;
		inventoryControl.addInventory(this);
		inventoryControl.setInventoryName(this, nickName);
		
	}//end constructor
	
	
	public void setInventoryID (int idNumber) { inventoryID = idNumber; } //end setInventoryID
	
	
	public void setInventoryName(String givenName) {inventoryName = givenName;} // end setInventoryName
	
	
	public int getInventoryID() { return inventoryID; }//end getInventoryID
	
	
	public String getInventoryName() { return inventoryName; }//end getInventoryName
	
	
	public void isEmpty(){ inventoryControl.isEmpty(this); }//end isEmpty

	
	public void printContents() { inventoryControl.printContents(this);	}//end printContents
	
	
	public void addItem (String givenItemName, int givenItemQuantity) {
		
		inventoryControl.addItem(this, givenItemName, givenItemQuantity);
	
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
	
}//end Inventory
