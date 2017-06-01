package inventories;


import java.util.ArrayList;
import RefrigeratorRaider.*;
import dataStructures.Position;


/**Inventory Manager is the concrete class for mediating the instances of Inventory objects and Item objects.
 * 
 * @author anthonycassetta
 */
public class InventoryManager implements InventoryControl {
	
	protected ArrayList<Inventory> inventoryRoster;
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
	
	
	/**Assigns an inventory object a nick name. Ex: "Kitchen"
	 * 
	 * @param givenName a string to assign to the inventories as a nick name
	 */
	public void setInventoryName(Inventory givenInventory, String newName) {
		
		givenInventory.setInventoryName(newName);
		
	}

	
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
					System.out.println("Inventory "+ givenInventory.getInventoryID() + " \""+ givenInventory.getInventoryName()+ "\" is empty.");
				
				} else{
					System.out.println("Inventory "+ givenInventory.getInventoryID() + " \""+ givenInventory.getInventoryName()+ "\" has " 
											+ givenInventory.itemInventory.size() + " items.");
				}//end if else

	}//end is empty

	
	/**Prints contents of the inventory to the console*/
	public void printContents(Inventory givenInventory) {
		
		Position<Item> walk = givenInventory.itemInventory.first();
		System.out.println("\nContents of "+ givenInventory.getInventoryName() + ":");
		
		while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
			
				System.out.println("Item: " + walk.getElement().getItemName() + " | Qty: " + walk.getElement().getItemQuantity());
				
				walk =  givenInventory.itemInventory.after(walk);
		}//while end
		System.out.println();
	}//end printContents

	
	public void printOOS(Inventory givenInventory) {
		
		InvIterator<Item> OOSIter = new OOSIterator(givenInventory);
		OOSIter.setToFirst();
		
		while (!OOSIter.isDone()) {
			
			Item temp = OOSIter.getCurrentElement();
			System.out.println("Item: " + temp.getItemName() + " | Qty: " + temp.getItemQuantity());
			
			OOSIter.increment();
			
		}//end while
		
		System.out.println("Total item's out of stock: " + OOSIter.getTotal());
	
	}//end printOOS
	
	
	public void printEXP(Inventory givenInventory) {
		
		//InvIterator EXPIter = new EXPIterator();
		System.out.println("Not implimented yet");
	}
	
	
	/**Attempts to create the new Item object, upon success, the object will be added to the target inventory provided.
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be created
	 * @param GivenitemQuantity quantity of the item to be added
	 */
	@Override
	public void addItem(Inventory givenInventory, String givenItemName, int givenItemQuantity, String givenItemType) {
		
		Item newItem = createItem(givenItemName, givenItemQuantity, givenItemType);
		
		givenInventory.itemInventory.addLast(newItem);
		
	}//end addItem

	
	/**Locates and removes an Item object from the inventory.
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be removed
	 */
	public void removeItem(Inventory givenInventory, String givenItemName) {
		
		
				
				Position<Item> walk = givenInventory.itemInventory.first();
				
				while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
					
					if (walk.getElement().getItemName().toUpperCase().equals(givenItemName.toUpperCase())) {
						
						System.out.println("\nRemoving " + walk.getElement().getItemName());
						givenInventory.itemInventory.remove(walk);
						break;
					
					} else {
						
						walk = givenInventory.itemInventory.after(walk);
						if (walk == givenInventory.itemInventory.last()) {
							System.out.println("\nUnable to find item."); //if the code gets here the item is not present.
						}
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
		
				Position<Item> walk = givenInventory.itemInventory.first();
				
				while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
					
					if ((walk.getElement().getItemName().toUpperCase().equals(givenItemName.toUpperCase()))) {
						
						int currentQTY = walk.getElement().getItemQuantity();
						walk.getElement().setItemQuantity(currentQTY + 1);
						break;
					
					} else {
						walk = givenInventory.itemInventory.after(walk);
						if (walk == givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {
							System.out.println("\nUnable to find item."); //if the code gets here the item is not present.
						}
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
		
		Position<Item> walk = givenInventory.itemInventory.first();
		
		while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
			
			if ((walk.getElement().getItemName().toUpperCase().equals(givenItemName.toUpperCase()))) {
				
				int currentQTY = walk.getElement().getItemQuantity();
				
				//Confirm the current quantity is greater than zero.
				if (currentQTY > 0 ) {
	
					walk.getElement().setItemQuantity(currentQTY - 1);
					break;
				
				} else {
					
					System.out.println("Error: Cannot reduce the quantity below zero.");
					break;
					
				}//end inner if
			
			} else {
				walk = givenInventory.itemInventory.after(walk);
				if (walk == givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {
					System.out.println("\nUnable to find item."); //if the code gets here the item is not present.
				}
			
			}//end outer if else
			
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
		
		Position<Item> walk = givenInventory.itemInventory.first();
		
		while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
			
			if ((walk.getElement().getItemName().toUpperCase().equals(givenItemName.toUpperCase()))) {
				
				int givenQTY = givenItemQuantity;
				
				//Confirm the given quantity is zero or greater.
				if (givenQTY >= 0 ) {
	
					walk.getElement().setItemQuantity(givenQTY);
					break;
				
				} else {
					
					System.out.println("Error: Cannot reduce the quantity below zero.");
					break;
					
				}//end inner if
			
			} else {
				walk = givenInventory.itemInventory.after(walk);
				if (walk == givenInventory.itemInventory.last()) {
					System.out.println("\nUnable to find item."); //if the code gets here the item is not present.
				}
			
			}//end outer if else
			
		}//while end
		
	}//end updateItemQuantity

	
	/**Creates and returns an item object, if the given quantity is zero or great the given quantity is used otherwise zero is used.
	 * 
	 * @param givenItemName name of the object to be created
	 * @param givenItemQuantity initial quantity of the object
	 */
	public Item createItem(String givenItemName, int givenItemQuantity, String givenItemType) {
		
		ItemFactory ItemFactory = new ItemFactory();
		Item newItem;
		
		if (givenItemQuantity < 0 ){
			System.out.println("Illegal item quantity, the quantity of " + givenItemName + " must be zero or greater.\nSetting quantity to zero.");
			newItem = ItemFactory.getItem(givenItemName, 0, givenItemType);
			
			
		
		} else {
			
			newItem = ItemFactory.getItem(givenItemName, givenItemQuantity, givenItemType);
		}
		
		return newItem;
	
	}//end createItem


}//end InventoryManager
