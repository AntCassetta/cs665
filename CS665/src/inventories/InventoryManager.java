package inventories;

import java.util.ArrayList;
import dataStructures.Position;

/**Inventory Manager is the concrete class for mediating the instances of Inventory objects and Item objects.
 * 
 * @author anthonycassetta
 */
public class InventoryManager implements InventoryControl {
	
	private ArrayList<Inventory> inventoryRoster;
	int nextID = 00;

	/**Constructs an InventoryManager object*/
	public InventoryManager(){
		inventoryRoster = new ArrayList<Inventory>();
	}//end constructor
	
	/**Assigns an inventory object an InventoryID and stores the object within a list for later reference
	 * @param newInventory The new inventory object to be assigned an inventoryID and stored.
	 */
	public void addInventory(Inventory newInventory) {
		
		inventoryRoster.add(newInventory);
		nextID++;
		newInventory.setInventoryID(nextID);
		
	}//end addInventory

	/**Removes the given inventory object from the inventoryRoster. This inventoryID is not reclaimed.
	 * @param givenInventory the inventory object to be removed
	 */
	public void removeInventory(Inventory givenInventory) {
		
		for(Inventory inv: inventoryRoster) {
			if( inv.getInventoryID() == givenInventory.getInventoryID() ){
				inventoryRoster.remove(givenInventory);
			}//end if
		}//end for
	}//end removeInventory

	/**Checks if the inventory is empty*/
	public void isEmpty(Inventory givenInventory) {
		
				if (givenInventory.itemInventory.isEmpty()){
					System.out.println("Inventory "+ givenInventory.getInventoryID() + " is empty.");
				
				} else{
					System.out.println("Inventory "+ givenInventory.getInventoryID() + " has " 
											+ givenInventory.itemInventory.size() + " items.");
				}//end if else

	}//end is empty

	/**Prints contents of the inventory to the console*/
	public void printContents(Inventory givenInventory) {
		
		Position<Item> current = givenInventory.itemInventory.first();
		Position<Item> next = givenInventory.itemInventory.after(current);
		System.out.println("\nContents of "+ givenInventory.getInventoryID() + ":");
		
		while (next != null){	
			
			if (next != givenInventory.itemInventory.last()){
			
			System.out.println("Item: " + current.getElement().getItemName() + " | Qty: " + current.getElement().getItemQuantity());
			
			current = next;
			next = givenInventory.itemInventory.after(next);
			
			} /*else {
				System.out.println("Item: " + current.getElement().itemName + " | Qty: " + current.getElement().itemQuantity);
				
				next = givenInventory.itemInventory.after(next);
			}*/
		
		}//while end
	}//end printContents

	/**Attempts to create the new Item object, upon success, the object will be added to the target inventory provided.
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be created
	 * @param GivenitemQuantity quantity of the item to be added
	 */
	public void addItem(Inventory givenInventory, String givenItemName, int givenItemQuantity) {
		
		Item newItem = createItem(givenItemName, givenItemQuantity);
		
		givenInventory.itemInventory.addLast(newItem);
		
	}//end addItem

	/**Locates and removes an Item object from the inventory.
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be removed
	 */
	public void removeItem(Inventory givenInventory, String givenItemName) {
		
		
				
				Position<Item> current = givenInventory.itemInventory.first();
				Position<Item> next = givenInventory.itemInventory.after(current);
				
				while (next != null) {	
					
					if (current.getElement().getItemName().toUpperCase() == givenItemName.toUpperCase()) {
						
						givenInventory.itemInventory.remove(current);
						break;
					
					} else {
						
						next = givenInventory.itemInventory.after(next);
					
					}//end if else
				
				}//while end
				
	}//end removeItem

	/**Locates the given item's position and increments the items quantity by 1 unit.
	 * Example: Milk, 1 incrementItem(01, "Milk") will result Inventory 01: Item: Milk QTY: 2
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be altered
	 */
	public void incrementItem(Inventory givenInventory, String givenItemName) {
		
				Position<Item> current = givenInventory.itemInventory.first();
				Position<Item> next = givenInventory.itemInventory.after(current);
				
				while (next != null){	
					
					if (current.getElement().getItemName().toUpperCase() == givenItemName.toUpperCase()) {
						
						int currentQTY = current.getElement().getItemQuantity();
						current.getElement().setItemQuantity(currentQTY + 1);
						break;
					
					} else {
						
						next = givenInventory.itemInventory.after(next);
					
					}//end if else
					
				}//while end

	}//end incrementItem

	/**Locates the given item's position and decrements the items quantity by 1 unit.
	 * Example: Milk, 1 decrementItem(01, "Milk") will result Inventory 01: Item: Milk QTY: 0
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be altered
	 */
	public void decrementItem(Inventory givenInventory, String givenItemName) {
		
		Position<Item> current = givenInventory.itemInventory.first();
		Position<Item> next = givenInventory.itemInventory.after(current);
		
		while (next != null){	
			
			if (current.getElement().getItemName().toUpperCase() == givenItemName.toUpperCase()) {
				
				int currentQTY = current.getElement().getItemQuantity();
				
				//Confirm the current quantity is greater than zero.
				if (currentQTY > 0 ) {

					current.getElement().setItemQuantity(currentQTY - 1);
					break;
				
				} else {
					
					throw new IllegalArgumentException("Cannot Decrement, the quantity must be zero or greater.");
				
				}//end inner if
				
			} else {
				
				next = givenInventory.itemInventory.after(next);
			
			}//outer end if else
		}//while end
		
	}//end decrementItem

	/**Locates the given item's position and updates the quantity to the given value. 
	 * Example: Milk, 1 updateItemQuantity(01, "Milk", 4) will result Inventory 01: Item: Milk QTY: 4
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be altered
	 * @param GivenitemQuantity the new value to be assigned to quantity 
	 */
	public void updateItemQuantity(Inventory givenInventory, String givenItemName, int givenItemQuantity) {
		
		Position<Item> current = givenInventory.itemInventory.first();
		Position<Item> next = givenInventory.itemInventory.after(current);
		
		while (next != null){	
			
			if (current.getElement().getItemName().toUpperCase() == givenItemName.toUpperCase()) {
				
				//Confirm the current quantity is greater than zero.
				if (givenItemQuantity >= 0 ) {

					current.getElement().setItemQuantity(givenItemQuantity);
					break;
				
				} else {
					
					throw new IllegalArgumentException("Quantity not valid. The quantity must be zero or greater.");
					
				}//end inner if
				
			} else {
				
				next = givenInventory.itemInventory.after(next);
			
			}//outer end if else
		}//while end
		
	}//end

	/**Creates and returns an item object, if the given quantity is zero or great the given quantity is used otherwise zero is used.
	 * 
	 * @param givenItemName name of the object to be created
	 * @param givenItemQuantity initial quantity of the object
	 */
	public Item createItem(String givenItemName, int givenItemQuantity) {
		
		Item newItem;
		
		if (givenItemQuantity < 0 ){
			
			newItem = new Item(givenItemName, 0);
			
			throw new IllegalArgumentException("Illegal given item quantity, the quantity must be zero or greater. Setting quantity to zero");
		
		} else {
			
			newItem = new Item(givenItemName, givenItemQuantity);
		}
		
		return newItem;
	
	}//end createItem

}//end InventoryManager
