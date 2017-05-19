package inventories;
import dataStructures.LinkedPositionalList;

public abstract class Inventory {
	
	private InventoryControl inventoryControl;
	private int inventoryID;
	//private int totalItems = 0;
	//private int totalOOS = 0;
	protected LinkedPositionalList<Item> itemInventory = new LinkedPositionalList<Item>();
	
	public Inventory(InventoryControl newInventoryControl){
		
		inventoryControl = newInventoryControl;
		inventoryControl.addInventory(this);
		
	}//end constructor
	
	
	public void setInventoryID (int idNumber) { inventoryID = idNumber; } //end setInventoryID
	
	
	public int getInventoryID() { return inventoryID; }//end getInventoryID
	
	
	public void isEmpty(){
		
		inventoryControl.isEmpty(this);
	
	}//end isEmpty

	
	public void printContents() {
		
		inventoryControl.printContents(this);
	}//end printContents
	
	
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
			
			inventoryControl.incrementItem(this, givenItemName);
		
		}//end decrementItem
	
	public void updateItemQuantity(String givenItemName, int givenItemQuantity) {
		
		inventoryControl.updateItemQuantity(this, givenItemName, givenItemQuantity);
	
	}//end updateItemQuantity
	
}//end Inventory
