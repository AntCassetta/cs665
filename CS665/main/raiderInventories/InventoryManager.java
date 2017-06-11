package raiderInventories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import dataStructures.Position;
import inventory.InventoryControl;
import utilities.InvIterator;
import utilities.OOSIterator;


/**Inventory Manager is the concrete class for mediating the instances of Inventory objects and Item objects.
 * 
 * @author anthonycassetta
 */
public class InventoryManager extends Observable implements InventoryControl{
	
	private static final InventoryManager instance = new InventoryManager();
	protected ArrayList<RaiderInventory> inventoryRoster;
	int nextID = 00;

	
	/**Constructs an InventoryManager object*/
	private InventoryManager() {
		this.inventoryRoster = new ArrayList<RaiderInventory>();
	}//end constructor
	
	
	/** returns the singleton instance of the InventoryManager
	 * 
	 * @return the singleton instance of the InventoryManager
	 */
	public static InventoryManager getInstance(){ return instance; }
	
	
	public ArrayList<RaiderInventory> getInventoryRoster() {return inventoryRoster;}
	
	
	/**Assigns an inventory object an InventoryID and stores the object within a list for later reference
	 * @param newInventory The new inventory object to be assigned an inventoryID and stored.
	 */
	public RaiderInventory addInventory(String nickName, long inventoryID, String classType) {
		//TODO addInventory must create and add the inventoryGiven
		
		RaiderInventory newInventory = null;
		
		switch (classType.toUpperCase()) {
		
		case "REFRIGERATOR":
			newInventory = new Refrigerator(this, nickName, inventoryID);
			break;
		
		case "SHOPPINGLIST":
			newInventory = new ShoppingList(this, nickName, inventoryID);
			break;
		}//end switch
		
		this.inventoryRoster.add(newInventory);
		nextID++;
		//newInventory.setInventoryID(nextID);
		System.out.println(newInventory.toString());
		return newInventory;
		
	}//end addInventory
	
	
	/**Finds and returns an inventory based on matching the nick name and ID number.
	 * 
	 * @param nickName name assigned to the target inventory
	 * @param inventoryID ID number assigned to the target inventory
	 * @return The target inventory if found, null otherwise
	 */
	public RaiderInventory getInventory(String nickName, long inventoryID) {
		
		RaiderInventory targetInventory = null;
		Iterator<RaiderInventory> iter = inventoryRoster.iterator();
		 RaiderInventory cursor;
		 
		 while (iter.hasNext()) {
			 
			 cursor = iter.next();
			  if (cursor.getInventoryName().equals(nickName) && (long) cursor.getInventoryID() == (long)inventoryID ) {
				  targetInventory = cursor;
				  System.out.println(cursor.getInventoryID());
				  System.out.println("Found Inventory");
				  break;
			  }//end if
		
		 }//end while

		return targetInventory;

	}//end getInventory
	
	
	/**Assigns an inventory object a nick name. Ex: "Kitchen"
	 * 
	 * @param givenName a string to assign to the inventories as a nick name
	 */
	public void setInventoryName(RaiderInventory givenInventory, String newName) {
		
		givenInventory.setInventoryName(newName);
		
	}

	
	/**Removes the given inventory object from the inventoryRoster. This inventoryID is not reclaimed.
	 * @param givenInventory the inventory object to be removed
	 */
	public void removeInventory(RaiderInventory givenInventory) {
		
		for(RaiderInventory inv: inventoryRoster) {
			if( inv.getInventoryID() == givenInventory.getInventoryID() ){
				inventoryRoster.remove(givenInventory);
			}//end if
		}//end for
	}//end removeInventory

	
	/**Checks if the inventory is empty*/
	public void isEmpty(RaiderInventory givenInventory) {
		
				if (givenInventory.itemInventory.isEmpty()){
					System.out.println("Inventory "+ givenInventory.getInventoryID() + " \""+ givenInventory.getInventoryName()+ "\" is empty.");
				
				} else{
					System.out.println("Inventory "+ givenInventory.getInventoryID() + " \""+ givenInventory.getInventoryName()+ "\" has " 
											+ givenInventory.itemInventory.size() + " items.");
				}//end if else

	}//end is empty

	
	/**Prints contents of the inventory to the console*/
	public void printContents(RaiderInventory givenInventory) {
		
		try {
			Position<RaiderItem> walk = givenInventory.itemInventory.first();
			System.out.println("\nContents of "+ givenInventory.getInventoryName() + ":");
			
			while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
				
					System.out.println("Item: " + walk.getElement().getItemName() + " | Qty: " + walk.getElement().getItemQuantity());
					
					walk =  givenInventory.itemInventory.after(walk);
			}//while end
			System.out.println();
		} catch (IllegalArgumentException e) {
			System.out.println("\n" + givenInventory.getInventoryName() + " is empty.");
		}//end try catch
		}//end printContents

	
	/**Prints all OOS contents of the inventory to the console*/
	public void printOOS(RaiderInventory givenInventory) {
		
		InvIterator<RaiderItem> OOSIter = new OOSIterator(givenInventory);
		OOSIter.setToFirst();
		
		while (!OOSIter.isDone()) {
			
			RaiderItem temp = OOSIter.getCurrentElement();
			System.out.println("Item: " + temp.getItemName() + " | Qty: " + temp.getItemQuantity());
			
			OOSIter.increment();
			
		}//end while
		
		System.out.println("Total item's out of stock: " + OOSIter.getTotal());
	
	}//end printOOS
	
	
	/**Prints all EXP contents of the inventory to the console*/
	public void printEXP(RaiderInventory givenInventory) {
		
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
	public void addItem(RaiderInventory givenInventory, String givenItemName, int givenItemQuantity, String givenItemType) {
		
		RaiderItem newItem = createItem(givenItemName, givenItemQuantity, givenItemType);
		givenInventory.itemInventory.addLast(newItem);
		this.setChanged();
		this.notifyObservers(newItem);
		
	}//end addItem

	
	/**Locates and removes an Item object from the inventory.
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be removed
	 */
	public void removeItem(RaiderInventory givenInventory, String givenItemName) {
		
		
				
				Position<RaiderItem> walk = givenInventory.itemInventory.first();
				
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
	public void incrementItem(RaiderInventory givenInventory, String givenItemName) {
		
				Position<RaiderItem> walk = givenInventory.itemInventory.first();
				
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
	public void decrementItem(RaiderInventory givenInventory, String givenItemName) {
		
		Position<RaiderItem> walk = givenInventory.itemInventory.first();
		
		while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
			
			if ((walk.getElement().getItemName().toUpperCase().equals(givenItemName.toUpperCase()))) {
				
				int currentQTY = walk.getElement().getItemQuantity();
				
				//Confirm the current quantity is greater than zero.
				if (currentQTY > 0 ) {
	
					walk.getElement().setItemQuantity(currentQTY - 1);
					this.setChanged();
					this.notifyObservers(walk.getElement());
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
	public void updateItemQuantity(RaiderInventory givenInventory, String givenItemName, int givenItemQuantity) {
		
		Position<RaiderItem> walk = givenInventory.itemInventory.first();
		
		while (walk != givenInventory.itemInventory.after(givenInventory.itemInventory.last())) {	
			
			if ((walk.getElement().getItemName().toUpperCase().equals(givenItemName.toUpperCase()))) {
				
				int givenQTY = givenItemQuantity;
				
				//Confirm the given quantity is zero or greater.
				if (givenQTY >= 0 ) {
	
					walk.getElement().setItemQuantity(givenQTY);
					this.setChanged();
					this.notifyObservers(walk.getElement());
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
	public RaiderItem createItem(String givenItemName, int givenItemQuantity, String givenItemType) {
		
		ItemFactory ItemFactory = new ItemFactory();
		RaiderItem newItem;
		
		if (givenItemQuantity < 0 ){
			System.out.println("Illegal item quantity, the quantity of " + givenItemName + " must be zero or greater.\nSetting quantity to zero.");
			newItem = ItemFactory.getItem(givenItemName, 0, givenItemType);
			
			
		
		} else {
			
			newItem = ItemFactory.getItem(givenItemName, givenItemQuantity, givenItemType);
		}
		
		return newItem;
	
	}//end createItem


}//end InventoryManager
