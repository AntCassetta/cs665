package raiderInventories;

/**Dairy objects are Item subclass class objects represent real world items to be tracked within inventories. 
 * @author anthonycassetta
 */
public class ItemDairy extends RaiderItem{
	
	/**constructor for Diary objects
	 * @param givenItemName string name the item will be initialized with.
	 * @param givenItemQuantity integer quantity the item will be initialized with
	 */
	public ItemDairy(String givenItemName, int givenItemQuantity, String givenItemType) {
		super(givenItemName, givenItemQuantity, givenItemType);
	}

}//end Dairy