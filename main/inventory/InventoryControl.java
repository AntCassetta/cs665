package inventory;

import raiderInventories.RaiderInventory;
import raiderInventories.RaiderItem;

/**Inventory Control is the abstract class for mediating the instances of Inventory objects and Item objects.
 * @author anthonycassetta
 */

public interface InventoryControl {
	

	/**Assigns an inventory object an InventoryID and stores the object within a list for later reference
	 * @param newInventory The new inventory object to be assigned an inventoryID and stored.
	 */
	public RaiderInventory addInventory(String nickName, long inventoryID, String classType);
	
	
	/**Assigns an inventory object a nick name. Ex: "Kitchen"
	 * 
	 * @param givenName a string to assign to the inventories as a nick name
	 */
	public void setInventoryName(RaiderInventory givenInventory, String newName);
	
	
	/**Removes the given inventory object from the inventoryRoster. This inventoryID is not reclaimed.
	 * @param givenInventory the inventory object to be removed
	 */
	public void removeInventory(RaiderInventory givenInventory);
	
	
	// Inventory manipulators
	/**Checks if the inventory is empty*/
	public void isEmpty(RaiderInventory givenInventory);
	
	
	/**Prints contents of the inventory to the console*/
	public void printContents(RaiderInventory givenInventory);
	
	
	/**Prints out of stock contents of the inventory to the console*/
	public void printOOS(RaiderInventory givenInventory);
	
	
	/**Prints expired contents of the inventory to the console*/
	public void printEXP(RaiderInventory givenInventory);
	
	
	/**Attempts to create the new item object, upon success, the object will be added to the target inventory provided.
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be created
	 * @param GivenitemQuantity quantity of the item to be added
	 */
	public void addItem(RaiderInventory givenInventory, String givenItemName, int givenItemQuantity, String givenItemType);
	
	
	/**Locates and removes an Item object from the inventory.
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be removed
	 */
	public void removeItem(RaiderInventory givenInventory, String givenItemName);
	
	
	/**Locates the given item's position and increments the items quantity by 1 unit.
	 * Example: Milk, 1 incrementItem(01, "Milk") will result Inventory 01: Item: Milk QTY: 2
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be altered
	 */
	public void incrementItem(RaiderInventory givenInventory, String givenItemName);
	
	
	/**Locates the given item's position and decrements the items quantity by 1 unit.
	 * Example: Milk, 1 decrementItem(01, "Milk") will result Inventory 01: Item: Milk QTY: 0
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be altered
	 */
	public void decrementItem(RaiderInventory givenInventory, String givenItemName);
	
	
	/**Locates the given item's position and updates the quantity to the given value. 
	 * Example: Milk, 1 updateItemQuantity(01, "Milk", 4) will result Inventory 01: Item: Milk QTY: 4
	 * 
	 * @param givenInventory ID of the target inventory 
	 * @param givenItemName name of the item to be altered
	 * @param GivenitemQuantity the new value to be assigned to quantity 
	 */
	public void updateItemQuantity(RaiderInventory givenInventory, String givenItemName, int givenItemQuantity);
	
	
	//Item manipulators
	/**Creates and returns an item object
	 * 
	 * @param givenItemName name of the object to be created
	 * @param givenItemQuantity initial quantity of the object
	 */
	public RaiderItem createItem(String givenItemName, int givenItemQuantity, String givenItemType);

		
}//end InventoryControl