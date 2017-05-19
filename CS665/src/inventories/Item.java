package inventories;

//import java.util.Calendar;
//import java.util.Date;

/**Item class objects represent real world items to be tracked within inventories. 
 * 
 * @author anthonycassetta
 */
public class Item {	
	private String itemName;
	private int itemQuantity;
	//Date dateAdded;
	//Date expDate;
	
	
	/**constructor for Item objects
	 * 
	 * @param givenItemName string name the item will be initialized with.
	 * @param givenItemQuantity integer quantity the item will be initialized with
	 */
	public Item(String givenItemName, int givenItemQuantity) {
		itemName = givenItemName;
		itemQuantity = givenItemQuantity;
		/*currentTime now = new currentTime();
		 *dateAdded = now.getInstanceDate();
		 *now.calendar.add(dateAdded., 14);
		 */
	}//end Item Constructor
	
	public String getItemName() { return itemName; }
	
	public int getItemQuantity() { return itemQuantity; }
	
	public void setItemQuantity(int givenQuantity) { itemQuantity = givenQuantity;}
	
}//end Item
