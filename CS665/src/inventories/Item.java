package inventories;

//import java.util.Calendar;
//import java.util.Date;

/**Item class objects represent real world items to be tracked within inventories. 
 * @author anthonycassetta
 */
abstract class Item {	
	private String itemName;
	private int itemQuantity;
	//Date dateAdded;
	//Date expDate;
	
	
	/**constructor for Item objects
	 * @param givenItemName string name the item will be initialized with.
	 * @param givenItemQuantity integer quantity the item will be initialized with
	 */
	public Item(String givenItemName, int givenItemQuantity) {
		itemName = givenItemName;
		itemQuantity = givenItemQuantity;
		
	}//end Item Constructor
	
	/**returns the string name of the item
	 * @return itemName the string name of the item
	 */
	public String getItemName() { return itemName; }
	
	/**returns the int value of the item quantity
	 * @return itemQuantity returns the int value of the quantity
	 */
	public int getItemQuantity() { return itemQuantity; }
	
	/**Sets the item quantity to the int value given
	 * @param givenQuantity and int value
	 */
	public void setItemQuantity(int givenQuantity) { itemQuantity = givenQuantity;}
	
}//end Item
