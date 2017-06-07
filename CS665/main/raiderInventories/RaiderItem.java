package raiderInventories;

//import java.util.Calendar;
//import java.util.Date;
import inventory.Item;

/**Item class objects represent real world items to be tracked within inventories. 
 * @author anthonycassetta
 */
public abstract class RaiderItem implements Item{	
	
	String itemName;
	int itemQuantity;
	String itemType;
	//Date dateAdded;
	//Date expDate;
	
	
	/**constructor for Item objects
	 * @param givenItemName string name the item will be initialized with.
	 * @param givenItemQuantity integer quantity the item will be initialized with.
	 * @param givenItemType is the category the item will be assigned/ Example: Dairy.
	 */
	public RaiderItem(String givenItemName, int givenItemQuantity, String givenItemType) {
		this.itemName = givenItemName;
		this.itemQuantity = givenItemQuantity;
		this.itemType = givenItemType;
		
	}//end Item Constructor
	

	/**returns the string name of the item
	 * @return itemName the string name of the item
	 */
	public String getItemName() { return itemName; }
	
	/**returns the integer value of the item quantity
	 * @return itemQuantity returns the integer value of the quantity
	 */
	public int getItemQuantity() { return itemQuantity; }
	
	
	/**returns the string type, or category, of the item
	 * @return itemName the string name of the item
	 */
	public String getItemType() { return itemType; }
	
	/**Sets the item quantity to the integer value given
	 * @param givenQuantity and integer value
	 */
	public void setItemQuantity(int givenQuantity) { itemQuantity = givenQuantity;}
	
}//end Item
